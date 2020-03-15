/**
	 * moves back to the previous room
	 */
public class BackCommand extends Command {

	public BackCommand() {
		super("back");
	}

	public boolean execute(Player player) {
		if (player.hasHistory()) {
			player.setCurrentRoom(player.removeHistory());
			System.out.println(player.getCurrentRoom().getLongDescription());
			if(player.hasHistory()) {
				player.update();
			}

			if (player.getCurrentRoom().equals(Game.getTarget()) && player.getInventory().containsKey("map")) {
				Game.winCondition();
			}
			;
		} else {
			System.out.println("I'm back at the beginning");
		}
		return false;
	}

}
