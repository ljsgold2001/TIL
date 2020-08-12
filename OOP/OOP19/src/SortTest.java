import java.io.IOException;

public class SortTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("정렬 방식을 선택하세요 ");
		System.out.println("B : bubblesort ");
		System.out.println("H : Heapsort ");
		System.out.println("Q : QuickSort ");
		
		Sort sort = null;
		int ch = System.in.read();
		
		if ( ch =='Q' || ch =='q') {
			sort = new QuickSort();
		}
		else if ( ch =='L' || ch =='l') {
			sort = new Heapsort();
		}
		
		else {
			System.out.println("지원되지 않는 기능입니다.");
			return;
		}
		
		sort.ascending();
		sort.descending();
		sort.description();
		

	}
	

}
