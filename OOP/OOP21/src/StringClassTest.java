import java.lang.reflect.Constructor;

public class StringClassTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		Class<?> c3 = Class.forName("java.lang.String");
		
		
		
		java.lang.reflect.Method[] methods = c3.getMethods();
		
		for(java.lang.reflect.Method method :methods) {
			System.out.println(method);
		}
			
	}

}
