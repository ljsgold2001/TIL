
public class MemberHashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberHashMap manager = new MemberHashMap();
		
		Member memberLee = new Member(300,"Lee");
		Member memberKim = new Member(100,"Kim");
		Member memberPark = new Member(200,"Park");
		Member memberPark2 = new Member(300, "Park2");

		manager.addMember(memberLee);
		manager.addMember(memberKim);
		manager.addMember(memberPark);

		
		manager.showAllMember();
		//manager.remove(100);
		
		manager.showAllMember();

		manager.removeMember(200);
		manager.showAllMember();

		
	}

}
