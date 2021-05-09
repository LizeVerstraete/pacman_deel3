package pacman.wormholes;

import pacman.Square;


import java.util.HashSet;
import java.util.Set;

public class DeparturePortal {
	private Square square;
	
	private HashSet<Wormhole> wormholes = new HashSet <>();
	
	public Square getSquare() {return square;}
	
	//Set<Wormhole> getWormholesInternal() {return Set.copyOf(wormholes);}
	
	public Set<Wormhole> getWormholes() {return Set.copyOf(wormholes);}
	
	public DeparturePortal(Square square) {
		this.square = square;
	}
}
