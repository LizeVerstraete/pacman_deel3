package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

import pacman.Square;

public class ArrivalPortal {
	public Square square;
	
	public HashSet<Wormhole> wormholes = new HashSet <>();

	public Square getSquare() {return square;}
	
	//Set<Wormhole> getWormholesInternal() {return Set.copyOf(wormholes);}
	
	public Set<Wormhole> getWormholes() {return Set.copyOf(wormholes);}
	
	public ArrivalPortal(Square square) {
		this.square = square;	
	}
}