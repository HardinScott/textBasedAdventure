import java.util.LinkedList;

public class PickupCommand extends Command {
	public PickupCommand() {
		super("pickup");
	}
	/**
	 * Checks if the player is able to lift the object, then if they have enough carrying capacity to carry the target item, adds the item by removing it from the room's inventory
	 */
	public boolean execute(Player player) {

		if (hasSecondWord()) {
			String itemName = getSecondWord();

			if (player.getCurrentRoom().getItems().getContainer().containsKey(itemName)) {

				if (player.getCurrentRoom().getItems().get(itemName).peek().getWeight() < player.getMaxCarryWeight()) {
					int currentWeight = 0;
					for (LinkedList<Item> itemLists : player.getInventory().values()) {
						for (Item item : itemLists) {
							currentWeight += item.getWeight();
						}
					}
					if (currentWeight < player.getMaxCarryWeight()) {

						player.getInventory().addItem(player.getCurrentRoom().getItems().removeItem(itemName));
						if(itemName.equals("map")) {
							System.out.println("The treasure is in the cove!");
						}
					} else {
						System.out.println("I'm carrying too much");
					}
				} else {
					System.out.println("This item is too heavy to pickup");
				}
			} else {
				System.out.println("can't find item");
			}

		} else {
			System.out.println("pickup what?");
		}
		return false;
	}
}
