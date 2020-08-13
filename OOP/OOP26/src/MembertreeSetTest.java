
public class MembertreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MembertreeSet manager = new MembertreeSet();
		
		Member memberLee = new Member(300,"Lee");
		Member memberKim = new Member(100,"Kim");
		Member memberPark = new Member(200,"Park");

		manager.addMember(memberLee);
		manager.addMember(memberKim);
		manager.addMember(memberPark);

		
		manager.showAllMember();
		//manager.remove(100);
		
		manager.showAllMember();

		
	}

}
