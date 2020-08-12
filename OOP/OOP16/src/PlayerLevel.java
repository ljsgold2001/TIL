
public abstract class PlayerLevel {
	
	
	public abstract void run();
	public abstract void jump();
	public abstract void turn();//바디 값이 존재하면 안된다.
	public abstract void showLevelMessage();
	
	
	public void go (int count) {
		run();
		for(int i =0; i<count; i++) {
			jump();
		}
		turn();
	}
	
}
