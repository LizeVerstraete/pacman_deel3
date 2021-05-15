package pacman.tests;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.Set;

import org.junit.Test;

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

public class WormholeTest {

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
			#...................#
			#####################
			""");
	
	//DeparturePortal[] departurePortals = maze.getDeparturePortals();
	//ArrivalPortal[] arrivalPortals = maze.getArrivalPortals();
	//maze.addWormhole(new Wormhole(departurePortals[0], arrivalPortals[2]));
	//maze.addWormhole(new Wormhole(departurePortals[0], arrivalPortals[0]));
	//maze.addWormhole(new Wormhole(departurePortals[1], arrivalPortals[1]));
	MazeMap mazeMap = maze.getMap();
	@Test
	public void test() {
		DeparturePortal departurePortal1 = new DeparturePortal(Square.of(mazeMap,1,1));
		DeparturePortal	departurePortal2 = new DeparturePortal(Square.of(mazeMap, 5, 3));
		ArrivalPortal arrivalPortal1 = new ArrivalPortal(Square.of(mazeMap,2,1));
		ArrivalPortal arrivalPortal2 = new ArrivalPortal(Square.of(mazeMap, 1, 4));
		//assertEquals(Set.of(departurePortal1,departurePortal2),maze.getDeparturePortals());
		//assertEquals(Set.of(arrivalPortal1,arrivalPortal2), maze.getArrivalPortals());
		Wormhole wormhole1 = new Wormhole(departurePortal1,arrivalPortal1);
		Wormhole wormhole2 = new Wormhole(departurePortal2,arrivalPortal1);
		
		assertEquals(Square.of(mazeMap,1,1).getColumnIndex(),departurePortal1.getSquare().getColumnIndex());
		assertEquals(Square.of(mazeMap,1,1).getRowIndex(),departurePortal1.getSquare().getRowIndex());
		assertEquals(Square.of(mazeMap, 5, 3).getColumnIndex(),departurePortal2.getSquare().getColumnIndex());
		assertEquals(Square.of(mazeMap, 5, 3).getRowIndex(),departurePortal2.getSquare().getRowIndex());
		assertEquals(Square.of(mazeMap,2,1).getColumnIndex(),arrivalPortal1.getSquare().getColumnIndex());
		assertEquals(Square.of(mazeMap,2,1).getRowIndex(),arrivalPortal1.getSquare().getRowIndex());
		
		assertEquals(arrivalPortal1,wormhole1.getArrivalPortal());
		assertEquals(departurePortal2,wormhole2.getDeparturePortal());
		assertEquals(departurePortal1,wormhole1.getDeparturePortal());

		assertEquals(Set.of(wormhole1,wormhole2),arrivalPortal1.getWormholes());
		assertEquals(Set.of(wormhole1),departurePortal1.getWormholes());
		assertEquals(Set.of(wormhole2),departurePortal2.getWormholes());
		
		wormhole1.setDeparturePortal(departurePortal2);
		wormhole2.setDeparturePortal(departurePortal1);
		wormhole1.setArrivalPortal(arrivalPortal2);
		
		assertEquals(arrivalPortal2,wormhole1.getArrivalPortal());
		assertEquals(departurePortal1,wormhole2.getDeparturePortal());
		assertEquals(departurePortal2,wormhole1.getDeparturePortal());
	}

}
