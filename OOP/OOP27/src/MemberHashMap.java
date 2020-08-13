import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {
	
	
	private HashMap<Integer, Member> hashMap;
	
	public MemberHashMap() {
		hashMap = new HashMap<Integer,Member>();
		
	}
	
	public void addMember(Member member) {
		
		hashMap.put(member.getMemberId(), member);
		//insert
	}
	
	public boolean removeMember(int memberId) {
		
		if ( hashMap.containsKey(memberId)) {//memberid라는 키값이 존재하는
			hashMap.remove(memberId);
			return true;
		}
		System.out.println("해당 번호가 없습니다. ");
		return false;
		
	}
	
	public void showAllMember() {
		//hashMap.keySet()
		//keyset은 모든 키 객체를 반환해준다. set타입으로 반환해서 iterator
		//hashMap.values()는 중복될수있기때문에 콜랙션으로 반환
		Iterator<Integer> ir =hashMap.keySet().iterator();
		while(ir.hasNext()) {
			int key = ir.next();
			Member member = hashMap.get(key);
			System.out.println(member);
		}
		
		System.out.println();
	}

}
