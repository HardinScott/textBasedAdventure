/**
	 * tells the player their current score
	 */
public class ScoreCommand extends Command{
	
	public ScoreCommand() {
		super("score");
	}
	
	public boolean execute(Player player) {
		System.out.println("Your current Score is " + player.calcScore());
		return false;
	}
}
