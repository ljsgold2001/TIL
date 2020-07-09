
public class Student {
	
	int studentID;
	String studentName;
	
	Subject korea;
	Subject math;
	
	//string 은 바로 new 하지만 나머지는 생성자를 선언하고 사용해야
	public Student(int id, String name) {
		
		studentID = id;
		studentName = name;
		
		korea = new Subject();
		math = new Subject();
		
	}
	
	public void setKoreaSubject(String name, int score) {
		
		korea.subjectName = name;
		korea.score = score;
		
		
	}
	public void setMathSubject(String name, int score) {
		
		math.subjectName = name;
		math.score = score;
		
		
	}
	
	public void showStudentScore() {
		int total = korea.score + math.score;
		System.out.println(studentName+ "학생의 총점" + total);
	}
	
}
