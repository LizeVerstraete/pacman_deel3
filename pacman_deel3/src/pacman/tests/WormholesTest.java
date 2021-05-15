package pacman.tests;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;

import pacman.Maze;
import pacman.MazeDescriptions;
import pacman.MazeMap;
import pacman.PacMan;
import pacman.Square;
import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Wormhole;

public class WormholesTest {
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
	MazeMap mazeMap = maze.getMap();
	//DeparturePortal[] departurePortals = maze.getDeparturePortals();
	//ArrivalPortal[] arrivalPortals = maze.getArrivalPortals();
	//maze.addWormhole(new Wormhole(departurePortals[0], arrivalPortals[2]));
	//maze.addWormhole(new Wormhole(departurePortals[0], arrivalPortals[0]));
	//maze.addWormhole(new Wormhole(departurePortals[1], arrivalPortals[1]));
	void test() {
		DeparturePortal departurePortal1 = new DeparturePortal(Square.of(mazeMap,1,1));
		DeparturePortal	departurePortal2 = new DeparturePortal(Square.of(mazeMap, 5, 3));
		ArrivalPortal arrivalPortal1 = new ArrivalPortal(Square.of(mazeMap,25,7));
		ArrivalPortal arrivalPortal2 = new ArrivalPortal(Square.of(mazeMap, 1, 4));
		Wormhole wormhole1 = new Wormhole(departurePortal1,arrivalPortal1);
		Wormhole wormhole2 = new Wormhole(departurePortal2,arrivalPortal1);
		maze.addWormhole(wormhole1);
		maze.addWormhole(wormhole2);
		
		assertEquals(Square.of(mazeMap,1,1),departurePortal1.getSquare());
		assertEquals(Square.of(mazeMap, 5, 3),departurePortal2.getSquare());
		assertEquals(Square.of(mazeMap,25,7),arrivalPortal1.getSquare());
		
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



