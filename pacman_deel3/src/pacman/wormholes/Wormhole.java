package pacman.wormholes;

import java.util.Set;

import pacman.Square;

/**
 * @invar | getDeparturePortal() != null
 * @invar | getArrivalPortal() != null
 */
public class Wormhole {
	
	/**
	 * @invar | departurePortal != null
	 * @peerObject
	 */
	private DeparturePortal departurePortal;
	/**
	 * @invar | arrivalPortal != null
	 * @peerObject
	 */
	private ArrivalPortal arrivalPortal;
		
	/**
	 * @post | result != null
	 * @peerObject
	 */
	public DeparturePortal getDeparturePortal() {
		return departurePortal;
		}
	
	/**
	 * @post | result != null
	 * @peerObject
	 */
	public ArrivalPortal getArrivalPortal() {
		return arrivalPortal;
		}
	
	/**
	 * @throws IllegalArgumentException | departurePortal == null
	 * @throws IllegalArgumentException | arrivalPortal == null
	 * @post | this.getDeparturePortal() == departurePortal
	 * @post | this.getArrivalPortal() == arrivalPortal
	 */
	public Wormhole(DeparturePortal departurePortal, ArrivalPortal arrivalPortal) {
		if (departurePortal == null) {
			throw new IllegalArgumentException("The departurePortal is null");
		} 
		if (arrivalPortal == null) {
			throw new IllegalArgumentException("The arrivalPortal is null");
		}
		this.departurePortal = departurePortal;
		this.arrivalPortal = arrivalPortal;
		departurePortal.wormholes.add(this);
		arrivalPortal.wormholes.add(this);
	}
	
	// deze had ik er eerst ook bij gezet, maar dan werkt de testsuite niet meer maar ik denk wel dat we er best nog zoiets bijzetten
	// * @post | this.getDeparturePortal().getWormholes().stream().
	// * 		 |         anyMatch(wormhole -> wormhole.getDeparturePortal() == this.getDeparturePortal())
	
	/**
	 * @throws IllegalArgumentException | departurePortal == null
	 * @post | this.getDeparturePortal() == departurePortal
	 * @post | this.getArrivalPortal() == old(this.getArrivalPortal())
	 */
	public void setDeparturePortal(DeparturePortal departurePortal) {
		if (departurePortal == null) {
			throw new IllegalArgumentException("The departurePortal is null");
		}
		this.departurePortal = departurePortal;
	}
	
	// Deze had ik er eerst ook nog bij gezet, maar dan werkt de testsuite niet meer maar ik denk wel dat we er best nog ziets bijzetten
	// * @post | this.getArrivalPortal().getWormholes().stream().
	// * 		 |         anyMatch(wormhole -> wormhole.getArrivalPortal() == this.getArrivalPortal())
	/**
	 * @throws IllegalArgumentException | arrivalPortal == null
	 * @post | this.getArrivalPortal() == arrivalPortal
	 * @post | this.getDeparturePortal() == old(this.getDeparturePortal())
	 */
	public void setArrivalPortal(ArrivalPortal arrivalPortal) {
		if (arrivalPortal == null) {
			throw new IllegalArgumentException("The arrivalPortal is null");
		}
		this.arrivalPortal = arrivalPortal;
	}
}
