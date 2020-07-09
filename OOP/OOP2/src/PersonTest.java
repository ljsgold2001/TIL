
public class PersonTest {
	
	public static void main (String[] args) {
		Person person = new Person();
		
		person.age = 40;
		person.name = "james";
		person.isMarried = true;
		person.numOfChildren = 3;
		
		System.out.println("나이 :" + person.age);
		System.out.println("이름 :" + person.name);
		System.out.println("결혼 :" + person.isMarried);
		System.out.println("자녀수 :" + person.numOfChildren);

		
	}

}
