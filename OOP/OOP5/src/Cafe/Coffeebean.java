package Cafe;

public class Coffeebean {
	
	int money;
	
	public String order(int money) {
		this.money += money;
		
		if(money == Menu.BEANAMERICANO) {
			return "커피빈 아메리카노 주문 ";
			
		}
		else if(money ==Menu.BEANLATTE){
			return "커피빈 라떼 주문";
			
		}
		else {
			return null;
		}
	}

}
