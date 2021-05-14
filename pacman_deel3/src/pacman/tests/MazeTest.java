package pacman.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import pacman.Direction;
import pacman.FoodItem;
import pacman.Maze;
import pacman.MazeDescriptions;
import pacman.MazeMap;
import pacman.PacMan;
import pacman.PowerPellet;
import pacman.Square;
import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Wormhole;

class MazeTest {
	
	Maze maze = MazeDescriptions.createMazeFromDescription(new Random(), """
			#####################
			#.........#.........#
			#.###.###.#.###.###.#
			#p###.###.#.###.###p#
			#.###.###.#.###.###.#
			#...................#
			#.###.#.#####.#.###.#
			#.###.#.#####.#.###.#
			#.....#...#...#.....#
			#####.### # ###.#####
			    #.#   G   #.#    
			    #.# #   # #.#    
			#####.# #   # #.#####
			     .  #GGG#  .     
			#####.# ##### #.#####
			    #.#       #.#    
			    #.# ##### #.#    
			#####.# ##### #.#####
			#.........#.........#
			#.###.###.#.###.###.#
			#p..#.....P.....#..p#
			###.#.#.#####.#.#.###
			###.#.#.#####.#.#.###
			#.....#...#...#.....#
			#.#######.#.#######.#
			#A.................D#
			#####################
			""");
	FoodItem[] foodItems = maze.getFoodItems();
	void testFoodItems() {
		assert foodItems.length == 1;
	}
	PowerPellet[] powerPellets =
		Arrays.stream(maze.getFoodItems())
			.flatMap(i -> i instanceof PowerPellet ? Stream.of((PowerPellet)i) : Stream.of())
			.sorted(Comparator.<PowerPellet>comparingInt(i -> i.getSquare().getRowIndex())
					          .thenComparingInt(i -> i.getSquare().getColumnIndex()))
			.toArray(n -> new PowerPellet[n]);

	@Test
	void testCreateFromMazeDescription() {
		assert powerPellets.length == 4;
		assert powerPellets[0].getSquare().equals(Square.of(maze.getMap(), 3, 1));
		assert powerPellets[1].getSquare().equals(Square.of(maze.getMap(), 3, 19));
		assert powerPellets[2].getSquare().equals(Square.of(maze.getMap(), 20, 1));
		assert powerPellets[3].getSquare().equals(Square.of(maze.getMap(), 20, 19));
	}
	
	@Test
	void testGetSize() {
		assert powerPellets[0].getSize() == 2;
	}
	
	
	DeparturePortal[] departurePortals = maze.getDeparturePortals();
	ArrivalPortal[] arrivalPortals = maze.getArrivalPortals();
	Wormhole wormhole = new Wormhole(departurePortals[0],arrivalPortals[0]);
	PacMan pacman = maze.getPacMan();
	MazeMap mazeMap = maze.getMap();
	
	void testWormholes() {
		pacman.setSquare(Square.of(mazeMap,departurePortals[0].getSquare().getRowIndex(),departurePortals[0].getSquare().getColumnIndex()));
		maze.movePacMan(Direction.UP);
		maze.addWormhole(wormhole);
		assert pacman.getSquare() == arrivalPortals[0].getSquare();
		maze.movePacMan(Direction.RIGHT);
		assert pacman.getSquare() == Square(mazeMap,arrivalPortals[0].getSquare().getRowIndex(), arrivalPortals[0].getSquare().getColumnIndex()+1;)
	}
}
