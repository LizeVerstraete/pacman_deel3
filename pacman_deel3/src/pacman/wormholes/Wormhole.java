package pacman.wormholes;

public class Wormhole {
	
	private ArrivalPortal arrivalPortal;
	private DeparturePortal departurePortal;
	
	public java.util.Set<Wormhole> getWormholes() {throw new IllegalStateException("Not yet implemented");}
	
	public Wormhole(DeparturePortal departurePortal, ArrivalPortal arrivalPortal) {
		this.departurePortal = departurePortal;
		this.arrivalPortal = arrivalPortal;
	}
	
	public DeparturePortal getDeparturePortal() {return departurePortal;}
	
	public ArrivalPortal getArrivalPortal() {return arrivalPortal;}
	
	public void setDeparturePortal(DeparturePortal departurePortal) {this.departurePortal = departurePortal;}
	
	public void setArrivalPortal(ArrivalPortal arrivalPortal) {this.arrivalPortal = arrivalPortal;}
}
