
public class CalcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompleteCalc calc  = new CompleteCalc();
		
		int n1 = 10;
		int n2 = 2;
		
		System.out.println(calc.add(n1, n2));
		System.out.println(calc.substract(n1, n2));

		System.out.println(calc.times(n1, n2));

		System.out.println(calc.divide(n1, n2));
		
		calc.descriprion(); //completecalc 에 오버라이딩해서 재정의 해놓았기때문에 새로만든 new인스턴스에 재정의 된 함수가 불린다.
		
		int[] arr = {1,2,3,4,5};
		
		int sum = Calc.total(arr);//이건 new 객체를 만든것이 아니다. 그냥 CALC타입을 써야함
		System.out.println(sum);
	}
	
	
}
