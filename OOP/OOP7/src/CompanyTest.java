
public class CompanyTest {
	
	public static void main(String[] args) {
		Company company1 = Company.getInstance();
		Company company2 = Company.getInstance();
		
		System.out.println(company1);
		System.out.println(company2);
		
		//Company@4b1210ee
		//Company@4b1210ee 주소값이 같다. 백번불러도 하나의 인스턴스만 대답.
		//이것이 싱글톤패 - 유일한 인스턴스를 만들어야할
	}

}
