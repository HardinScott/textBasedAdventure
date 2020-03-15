	/**
	 * removes items from players inventory and adds them to the current room's inventory
	 */
public class DropCommand extends Command {

	public DropCommand() {
		super("drop");
	}

	public boolean execute(Player player) {
		if (hasSecondWord()) {
			String itemName = getSecondWord();
			if (player.getInventory().containsKey(itemName)) {
				player.getCurrentRoom().getItems().addItem(player.getInventory().removeItem(itemName));
			} else {
				System.out.println("I don't have that item");
			}
		}
		return false;
	}
}