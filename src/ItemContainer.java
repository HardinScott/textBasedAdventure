/**
	 * holds item, delegates to a hashmap
	 */
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class ItemContainer {

	private HashMap<String, LinkedList<Item>> container;
	private String name;

	ItemContainer() {
		container = new HashMap<String, LinkedList<Item>>();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public HashMap<String, LinkedList<Item>> getContainer() {
		return container;
	}

	public String displayItems() {
		return container.toString();
	}

	public boolean addItem(Item item) {
		if (container.containsKey(item.getName())) {
			return container.get(item.getName()).add(item);
		} else {
			container.put(item.getName(), new LinkedList<Item>());
			return container.get(item.getName()).add(item);
		}
	}

	public Item removeItem(String name) {
		if (container.containsKey(name)) {
			Item temp = container.get(name).remove();
			if (container.get(name).isEmpty()) {
				container.remove(name);
			}
			return temp;
		} else {
			return null;
		}
	}

	public LinkedList<Item> get(String name) {
		return container.get(name);
	}

	public Collection<LinkedList<Item>> values() {
		return container.values();
	}

	public Set<String> keySet() {
		return container.keySet();
	}
	
	public boolean containsKey(String name) {
		return container.containsKey(name);
	}
	
	public int calculateValue() {
		int value = 0;
		for(String itemNames : container.keySet()) {
			for(Item item : container.get(itemNames)) {
				value += item.getValue();
			}
		}
		return value;
	}

}
