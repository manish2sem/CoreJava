package CoreJava.J_Elementry.TrickyConcepts.Overloading;

/**
 * Here's what happened under the covers 
 * 1. The int b was boxed to a Integer.
 * 2. The Integer reference was widened to an Object (since Integer extends Object).
 * 3. The go() method got an Object reference that actually refers to a Integer object.
 * 4. The go() method cast the Object reference back to a Integer reference 
 * (remember, there was never an object of type Object in this scenario, only an object of type Integer!).
 *
 */

public class F_BoxAndWide {


	public static void main(String [] args) {
		int b = 5;
		go(b); // can this byte turn into an Object ?
	}

	static void go(Object o) {
		Integer b2 = (Integer) o; // ok - it's a Integer object
		int b3 = (Integer) o; 	 // Even this is fine.
		System.out.println(b2);
	}

}
