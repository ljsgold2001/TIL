
public class GoldCustomer extends Customer{
	
	double salesRatio;
	
	public GoldCustomer(int customerID ,String customerName) {
		super(customerID, customerName);
		this.customerID = customerID;
		this.customerName =customerName;
		
		bonusRatio = 0.02;
		salesRatio = 0.01;
		customerGrade = "GOLD";
		
	}

	@Override
	public int calcPrice(int price) {
		// TODO Auto-generated method stub
		bonusPoint +=price * bonusRatio;
		return price -(int)(price * salesRatio);
	}
	

}
