package pacman;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import pacman.wormholes.ArrivalPortal;
import pacman.wormholes.DeparturePortal;
import pacman.wormholes.Wormhole;

public class Maze {
	
	private Random random;
	private MazeMap map;
	private PacMan pacMan;
	private Ghost[] ghosts;
	private FoodItem[] foodItems;
	private DeparturePortal[] departurePortals;
	private ArrivalPortal[] arrivalPortals;
	private Wormhole[] wormholes;
	
	public DeparturePortal[] getDeparturePortals() {return departurePortals.clone();}
	
	public ArrivalPortal[] getArrivalPortals() {return arrivalPortals.clone();}
	
	public Wormhole[] getWormholes() {return wormholes.clone();}
	
	public void addWormhole(Wormhole wormhole) {
		if (!Set.of(arrivalPortals).contains(wormhole.getArrivalPortal()))
			throw new IllegalArgumentException("Wormhole's arrival portal is not in the maze");
		if (!Set.of(departurePortals).contains(wormhole.getDeparturePortal()))
			throw new IllegalArgumentException("Wormhole's departure portal is not in the maze");
		int i;
		Wormhole newWormholes[] = new Wormhole[wormholes.length + 1];
		for (i=0; i < wormholes.length; i++)
			newWormholes[i] = wormholes[i];
		newWormholes[wormholes.length] = wormhole;
		wormholes = newWormholes;

		;}
	
	public MazeMap getMap() { return map; }
	
	public PacMan getPacMan() { return pacMan; }
	
	public Ghost[] getGhosts() { return ghosts.clone(); }
	
	public FoodItem[] getFoodItems() { return foodItems.clone(); }
	
	public Maze(Random random, MazeMap map, PacMan pacMan, Ghost[] ghosts, FoodItem[] foodItems, DeparturePortal[] departurePortals, ArrivalPortal[] arrivalPortals) {
		this.random = random;
		this.map = map;
		this.pacMan = pacMan;
		this.ghosts = ghosts.clone();
		this.foodItems = foodItems.clone();
		this.arrivalPortals = arrivalPortals.clone();
		this.departurePortals = departurePortals.clone();
	}
	
	public boolean isCompleted() {
		return foodItems.length == 0;
	}
	
	private void checkPacManDamage() {
		for (Ghost ghost : ghosts)
			if (ghost.getSquare().equals(pacMan.getSquare()))
				ghost.hitBy(pacMan);
	}
	
	public void moveGhosts() {
		for (Ghost ghost : ghosts)
			ghost.move(random);
		checkPacManDamage();
	}
	
	public void pacManAtePowerPellet() {
		for (Ghost ghost : ghosts)
			ghost.pacManAtePowerPellet();
	}
	
	private void removeFoodItemsAtIndex(int index) {
		FoodItem[] newFoodItems = new FoodItem[foodItems.length - 1];
		System.arraycopy(foodItems, 0, newFoodItems, 0, index);
		System.arraycopy(foodItems, index + 1, newFoodItems, index, newFoodItems.length - index);
		foodItems = newFoodItems;
	}
	
	private void checkFoodItemCollision(Square square) {
		for (int i = 0; i < foodItems.length; i++) {
			if (foodItems[i].getSquare().equals(square)) {
				foodItems[i].eatenByPacMan(this);
				removeFoodItemsAtIndex(i);
				return;
			}
		}
	}
	
	public void movePacMan(Direction direction) {
		if (Set.of(departurePortals).contains(pacMan.getSquare()))
			{DeparturePortal departureportal = new DeparturePortal(pacMan.getSquare());
			 List<Wormhole> list = new ArrayList<Wormhole>(departureportal.getWormholes());
			 Square newSquare = list.get(random.nextInt(list.size())).getArrivalPortal().getSquare();
			}
		else {
			Square newSquare = pacMan.getSquare().getNeighbor(direction);
		
		if (newSquare.isPassable()) {
			pacMan.setSquare(newSquare);
			checkFoodItemCollision(newSquare);
			checkPacManDamage();
			
			}
		}
	}
	
}
