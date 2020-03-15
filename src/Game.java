
/**
 *
 * 
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game.
 * 
 * @author Michael Kolling and David J. Barnes modified by Rodrigo A. Obando
 *         (2018)
 * @version 1.1 (December 2002)
 */

class Game{
	private Parser parser;
	private static Player player;
	private static Room target;
	

	/**
	 * Create the game and initialise its internal map.
	 */
	public Game() {
		player = new Player(createWorld());
		parser = new Parser();
		player.subscribe(Timer.getInstance());
	}
	/**
	 * Initializes the world and gives a starting point
	 */
	public Room createWorld() {
		Room beach = new Room("A warm beach in the caribbean sea, gulls fly over head and smell of the sea envelops you");
		Room markets = new Room("in market place, the smell of fresh fish is distinct in the air");
		Room forum = new Room("in a bustling forum filled with discussion and gossip");
		Room barracks = new Room("in the parking lot at University Hall");
		Room gym = new Room("in a room with weighted equipment");
		Room housing = new Room("in the housing district, it's quiet here during the day");
		Room farmLand = new Room("inland, an ocean of farms and pastures have replaced the high seas");
		Room library = new Room("in a library, it's quiet");
		Room fields = new Room("in fields right outside the town. you see people playing sports all around");
		Room cove = new Room("cove");
		target = cove;
		
		cove.getItems().addItem(new Item(100, "gem", 5));
		
		cove.setExit("beach", beach);
		
		beach.getItems().addItem(new Item(5, "plank", 15));
		beach.getItems().addItem(new Item(10, "coconut", 6));
		beach.getItems().addItem(new Item(25, "glass", 1));	
		
		beach.setExit("forum", forum);
		beach.setExit("cove", cove);
		
		forum.getItems().addItem(new Item(100, "table", 90));
		forum.getItems().addItem(new Item(60, "chair", 50));
		forum.getItems().addItem(new Item(2, "torch", 5));
		forum.getItems().addItem(new Item(0, "stall", 99999));
		forum.getItems().addItem(new Item(0, "barrel", 99999));
		
		forum.setExit("beach", beach);
		forum.setExit("markets", markets);
		forum.setExit("housing", housing);
		forum.setExit("barracks", barracks);
		
		markets.getItems().addItem(new Item(0, "stall", 99999));
		markets.getItems().addItem(new Item(1, "sign", 10));
		markets.getItems().addItem(new Item(15, "chicken", 5));
		markets.getItems().addItem(new Item(30, "dog", 40));
		markets.getItems().addItem(new Item(15, "cat", 10));
		markets.getItems().addItem(new Item(0, "rat", 2));
		markets.getItems().addItem(new Item(0, "rat", 2));
		markets.setExit("housing", housing);
		markets.setExit("forum", forum);

		housing.getItems().addItem(new Item(50, "house", 99999));
		housing.getItems().addItem(new Item(50, "house", 99999));
		housing.getItems().addItem(new Item(50, "shed", 99999));
		housing.getItems().addItem(new Item(50, "dress", 10));
		housing.getItems().addItem(new Item(300, "diamond", 1));
		housing.getItems().addItem(new Item(150, "watch", 3));
		housing.getItems().addItem(new Item(500, "goldbar", 95));
		housing.getItems().addItem(new Item(75, "suit", 10));
		housing.getItems().addItem(new Item(35, "boots", 10));
		housing.getItems().addItem(new Item(10, "belt", 5));
		housing.getItems().addItem(new Item(125, "emerald", 2));
		housing.getItems().addItem(new Item(45, "handbag", 5));
		housing.getItems().addItem(new Item(50, "hat", 1));
		housing.getItems().addItem(new Item(100, "toolset", 25));
		housing.getItems().addItem(new Item(75, "telescope", 4));
		housing.getItems().addItem(new Item(25, "fishingpole", 6));
		housing.setExit("forum", forum);
		housing.setExit("fields", fields);
		housing.setExit("markets", markets);
		
		fields.setExit("housing", housing);
		fields.setExit("farmLand", farmLand);
		fields.setExit("barracks", barracks);

		farmLand.getItems().addItem(new Item(10, "rake", 6));
		farmLand.getItems().addItem(new Item(25, "hoe", 6));
		farmLand.getItems().addItem(new Item(25, "ox", 6));
		farmLand.getItems().addItem(new Item(25, "scyth", 6));
		farmLand.getItems().addItem(new Item(25, "knife", 6));
		farmLand.getItems().addItem(new Item(0, "map", 0));		
		farmLand.setExit("fields", fields);

		library.getItems().addItem(new Item(15, "book", 5));
		library.getItems().addItem(new Item(15, "book", 5));
		library.getItems().addItem(new Item(15, "book", 5));
		library.getItems().addItem(new Item(0, "shelf", 99999));
		library.getItems().addItem(new Item(0, "shelf", 99999));
		library.setExit("forum", forum);

		barracks.getItems().addItem(new Item(80, "musket", 30));
		barracks.getItems().addItem(new Item(25, "sword", 12));
		barracks.getItems().addItem(new Item(95, "breastplate", 45));
		barracks.getItems().addItem(new Item(0, "canon", 99999));
		barracks.getItems().addItem(new Item(60, "pistol", 15));
		barracks.setExit("forum", forum);
		barracks.setExit("gym", gym);
		barracks.setExit("fields", fields);

		gym.getItems().addItem(new Item(10, "weights", 10));
		gym.getItems().addItem(new Item(15, "weights", 15));
		gym.getItems().addItem(new Item(20, "weights", 20));
		gym.getItems().addItem(new Item(25, "weights", 25));
		gym.getItems().addItem(new Item(30, "weights", 30));
		gym.setExit("barracks", barracks);
		return beach;
	}
	
	/**
	 * Gives the room where the treasure is
	 */
	public static Room getTarget() {
		return target;
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();

		// Enter the main command loop. Here we repeatedly read commands and
		// execute them until the game is over.

		boolean finished = false;
		while (!finished) {
			Command command = parser.getCommand();
			if (command == null) {
				System.out.println("I don't understand...");
			} else {
				finished = command.execute(player);
			}
		}
		System.out.println("Thank you for playing.  Good bye.");
	}

	/**
	 * Lets the player win and tells them their score
	 */
	public static void winCondition() {
		if(Timer.getInstance().getTimer() < 20) {
			System.out.println("You found the treasure! your score is " + (player.calcScore() + 1000) + " see if you can get a better score next time. \nBye");
		}
		else {
			System.out.println("Someone else beat you to it, better luck next time.  your score is " + player.calcScore() + "\nBye");
		}
		System.exit(0);
	}
	/**
	 * Generates a welcome message
	 */
	private void printWelcome() {
		System.out.println();
		System.out.println("You're on a small island in the caribbean sea");
		System.out.println(
				"You came here to find a piece to a treasure map that will help you locate a treasure on the island");
		System.out.println("Be quick or someone might find it before you");
		System.out.println("\nType 'help' if you need help.");
		System.out.println();
		System.out.println(player.getCurrentRoom().getLongDescription());
	}


}
