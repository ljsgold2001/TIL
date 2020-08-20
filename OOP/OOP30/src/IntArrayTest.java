import java.util.Arrays;

public class IntArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		
		int Sum = Arrays.stream(arr).sum();
		int count = (int) Arrays.stream(arr).count();//count의 반환이 long
		
		System.out.print(Sum);
		System.out.print(count);
		
		System.out.println(Arrays.stream(arr).reduce(0,(a,b) -> a+b))
		;
	}

}
