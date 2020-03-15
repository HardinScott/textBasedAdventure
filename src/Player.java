import java.util.LinkedList;
import java.util.Stack;

/**
 * This class represents players in the game. Each player has a current
 * location.
 * 
 * @author Michael Kolling modified by Rodrigo A. Obando (2018)
 * @version 1.0 (December 2002)
 */
public class Player implements Observable{
	private Room currentRoom;
	private Stack<Room> history;
	private ItemContainer inventory;
	private int maxCarryWeight;
	private int gold;
	private LinkedList<Observer> observers = new LinkedList<Observer>();

	/**
	 * Constructor for objects of class Player
	 */
	public Player(Room startingRoom) {
		currentRoom = startingRoom;
		history = new Stack<Room>();
		inventory = new ItemContainer();
		maxCarryWeight = 100;
		setGold(0);
	}

	/**
	 * Return the current room for this player.
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Set the current room for this player.
	 */
	public void setCurrentRoom(Room room) {
		currentRoom = room;
	}

	/**
	 * Try to walk in a given direction. If there is a door this will change the
	 * player's location.
	 */
	public boolean walk(String direction) {
		// Try to leave current room.
		boolean result = false;
		Room nextRoom = currentRoom.getExit(direction);

		if (nextRoom == null)
			System.out.println("I can't find that");
			
		else {
			setCurrentRoom(nextRoom);
			System.out.println(nextRoom.getLongDescription());
			result = true;
		}
		return result;
	}

	public Room addHistory(Room room) {
		return history.push(room);
	}

	public Room removeHistory() {
		return history.pop();
	}

	public boolean hasHistory() {
		return !history.isEmpty();
	}

	public boolean addToInventory(Item item) {
		return inventory.addItem(item);
	}

	public Boolean removeFromInventory(String name) {
		return (inventory.removeItem(name) != null ? true : false);
	}

	public void setMaxCarryWeight(int max) {
		this.maxCarryWeight = max;
	}

	public int getMaxCarryWeight() {
		return maxCarryWeight;
	}

	public ItemContainer getInventory() {
		return inventory;
	}
	
	public int calcScore() {
		return getGold() + inventory.calculateValue();
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	@Override
	public void subscribe(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void unsubscribe(Observer observer) {
		observers.remove(observer);
		
	}

	@Override
	public void update() {
		for(Observer observer : observers) {
			observer.update();
		}
		
	}
}
