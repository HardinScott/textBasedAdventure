
public class TimeCommand extends Command{

	public TimeCommand() {
		super("time");
	}
	/**
	 * Tells the player how many moves they've made
	 */
	public boolean execute(Player player) {
		System.out.println(Timer.getInstance().getTimer());
		return false;
	}
}
