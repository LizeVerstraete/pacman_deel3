package pacman.wormholes;

import java.util.HashSet;
import java.util.Set;

import pacman.Square;

/**
 * @invar | getWormholes().stream().allMatch(wormhole -> wormhole != null && 
 * 		  |        wormhole.getArrivalPortal() == this)
 */
public class ArrivalPortal {
	private Square square; 
	
	/**
	 * @invar | wormholes != null
	 * @invar | wormholes.stream().allMatch(wormhole -> wormhole != null)
	 * @respresentationObject
	 */
	HashSet<Wormhole> wormholes = new HashSet <>();

	/**
	 * @peerObject
	 */
	public Square getSquare() {return square;}
	
	/**
	 * @invar | getWormholesInternal().stream().allMatch(s->s.getArrivalPortal() == this)
	 * @post | result != null && result.stream().allMatch(wormhole -> wormhole != null)
	 * @peerObjects
	 */
	Set<Wormhole> getWormholesInternal() {return Set.copyOf(wormholes);}
	
	/**
	 * @post | result != null && result.stream().allMatch(wormhole -> wormhole != null)
	 * @post | result.stream().allMatch(wormhole->wormhole.getArrivalPortal() == this)
	 * @creates | result
	 * @peerObjects
	 */
	public Set<Wormhole> getWormholes() {return Set.copyOf(wormholes);}
	
	/**
	 * @mutates | this
	 * @throws IllegalArgumentException | square == null
	 * @post | this.getSquare() == square
	 */
	public ArrivalPortal(Square square) {
		if (square == null) {
			throw new IllegalArgumentException("square is null");
		}
		this.square = square;	
	}
}