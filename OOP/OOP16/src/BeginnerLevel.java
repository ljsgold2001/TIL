
public class BeginnerLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("beginner의 속도로 달립니다.");
		
	}

	@Override
	public void jump() {
		System.out.println("beginner의높이로 점프합니다.");
	}

	@Override
	public void turn() {
		System.out.println("beginner의 속도로 turn");
		
	}

	@Override
	public void showLevelMessage() {
		System.out.println("========beginner========");
	}

}
