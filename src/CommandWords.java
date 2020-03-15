import java.util.HashMap;

/**
 * This class is the main class of the "World of Zuul" application. "World of
 * Zuul" is a very simple, text based adventure game.
 * 
 * This class holds a collection of all command words known to the game. It is
 * used to recognise commands as they are typed in.
 *
 * @author Michael Kolling and David J. Barnes modified by Rodrigo A. Obando
 *         (2018)
 * @version 2.0 (December 2002)
 */

public class CommandWords {
	private HashMap<String, Command> commands;

	/**
	 * Constructor - initialise the command words.
	 */
	public CommandWords() {
		commands = new HashMap<String, Command>();
		Command command = new GoCommand();
		commands.put(command.getName(), command);
		command = new HelpCommand(this);
		commands.put(command.getName(), command);
		command = new QuitCommand();
		commands.put(command.getName(), command);
		command = new PickupCommand();
		commands.put(command.getName(), command);
		command = new LookCommand();
		commands.put(command.getName(), command);
		command = new BackCommand();
		commands.put(command.getName(), command);
		command = new DropCommand();
		commands.put(command.getName(), command);
		command = new InventoryCommand();
		commands.put(command.getName(), command);
		command = new AppraiseCommand();
		commands.put(command.getName(), command);
		command = new ScoreCommand();
		commands.put(command.getName(), command);
		command = new TimeCommand();
		commands.put(command.getName(), command);
	}

	/**
	 * Given a command word, find and return the matching command object. Return
	 * null if there is no command with this name.
	 */
	public Command get(String word) {
		return commands.get(word);
	}

	/*
	 * Print all valid commands to System.out.
	 */
	public void showAll() {
		for (String commandName : commands.keySet()) {
			System.out.print(commandName + "  ");
		}
		System.out.println();
	}
}
