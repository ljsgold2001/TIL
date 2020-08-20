import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String>{

	@Override
	public String apply(String s1, String s2) {
		// TODO Auto-generated method stub
		if(s1.getBytes().length >= s2.getBytes().length)
			return s1;
		else return s2;
			}
	
}
public class ReduceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] greeting = {"안녕하세여 ~~~~","hello", "good morning", "반갑습니다."};
		
		System.out.println(Arrays.stream(greeting).reduce("",(s1,s2) ->
		{if(s1.getBytes().length >= s2.getBytes().length)
			return s1;
		else return s2;
			
		}));
		
		
		System.out.println(Arrays.stream(greeting).reduce(new CompareString()).get());
		
	}

}
