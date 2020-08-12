
public class ComputerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Computer computer = new Computer();//불려질 메소드가 없는것이있기때문
		Computer computer = new Desktop();//형변환가능 타입은같지만 인스턴스는 하위
		computer.display();
		computer.turnOff();
		
		Computer myNote = new MyNoteBook();
	}	

}
