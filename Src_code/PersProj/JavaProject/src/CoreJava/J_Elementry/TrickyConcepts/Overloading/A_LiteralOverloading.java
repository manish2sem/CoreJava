package CoreJava.J_Elementry.TrickyConcepts.Overloading;

/**
 * RULE -> when an exact match isn't found, the JVM uses the method with the smallest argument that is wider than the parameter.
 * @author sinhama
 *
 */

public class A_LiteralOverloading {

	public static void main(String [] args) {
		byte b = 5;
		short s = 5;
		long l = 5;
		float f = 5.0f;
		go(b);
		go(s);
		go(l);
		go(f);
	}

	static void go(int x) {
		System.out.println("int "); 
	}
	
	static void go(long x) { 
		System.out.println("long "); 
	}
	
	static void go(double x) { 
		System.out.print("double "); 
	}

}
