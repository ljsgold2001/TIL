
public class Student {
	
	public static int serialNum =1000; //메모리의 공통의 부분을 바라보게 하기위해
	
	private int studentID; //private 이고 변하면 안되는 값이기때문에 get메소드만 부를수있게 한다.
	public String studentName;
	public String address;
	
	public Student(String name) {
		studentName = name;
		serialNum ++;
		studentID = serialNum;
	}
	
	public Student(int id, String name) {
		studentID = id;
		studentName = name;
		address = "주소 없음";
		serialNum++;
		studentID = serialNum;
		
		
	}
	
	public void showStudentInfo() {
		System.out.println(studentName + " ," +address);
		
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public int getStudentId() {
		return studentID;
		
	}

}
