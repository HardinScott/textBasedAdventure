
/**
 * Implementation of the 'go' user command.
 * 
 * @author Michael Kolling modified by Rodrigo A. Obando (2018)
 * @version 1.0 (December 2002)
 */
public class GoCommand extends Command {
	/**
	 * Constructor for objects of class GoCommand
	 */

	public GoCommand() {
		super("go");
	}

	/**
	 * Try to go to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message. Returns always 'false'.
	 */
	public boolean execute(Player player) {
		if (hasSecondWord()) {
			String direction = getSecondWord();
			player.addHistory(player.getCurrentRoom());
			if (player.walk(direction)) {
				player.update();
			}
			if (player.getCurrentRoom().equals(Game.getTarget()) && player.getInventory().containsKey("map")) {
				Game.winCondition();
			}
			;

		} else {
			// if there is no second word, we don't know where to go...
			System.out.println("Go where?");
		}
		return false;
	}

}
