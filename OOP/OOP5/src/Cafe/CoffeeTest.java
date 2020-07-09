package Cafe;

public class CoffeeTest {
	public static void main(String[] args) {

		Person kim = new Person("Kim", 10000);
		Person Lee = new Person("Lee", 10000);
		StarBucks starCoffee = new StarBucks();
		Coffeebean beanCoffee = new Coffeebean();
		
		kim.buyStarBucks(starCoffee, Menu.STARAMERICANO);
		Lee.buyCoffeeBean(beanCoffee, Menu.BEANLATTE);

	}

}
