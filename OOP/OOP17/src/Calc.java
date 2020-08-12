
public interface Calc {
	double PI = 3.14;
	int ERROR = 9999999;
	
	int add (int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
	//public String stringAdd(String s1, String S2);
	default void descriprion() { // 디폴트 메서
		System.out.println("점수 계산기를 구현합니다.");
		myMethod();
	}
	
	static int total(int[] arr) {//정적메서
		int total = 0;
		
		for(int i : arr) {
			total +=i;
		}
		return total;
	}
	
	private void myMethod() {//java 10
		System.out.println("private method");
	}
	
	//private static void mystaticMethod()
	//위에 정적메서등네 삽해서 사용 가
}
