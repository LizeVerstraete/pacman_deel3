package pacman.wormholes;

import java.util.Set;

public class Wormhole {
	
	private ArrivalPortal arrivalPortal;
	private DeparturePortal departurePortal;
		

	public DeparturePortal getDeparturePortal() {return departurePortal;}
	public ArrivalPortal getArrivalPortal() {return arrivalPortal;}
	
	
	public Wormhole(DeparturePortal departurePortal, ArrivalPortal arrivalPortal) {
		this.departurePortal = departurePortal;
		this.arrivalPortal = arrivalPortal;
	}
	
	
	public void setDeparturePortal(DeparturePortal departurePortal) {this.departurePortal = departurePortal;}
	
	public void setArrivalPortal(ArrivalPortal arrivalPortal) {this.arrivalPortal = arrivalPortal;}
	
}
