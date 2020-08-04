
public class VIPCustomer extends Customer {
	
	int AgentID;
	double salesRatio;
	
	public VIPCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		this.customerID= customerID;
		this.customerName = customerName;
		
		customerGrade = "VIP";
		bonusRatio = 0.05;
		salesRatio = 0.01;
		
	}

	@Override
	public int calcPrice(int price) {
		// TODO Auto-generated method stub
		bonusPoint +=price * bonusRatio;
		return price -(int)(price * salesRatio);
	}
	
}
