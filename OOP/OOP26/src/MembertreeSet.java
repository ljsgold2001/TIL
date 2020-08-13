
import java.util.Iterator;
import java.util.TreeSet;

public class MembertreeSet {
	
	
	private TreeSet<Member> treeSet; 
	
	
	public MembertreeSet() {
		//comparato를 사용할경우에 treeset설정시 default를 줘야한다.
		treeSet = new TreeSet<Member>(new Member());
		
	}
	
	public void addMember(Member member) {
		treeSet.add(member);
		//comparable을 넣어주지 않으면 여기서 오류가난다.
	//숫자는 그냥 비교가되지만 타입이 다른경우에는 어떻게 비교할것인지를 구현해주어야한다.
		//위에구현해주면됨 
	}
	
	public Boolean remove(int memberId) {
		
		Iterator<Member>  ir = treeSet.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			if (member.getMemberId() == memberId) {
				treeSet.remove(member);
				return true;
			}
		}
		System.out.println(memberId + "번호가 존재하지 않습니다.");
		return false;
	}
	
	
	
	public void showAllMember() {
		for ( Member member : treeSet) {
			System.out.println(member);
		}
		System.out.println();
	}
	

}
