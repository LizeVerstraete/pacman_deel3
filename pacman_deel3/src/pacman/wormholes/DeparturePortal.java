package pacman.wormholes;

import pacman.Square;


import java.util.HashSet;
import java.util.Set;

/**
 * @invar | getWormholes().stream().allMatch(wormhole -> wormhole != null && 
 * 		  |        wormhole.getDeparturePortal() == this)
 */
public class DeparturePortal {
	private Square square;
	/**
	 * @invar | wormholes != null
	 * @invar | wormholes.stream().allMatch(wormhole -> wormhole != null)
	 * @representationObject
	 */
	// volgens mij moet dit private zijn, maar dan zou er nog een extra
	// functie addWormhole() ofzo moeten gemaakt worden
	public HashSet<Wormhole> wormholes = new HashSet <>();
	
	/**
	 * @peerObject
	 */
	public Square getSquare() {return square;}
	
	Set<Wormhole> getWormholesInternal() {return Set.copyOf(wormholes);}
	
	/**
	 * @post | result != null && result.stream().allMatch(wormhole -> wormhole != null)
	 * @post | result.stream().allMatch(wormhole -> wormhole.getDeparturePortal() == this)
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Wormhole> getWormholes() {return Set.copyOf(wormholes);}
	
	/**
	 * @mutates | this
	 * @throws IllegalArgumentException | square == null
	 * @post | this.getSquare() == square
	 */
	public DeparturePortal(Square square) {
		if (square == null) {
			throw new IllegalArgumentException("square is null");
		}
		this.square = square;
	}
}
