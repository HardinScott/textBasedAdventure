import java.util.Random;
/**
 * gives an approximate value to a target item
 */
public class AppraiseCommand extends Command{
	public AppraiseCommand() {
		super("appraise");
	}
	
	public boolean execute(Player player) {
		Random rand = new Random();
		if(hasSecondWord()) {
			String itemName = getSecondWord();			
			float aproxValue = (player.getInventory().get(itemName).peek().getValue() * (((float)(rand.nextInt(4) + 8)) /(float) 10));
			System.out.format("You think that %s might be worth %.0f", itemName, aproxValue);
			System.out.println();
		}
		return false;
	}
}
