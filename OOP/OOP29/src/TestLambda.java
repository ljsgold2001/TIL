

interface PrintString{
	
	void showString(String str);
	
}

public class TestLambda {
	
	public static void showMyString(PrintString p) {
		p.showString("test2");
	}
	
	public static PrintString returnString() {
		return s->System.out.println(s + "!!!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintString lambdaStr =s->System.out.println(s);
		lambdaStr.showString("test");
		
		showMyString(lambdaStr);
		//매개변수로 전달하는 부분 
		
		PrintString test = returnString();
		test.showString("test4");

	}
	
	

}
