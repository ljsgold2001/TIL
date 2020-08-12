
public class MainBoardPlay {

	
	public static void main(String[] args) {
		Player player = new Player();
		player.play(3);
		
		AdvancedLevel alevel = new AdvancedLevel();
		player.upgradeLevel(alevel);
		player.play(4);
		
	}
}
