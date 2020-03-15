	/**
	 * prints out a list of what the player is carrying
	 */
public class InventoryCommand extends Command{
	
	public InventoryCommand() {
		super("inventory");
	}

	public boolean execute(Player player) {
		if(player.getInventory().keySet().size() == 0) {
			System.out.println("I don't have anything");
		}
		else {
			System.out.println(player.getInventory().keySet().toString());
		}
		return false;
	}
}
