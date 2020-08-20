package innerremind;


class Outer2{
	int outNum =100;
	static int sNum =200;
	
	public Runnable getRunnable(final int i) {
		final int num = 100;
		
		return new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				System.out.println(num);
				System.out.println(i);
				System.out.println(outNum);
				System.out.println(Outer2.sNum);
				
			}
			
			
			
		};
	}
}
public class AnonymousInnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer2 outer = new Outer2();

		Runnable runnable = outer.getRunnable(50);
		
		runnable.run();
	}

}
