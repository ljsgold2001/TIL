

class OutClass{
	
	private int num =10;
	private static int sNum = 20;
	private InClass inClass;
	
	public OutClass() {
		inClass = new InClass();
	}

	//맴버나 마찬가
	class InClass{ //맴버 변수를 선언하는자리이며 static도 아니고 메소드안에 있는것도 아니기때문에 instance 내부클래스다. 
		int iNum =100;
		//static int sInNum = 200; //Inclass 는 생성이되어야만 사용가능한데 그안에 static이 붙게되면 생성과 상관없이 사용되어야기때문이다.
		
		void inTest() {
			System.out.println(num); //outclass의 안이기때문에 outclass private사용가
			System.out.println(sNum);
		}
		
	}
	public void usingInner() {
		inClass.inTest();
	}
	//###################################################
	//static = outerclass 가 생성되지 않아도 사용할수 있다.
	static class InStaticClass{
		int inNum =100;
		static int sInNum = 200;
		
		void inTest() {
			System.out.println(inNum);
			System.out.println(sInNum);
			System.out.println(sNum);//oute클래스도 사용가
			

			
		}
		//static 내부의 static method
		static void sTest() {
			//System.out.println(inNum);클래스가 생성되어야지만 사용가능한
			System.out.println(sInNum);
			System.out.println(sNum);//oute클래스도 사용가
			
			
		}
		
	}
}

public class InnerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutClass outClass = new OutClass();
		outClass.usingInner();
		
		//OutClass.InClass myInClass = outClass.new InClass();
		//사실 이렇게쓰진 많이 않는다.내부에서만 쓰려고 만들었던것이기때문
		
		//###################################################\
		
		OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
		
		sInClass.inTest();
		OutClass.InStaticClass.sTest();

	}

}
