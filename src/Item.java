/**
	 * object for holding information that encompaces an item
	 */
public class Item {
	private int value;
	private String name;
	private int weight;
	
	public Item(int value, String name, int weight) {
		setValue(value);
		setName(name);
		setWeight(weight);
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
}
