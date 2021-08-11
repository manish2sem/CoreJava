package CoreJava.J_Elementry.TrickyConcepts.Overloading;

/**
 * reference widening depends on inheritance, in other words the IS-A test.
 * For this reason Dog can be passed as an argument for the methods which takes animal argument.
 * 
 * Angain it's not legal to widen from one wrapper class to another.
 * it's NOT valid to say that Short IS-A Integer.
 * 
 * 
 * @author sinhama
 *
 */

public class D_WrapperclsOverloading {

	public static void main(String [] args) {

		long b = 5;

	//	test(new Integer(5)); // can't widen an Integer to a Long

		test(b); //This possible
	}

	static void test(Long x) { 
		System.out.println("Long"); 

	}

}
