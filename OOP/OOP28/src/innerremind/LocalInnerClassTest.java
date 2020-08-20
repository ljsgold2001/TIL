package innerremind;



class Outer{
	int outNum =100;
	static int sNum =200;
	
	public Runnable getRunnalbe(final int i) {
		final int num = 100;
		
		class MyRunnalbe implements Runnable{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				System.out.println(num);
				System.out.println(i);
				System.out.println(outNum);
				System.out.println(Outer.sNum);
				
			}
			
			
			
			
		}
		return new MyRunnalbe();
	}
}
public class LocalInnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Outer outer = new Outer();
		Runnable runnable = outer.getRunnalbe(50);
		runnable.run();

	}

}
