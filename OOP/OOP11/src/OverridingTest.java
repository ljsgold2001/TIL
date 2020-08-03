
public class OverridingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Customer customerLee = new Customer(10010,"이순신");
		customerLee.bonusPoint = 1000;
		
		
		VIPCustomer customerKim = new VIPCustomer(10020,"김유신");
		customerKim.bonusPoint = 10000;
		
		int priceLee = customerLee.calcPrice(10000);
		int priceKim = customerKim.calcPrice(10000);
		
		
		System.out.println(customerLee.showCustomerInfo() + "지불금액은 "+ priceLee+"원 입니다.");

		System.out.println(customerKim.showCustomerInfo()+ "지불 금액은 "+ priceKim +"원 입니다.");
		
		Customer customerNo = new VIPCustomer(10030,"나몰");
		customerNo.bonusPoint = 10000;
		System.out.println(customerNo.showCustomerInfo()+ "지불 금액은 "+ priceKim +"원 입니다.");
		//
		//Customer customerNo = new VIPCustomer
		//Customer 타입이기때문에 매소드는 customer것이 보이지만
		// 불리우는것은 뒤에있는 VIP인스턴스가 불리우게 된다.
		//이것이 가상메소드
	}

}
