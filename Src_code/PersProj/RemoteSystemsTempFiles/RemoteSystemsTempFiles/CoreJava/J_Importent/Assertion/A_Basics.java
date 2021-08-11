package CoreJava.J_Importent.Assertion;

/**
 * Added to the Java language beginning with version 1.4, 
 * assertions let you test your assumptions during development, without the expense 
 * of writing exception handlers for exceptions that you assume will never happen 
 * once the program is out of development and fully deployed.
 * 
 * how assertions work, including how to enable them, how to use them, and how not to use them.
 * 
 */

public class A_Basics {
	public static void main(String[] args) {
		A_Basics asertBasic = new  A_Basics();
		asertBasic.methodA(-2);
	}

	private void methodA(int num) {
		
		assert (num>=0); // throws an AssertionError
		// if this test isn't true
		int x = num + 5;
		System.out.println("X is : "+x);
		
		
						
		assert (x > num): "num is " + num + " x is " + x;
	}
}
