
public abstract class Calculator implements Calc{
	
	//위에 abstract라는 키워드는 인터페이스에서 선언한것을 모두다 구현하지 않았을때 사용하는 키워드다.
	
	@Override
	public int add(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1-num2;
	}

	
	

}
