
public class TakeTransTest {
	
	public static void main(String[] args) {
		Student student1 = new Student("jisoo" ,5000);
		Student student2 = new Student("joo" , 10000);
		Student student3 = new Student("Edward" , 20000);
		Bus bus100  = new Bus(100);
		Subway subwayGreen = new Subway(2);
		Subway subwayBlue = new Subway(4);
		Taxi taxi1010  = new Taxi(1010);
		
		student1.takeBus(bus100);
		student2.takeSubway(subwayGreen);
		student3.takeTaxi(taxi1010);
		
		student1.showInfo();
		student2.showInfo();
		student3.showInfo();
		
		bus100.showBusInfo();
		subwayGreen.showSubwayInfo();
		taxi1010.showTaxiInfo();
		
		
		
	}

}
