package Cafe;

public class Person {
	
	String name;
	int money;
	
	public Person(String name, int money){
		this.name = name;
		this.money = money;
		
		
	}
	
	public void buyStarBucks(StarBucks scoffee, int money) {
		String message = scoffee.order(4000);
		
		if (message !=null) {
			this.money -=money;
			System.out.println(name + "은" +message +"남은 돈 " + this.money);
			
		}
	}
	
	public void buyCoffeeBean(Coffeebean bcoffee, int money) {
		String message = bcoffee.order(4500);
		if (message !=null) {
			this.money -=money;
			System.out.println(name + "은" +message +"남은 돈 " + this.money);
			
		}
	}

}
