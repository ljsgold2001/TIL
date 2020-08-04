import java.util.ArrayList;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer customer1 = new Customer(10020,"이순신 ");
		customer1.bonusPoint = 10000;
		
		Customer customer2 = new Customer(10020,"바보");
		customer2.bonusPoint = 10000;		
		
		VIPCustomer customer3 = new VIPCustomer(10030,"김유신 ");
		customer3.bonusPoint =10000;
				
		GoldCustomer customer4 = new GoldCustomer(10040,"박혁거세");
		customer4.bonusPoint =10000;
		
		GoldCustomer customer5 = new GoldCustomer(10040,"이지수");
		customer5.bonusPoint =10000;
		
		ArrayList<Customer> CustomerList = new ArrayList<Customer>();
		CustomerList.add(customer1);
		CustomerList.add(customer2);
		CustomerList.add(customer3);
		CustomerList.add(customer4);
		CustomerList.add(customer5);
		int price = 10000;
		
		for (Customer customer: CustomerList ) {
			int pay = customer.calcPrice(price);
			System.out.println(customer.showCustomerInfo());
			System.out.println(customer.getCustomerName() +"님은" + pay + "원을 지불하였습니다.");
			System.out.println(customer.getCustomerName() + " 님의 현재 보유포인트는 " + customer.bonusPoint+"입니다.");
		
		}
		


	}

}
