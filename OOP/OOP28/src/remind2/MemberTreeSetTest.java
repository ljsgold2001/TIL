package remind2;

public class MemberTreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MemberTreeSet manager = new MemberTreeSet();
		
		Member memberLee = new Member(100,"lee");
		Member memberKim = new Member(200,"kim");
		Member memberPark = new Member(300,"park");
		
		manager.addMember(memberLee);
		manager.addMember(memberKim);
		manager.addMember(memberPark);
		
		manager.showAllInfo();



	}

}
