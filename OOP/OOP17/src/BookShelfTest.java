
public class BookShelfTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue bookQueue = new Bookshelf();
		bookQueue.enQueue("태백산맥1");
		bookQueue.enQueue("태백산맥2");

		bookQueue.enQueue("태백산맥3");
		
		System.out.println(bookQueue.deQueue());
		System.out.println(bookQueue.deQueue());

		System.out.println(bookQueue.deQueue());


	}

}
