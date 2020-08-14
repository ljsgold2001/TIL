package remind3;

public class MemberHashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MemberHashMap manager = new MemberHashMap();
		
		Member memberLee = new Member(300,"Lee");
		Member memberKim = new Member(100,"Kim");
		Member memberPark = new Member(200,"Park");
		
		manager.addMember(memberLee);
		manager.addMember(memberKim);
		manager.addMember(memberPark);
		
		manager.showAllMember();
		
		manager.removeMember(100);

		manager.showAllMember();
		//hashmap은 key값으로 정렬하는 자료구조이다.
		
		
		
		

	}

}
