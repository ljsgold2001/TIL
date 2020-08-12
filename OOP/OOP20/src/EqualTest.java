class Student{
	int studentNum;
	String  studentName;
	
	public Student(int studentNum ,  String studentName) {
		this.studentName = studentName;
		this.studentNum = studentNum;
		
		
		
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if(obj instanceof Student) {
			Student std = (Student)obj;
			return(this.studentNum == std.studentNum);
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return studentNum;
		//멤버들을 이용해서return을 통해서 코딩한다.
	}

	
	
	
	
	
	
}


public class EqualTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = new String("ABC");
		String str2 = new String("ABC");
		
		System.out.println(str1 == str2);//메모리가 같은지만 확인한다.
		System.out.println(str1.equals(str2));//stirng일 경우 문자열이 같으면 같다고 반환한다고 정의되어있음
		
		
		Student Lee = new Student(100 , "이순신 ");
		Student Lee2 = Lee;
		Student Shin = new Student(100 , "이순신 ");
		
		System.out.println(Lee == Shin);
		System.out.println(Lee.equals(Shin));
		
		System.out.println(Lee.hashCode());
		System.out.println(Shin.hashCode());
		
		Integer  l1 = new Integer(100);
		Integer l2 = new Integer(100);
		
		System.out.println(l1.equals(l2));
		System.out.println(l1.hashCode());
		System.out.println(l2.equals(l2));
		
		//실제 메모리 주소를 알고싶을때
		System.out.println(System.identityHashCode(l1));
		System.out.println(System.identityHashCode(l2));
		//1259475182
		//1300109446 해시코드값이 동일하진 않다.

	}

}
