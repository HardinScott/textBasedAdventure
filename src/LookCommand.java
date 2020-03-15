/**
	 * prints a list of all items in a room
	 */
public class LookCommand extends Command {

	public LookCommand() {
		super("look");
	}

	public boolean execute(Player player) {
		System.out.print("I look around and I see: ");
		System.out.print(player.getCurrentRoom().getItems().keySet().toString());
		System.out.println();
		return false;
	}
}
