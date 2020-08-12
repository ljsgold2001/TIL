
public abstract class Computer {
	
	public abstract void display();//바디가 있는것과 없는 것은 다르다.
	public abstract void typing();//이런것들은 단독으로 쓰이기위함이 아다.
	
	public void trunOn() {
		System.out.println("전원을 켭니다. ");
		
	}
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}

}
