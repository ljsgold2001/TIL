package Cafe;

public class StarBucks {
	int money;
	
	public String order(int money) {
		
		this.money += money;
		
		if (money == Menu.STARAMERICANO) {
			return "스타벅스 아메리카노 주문";
		}
		else if(money == Menu.STARLATTE){
			return "스타벅스 라떼 주문";
		}
		else {
			return null;
		}
		
	}

}
