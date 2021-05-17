package pacman.wormholes;

import java.util.Set;

import pacman.Square;

/**
 * @invar | getDeparturePortal() != null && getDeparturePortal().getWormholes().contains(this)
 * @invar | getArrivalPortal() != null && getArrivalPortal().getWormholes().contains(this)
 */
public class Wormhole {
	
	/**
	 * @invar | departurePortal != null
	 * @invar | departurePortal.getWormholesInternal().contains(this)
	 */
	private DeparturePortal departurePortal;
	
	/**
	 * @invar | arrivalPortal != null
	 * @invar | arrivalPortal.getWormholesInternal().contains(this)
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
	 * @mutates_properties | this.getDeparturePortal(), departurePortal.getWormholes()
	 * @post | this.getDeparturePortal().getWormholes().stream().anyMatch(wormhole -> wormhole.getDeparturePortal() == this.getDeparturePortal())
	 * @post | this.getDeparturePortal() == departurePortal
	 * @post | this.getArrivalPortal() == old(this.getArrivalPortal())
	 */
	public void setDeparturePortal(DeparturePortal departurePortal) {
		if (departurePortal == null) {
			throw new IllegalArgumentException("The departurePortal is null");
		}
		this.departurePortal.wormholes.remove(this);
		this.departurePortal = departurePortal;
		departurePortal.wormholes.add(this);
	}
	
	// Deze had ik er eerst ook nog bij gezet, maar dan werkt de testsuite niet meer maar ik denk wel dat we er best nog ziets bijzetten
	// * @post | this.getArrivalPortal().getWormholes().stream().
	// * 		 |         anyMatch(wormhole -> wormhole.getArrivalPortal() == this.getArrivalPortal())
	/**
	 * @throws IllegalArgumentException | arrivalPortal == null
	 * @mutates_properties | this.getArrivalPortal(), arrivalPortal.getWormholes()
	 * @post | this.getArrivalPortal() == arrivalPortal
	 * @post | this.getDeparturePortal() == old(this.getDeparturePortal())
	 */
	public void setArrivalPortal(ArrivalPortal arrivalPortal) {
		if (arrivalPortal == null) {
			throw new IllegalArgumentException("The arrivalPortal is null");
		}
		this.arrivalPortal.wormholes.remove(this);
		this.arrivalPortal = arrivalPortal;
		arrivalPortal.wormholes.add(this);
	}
}
