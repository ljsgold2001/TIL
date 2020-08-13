import java.util.Comparator;
import java.util.TreeSet;

class MyCompare implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		return s1.compareTo(s2) * (-1); //내림차
	}
	
}
public class ComparatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		TreeSet<String> treeSet = new TreeSet<String>(new MyCompare());
		//treeset은 기본적으로 오름차순으로 구현하게끔 구현되어잇다.
		
		treeSet.add("B");
		treeSet.add("C");
		treeSet.add("A");
		
		for ( String str : treeSet) {
			System.out.println(str);
		}

	}

}
