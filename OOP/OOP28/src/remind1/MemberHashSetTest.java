package remind1;

public class MemberHashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MemberHashSet manager = new MemberHashSet();
		
		Member memberLee = new Member(100,"lee");
		Member memberkim  = new Member(200, "kim");
		Member memberpark = new Member(300,"parrk");
		
		manager.addMember(memberLee);

		manager.addMember(memberkim);
		
		manager.addMember(memberpark);
		
		manager.showAllMember();
		
		
	}
	

}
