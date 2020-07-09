
public class studentTest {

	public static void main(String[] args) {
		Student studentLee = new Student(100 , "LEE");
		studentLee.setKoreaSubject("국어", 100);
		studentLee.setMathSubject("수학", 95);
		
		Student studentKim = new Student(100 , "KIM");
		studentKim.setKoreaSubject("국어", 95);
		studentKim.setMathSubject("수학", 80);
		
		studentLee.showStudentScore();
		studentKim.showStudentScore();
	}
}
