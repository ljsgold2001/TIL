
public class StringTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String java = new String("java");
		String android = new String("android");
		System.out.println(System.identityHashCode(java));
		java = java.concat(android);
		//이러면 붙인 값이java의 변수안에 들어갔을것이라고 착각할 수 있다.
		System.out.println(java);
		System.out.println(System.identityHashCode(java));
	}

}
