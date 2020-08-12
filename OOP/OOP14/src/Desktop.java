
public class Desktop extends Computer {
	//상위의 메소드들중에 하나만 구현한다 하더라도 abstract 키워드가 있어야한다.
	public void display(){
		System.out.println("desktop display");
	}
	public void typing(){
		System.out.println("desktop typing");
		
	}
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("desktop turn off");
	}

 	
	

}
 