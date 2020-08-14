package remind2;
/*
 * comparable을 이용했을때의 코드
 * 
public class Member implements Comparable<Member>{
	private int memberId;
	private String memberName;
	
	public Member(int memberId, String memberName){
		
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
		
		return memberId +"를 가진 사람의 이름은 " + memberName +"입니다.";
	}

	@Override
	public int compareTo(Member member) {
		// TODO Auto-generated method stub
		return (this.memberId - member.memberId);
	}
	

}
*/
//comparator을 이용했을때의 코드

import java.util.Comparator;

public class Member implements Comparator<Member>{
	private int memberId;
	private String memberName;
	
	public Member() {
		
	}
	public Member(int memberId, String memberName){
		
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
		
		return memberId +"를 가진 사람의 이름은 " + memberName +"입니다.";
	}

	@Override
	public int compare(Member member1, Member member2) {
		// TODO Auto-generated method stub
		return member1.memberName.compareTo(member2.getMemberName());//이건 이름순이다.
	}

	
	

}
