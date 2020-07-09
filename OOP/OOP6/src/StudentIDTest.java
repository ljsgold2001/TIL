
public class StudentIDTest {
	
	public static void main(String[] args) {
		Student studentLee = new Student("Lee");
		//System.out.println(studentLee.serialNum);
		
		Student studentKim = new Student("Kim");
		//System.out.println(studentKim.serialNum);
		//System.out.println(studentLee.serialNum);
		
		System.out.println(studentLee.getStudentId());
		System.out.println(studentKim.getStudentId());
		
	}

}
