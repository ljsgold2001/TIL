
public class Company {
	
	private static Company instance = new Company();
	
	private Company() {
		
	}
	
	public static Company getInstance() { //일반메소드라면 꼭 인스턴스가 생성되어야하는데 private이라서 접근을 못하때문
		if(instance == null) {//static 으로 생성해주는것이다.
			instance = new Company();
		}
		return instance;
	}
}
