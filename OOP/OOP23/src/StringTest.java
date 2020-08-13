
public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println(str1 == str2);
		//메모리의 위치가 다르기때문에 false
		//new 를 했을때는 heaparea 에서 가져오는것이기때문에 주소가다
		String str3 = "abc";
		String str4 = "abc";
		
		System.out.println(str3 == str4);
		//이것은 상수 pool에서 가져오는 것이기 때문에 true
		//여기서는 상수pool에서 그대로 가져오는것이다.
	}

}
