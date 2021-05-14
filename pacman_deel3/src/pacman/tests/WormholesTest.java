package pacman.tests;

import java.util.Arrays;
import java.util.Random;

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
			#A.................D#
			#####################
			""");
	MazeMap mazeMap = maze.getMap();
	DeparturePortal[] departurePortals = maze.getDeparturePortals();
	ArrivalPortal[] arrivalPortals = maze.getArrivalPortals();
	//maze.addWormhole(new Wormhole(departurePortals[0], arrivalPortals[2]));
	//maze.addWormhole(new Wormhole(departurePortals[0], arrivalPortals[0]));
	//maze.addWormhole(new Wormhole(departurePortals[1], arrivalPortals[1]));
	DeparturePortal departurePortal1 = new DeparturePortal(Square.of(mazeMap,1,1));
	DeparturePortal	departurePortal2 = new DeparturePortal(Square.of(mazeMap, 5, 3));
	ArrivalPortal arrivalPortal1 = new ArrivalPortal(Square.of(mazeMap,25,7));
}
