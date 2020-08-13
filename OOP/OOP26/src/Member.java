import java.util.Comparator;

public class Member implements Comparator<Member>{
//public class Member implements Comparable<Member>
	private int memberId;
	private String memberName;
	
	public Member() {
		
	}
	
	public Member(int memberId, String memberName) {
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
	
	public String toString() {
		return memberName + "회원님의 아이디는 " + memberId+ "입니다. ";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return memberId;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Member) {
			
			Member member = (Member)obj;
			return (this.memberId == member.memberId);
		}
		return false;
	}
	/*
	 * 
	//treeset이라서 튀어나오는 부분
	//this인 나하고 넘어온 매개변수랑 비교해주면 된다. 
	@Override
	public int compareTo(Member member) {
		
		//return (this.memberId - member.memberId); //양수반환이면 오름차순 반환 
	//내림차순이려면 바꿔주면 된다.
		return this.memberName.compareTo(member.getMemberName());
		//이건 이름순 정
	}
	 */

	@Override
	public int compare(Member member1, Member member2) {
		// TODO Auto-generated method stub
		//1번째가 this, 2번째가 맴버
		
		return member1.memberId - member2.memberId;
	}
	
	
	
	
	
}
