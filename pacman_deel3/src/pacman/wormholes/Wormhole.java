package pacman.wormholes;

import java.util.Set;

import pacman.Square;

public class Wormhole {
	
	private DeparturePortal departurePortal;
	private ArrivalPortal arrivalPortal;
		

	public DeparturePortal getDeparturePortal() {return departurePortal;}
	public ArrivalPortal getArrivalPortal() {return arrivalPortal;}
	
	
	public Wormhole(DeparturePortal departurePortal, ArrivalPortal arrivalPortal) {
		this.departurePortal = departurePortal;
		this.arrivalPortal = arrivalPortal;
		departurePortal.wormholes.add(this);
		arrivalPortal.wormholes.add(this);
	}
	
	
	public void setDeparturePortal(DeparturePortal departurePortal) {
		this.departurePortal = departurePortal;
	}
	
	public void setArrivalPortal(ArrivalPortal arrivalPortal) {
		this.arrivalPortal = arrivalPortal;
	}
	
}
