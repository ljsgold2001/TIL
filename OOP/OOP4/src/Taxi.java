
public class Taxi {
	int TaxiNumber;
	int passengerCount;
	int money;
	
	public Taxi(int TaxiNumber) {
		this.TaxiNumber = TaxiNumber;
		
	}
	
	public void take(int money) {
		this.money += money;
		this.passengerCount ++;
		
	}
	
	public void showTaxiInfo() {
		System.out.println("승객" + passengerCount + "돈은"+money);
		
	}
	
	

}
