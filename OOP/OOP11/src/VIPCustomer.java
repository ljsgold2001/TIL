
public class VIPCustomer extends Customer {
	
	
	double salesRatio;
	private int agentID;
	
	/*public VIPCustomer () {
		
		customerGrade = "VIP"; //customer에서 private이면 이게 안됨 따라서 protected로 사용해야함
		bonusRatio = 0.05;
		salesRatio = 0.1;
		
	}
	*/
	//위에있는 기본생성자를 사용했을때 상위클래스에있는 동일한 기본생성자를 부르는데 customer에 존재하지 않는다.
	//따라서 customer과 같은 생성자를 만들어준후에 Super키워드를 사용해야한다.
	public VIPCustomer(int customerID, String customerName ) {
		super(customerID, customerName);
		
		customerGrade = "VIP"; //customer에서 private이면 이게 안됨 따라서 protected로 사용해야함
		bonusRatio = 0.05;
		salesRatio = 0.1;
		
	}

	@Override
	public int calcPrice(int price) {
		// TODO Auto-generated method stub
		bonusPoint +=price * bonusRatio;
		return price -(int)(price * salesRatio);
		
	}
	
}
