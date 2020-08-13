import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("이순신");
		set.add("김유신");
		set.add("이지수");
		set.add("이순신");
		
		//System.out.println(set);
		
		Iterator <String>ir = set.iterator();
		
		while(ir.hasNext()) {
			String str = ir.next();
			System.out.println(str);
		}
		
	}

}
