/**
	 * counts the number of times the player has moved rooms
	 */
class Timer implements Observer{
	private static Timer instance = null;
	private int time;	
	
	public static Timer getInstance() {
		if(instance == null) {
			return instance = new Timer();
		}
		else {
			return instance;
		}
	}
	public int getTimer() {
		return getInstance().time;
	}
	public void incrementTimer() {
		getInstance().time++;
	}
	@Override
	public void update() {
		incrementTimer();		
	}
}
