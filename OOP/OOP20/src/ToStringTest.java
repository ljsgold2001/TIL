


	
class Book implements Cloneable{
	
		String title;
		String author;
		
		public Book(String title, String author) {
			this.title = title;
			this.author= author;
		}

		@Override
		public String toString() {
			return author + "," + title;
		}
		
		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}

		@Override // 우리가 호출하는 부분이아니라 가비지콜렉션에서 호출하는 것이다. I/O부분에서 배우고 다시 넘어오
		protected void finalize() throws Throwable {
			// TODO Auto-generated method stub
			super.finalize();
		}
		
		
		
		
		
	}
	
	
public class ToStringTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		Book book = new Book("토지 " , "박경");
		
		System.out.println(book);
		//object클래스의 tostring이 자동으로 불려진다.
		String str = new String("토지");
		System.out.println(str);
		//토지가 출력된다.
		
		Book book2 = (Book)book.clone();
		//앞에 (Book)써주는 이유는 clone의 반환이 object형이기 때문에 강제 형변환이필요함.
		System.out.println(book2);
		/*
		 java.lang.CloneNotSupportedException: Book
		at java.base/java.lang.Object.clone(Native Method)
		at Book.clone(ToStringTest.java:23)
		at ToStringTest.main(ToStringTest.java:45)
		이러한 에러메세지가 출력되는 이유는 Book클래스에 cloneable을 추가시켜줘야하기 때문이다.
		 */
	}

}
