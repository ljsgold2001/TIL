import java.util.List;
import java.util.stream.Stream;
import java.util.ArrayList;

public class ArrayListStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List <String> sList = new ArrayList<String>();
		sList.add("tomas");
		sList.add("jisoo");
		sList.add("edward");
		sList.add("jack");
		
		Stream<String> stream = sList.stream();
		stream.forEach(s->System.out.println(s + " "));
		
		System.out.println();
		
		sList.parallelStream().sorted().forEach(s->System.out.println(s + " "));
 
		System.out.println();
		
		sList.stream().map(s->s.length()).forEach( n ->System.out.println(n));
	}

}
