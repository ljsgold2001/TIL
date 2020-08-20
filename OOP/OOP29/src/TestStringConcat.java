
public class TestStringConcat {
	//기존의 방식 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringConImpl impl = new StringConImpl();
		impl.makeString("hello", "world");
		
	//람다
		StringConcat concat = (s,v) ->System.out.println(s+","+v);
		concat.makeString("hello", "world");
		
		//사실 익명으로 만든다.
	}

}

