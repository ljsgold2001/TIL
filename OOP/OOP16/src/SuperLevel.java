
public class SuperLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("Super의 속도로 달립니다.");
		
	}

	@Override
	public void jump() {
		System.out.println("Super의높이로 점프합니다.");
	}

	@Override
	public void turn() {
		System.out.println("Super의 속도로 turn");
		
	}

	@Override
	public void showLevelMessage() {
		System.out.println("========Super========");
	}

}
