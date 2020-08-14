package remind3;

public class Member {

	private int memberId;
	private String memberName;
	
	public Member() {
		
	}
	
	public Member(int memberId , String memberName) {
		
		this.memberId = memberId;
		this.memberName = memberName;
		
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return memberId +"를 가진 회원의 이름은 " + memberName + "입니다.";
		
	}
	

	
	
	
	
	

}
