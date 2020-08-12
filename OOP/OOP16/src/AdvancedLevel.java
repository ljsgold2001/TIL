
public class AdvancedLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("advanced의 속도로 달립니다.");
		
	}

	@Override
	public void jump() {
		System.out.println("advanced의 속도로 점프합니다..");
	}

	@Override
	public void turn() {
		System.out.println("trun 불가 ");
		
	}

	@Override
	public void showLevelMessage() {
		System.out.println("========advanced========");
	}

}
