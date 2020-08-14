package remind2;

import java.util.Iterator;
import java.util.TreeSet;

public class MemberTreeSet {
	
	private TreeSet<Member> treeSet;
	
	public MemberTreeSet() {
		treeSet = new TreeSet<Member>(new Member());
	}
	
	public void addMember(Member member) {
		
		treeSet.add(member);
		
	}
	
	public Boolean remove(int memberId) {
		Iterator<Member> ir = treeSet.iterator();
		Member member = ir.next();
		while(ir.hasNext()) {
			if (member.getMemberId() == memberId) {
				treeSet.remove(member);
				return true;
			}
		
		}
		System.out.println(memberId + "를 가진 사용자를 찾을수 없습니다. ");
		return false;
	}
	
	public void showAllInfo() {
		for(Member member : treeSet) {
			System.out.println(member);
		}
	}

}
