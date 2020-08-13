import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet<String> treeSet = new TreeSet<String>();
		//treeset은 기본적으로 오름차순으로 구현하게끔 구현되어잇다.
		
		treeSet.add("B");
		treeSet.add("C");
		treeSet.add("A");
		
		for ( String str : treeSet) {
			System.out.println(str);
		}

	}

}
