package innerremind;
//#####################################################
//outclass선
class OutClass {
	private int num = 0;
	private static int sNum = 20;
	private InClass inClass;
	//outclass를 생성하면 Inclass를 생성해주는 기본 생성
	public OutClass() {
		inClass = new InClass();
	}
	//InClass 생성 
	class InClass{
		int iNum =10;
		//InClass 안에 intest 메서드 선언 num과sNum은 outclass의 private이지만 inclass가 outclass에 포함되니까 가능 
		void inTest() {
			System.out.println(num);
			System.out.println(sNum);
		}
	}
	//inclass를 사용할수있는 메서드 선언 
	public void usingInner() {
		inClass.inTest();
	}
	//static class 선언 outclass안에서 
	static class InStaticClass{
		int inNum =100;
		static int sInNum =200;
		//static class 안의 일반 메서
		void inTest() {
			System.out.println(inNum);
			System.out.println(sInNum);
			//System.out.println(sNum); 이렇게 되버리면 outclass의 snum은 private인데 static으로 접근가능해지니까 outclass 선언할때 static을 붙여줘야함
			System.out.println(sNum);
		}
		//staticclass 안의 static method
		
		static void sTest() {
			//System.out.println(inNum);
			System.out.println(sInNum);
			System.out.println(sNum);
		}
		
	}
	
	
}
//#####################################################

public class Innertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OutClass outClass = new OutClass();
		outClass.usingInner();
		
		OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
		sInClass.inTest();
		System.out.println("abc");
		//warining@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		OutClass.InStaticClass.sTest();

	}

}
