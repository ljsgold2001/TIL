
class Outer{
	
	int outNum =100;
	static int sNum =200;
	
	//메서드 Runnalbe한 객체를 반환하는 메서드 
	public Runnable getRunnable(final int i) {
		//매개변수인 i 와 num은 지역변수이며 이 메서드가불려서 끝날때까지 유효 따라서 final 
		final int num = 100;
		//메서드 안에 클래스를 만들었기 때문에 지역클래
		class MyRunnable implements Runnable{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				//값은 변경을 할 수가 없다.
				//num +=10;
				//i = 200;
				System.out.println(num);
				System.out.println(i);
				System.out.println(outNum);
				System.out.println(Outer.sNum);
				
			}
			
		}
		return new MyRunnable();
	}
}



public class LocalInnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Outer outer = new Outer();
		Runnable runnable = outer.getRunnable(50);
		
		runnable.run();

	}

}
