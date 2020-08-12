
public class Bookshelf extends Shelf implements Queue{
//extends 가 먼저 나오게된다. 
	@Override
	public void enQueue(String title) {
		// TODO Auto-generated method stub
		shelf.add(title);
		
	}

	@Override
	public String deQueue() {
		// TODO Auto-generated method stub
		return shelf.remove(0);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return getCount();
	}
	
	
	
	

}
