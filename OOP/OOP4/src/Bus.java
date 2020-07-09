
public class Bus {
	
	int busNumber;
	int passengerCount;
	int money;
	
	public Bus(int busNumber) { // 초기
		this.busNumber = busNumber;
	}
	
	public void take(int money) { //승차메소
		this.money += money;
		passengerCount ++;
	}
	
	public void showBusInfo() {
		System.out.println("승객" + passengerCount +"돈"+money);
	}

}
