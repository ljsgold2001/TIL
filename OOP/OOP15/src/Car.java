
public abstract class Car {
	
	public abstract void start();
	public abstract void drive();
	public abstract void stop();
	public abstract void turnoff();
	
	
	public void run() {
		start();
		drive();
		stop();
		turnoff();
		//washCar();//이순서는 꼭지켜져야한다. 따라서 재정의 되면 안된다.final키워드 
	}
}
