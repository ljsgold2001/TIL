
public interface Sort {
	
	public void ascending();
	public void descending();
	
	public default void description() {
		System.out.println("숫자를 정렬하는 알고리즘입니다. ");
	};
	
	
	
	

}
