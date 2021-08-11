package CoreJava.J_Elementry.TrickyConcepts.Overloading;

/**
 * RULE -> preexisting code should function the way it used to.
 * 
 * Boxing was introduced in JAVA5 and widening capability already existed.
 * A method that is invoked via widening shouldn't lose out to a newly created method that relies on boxing.
 * 
 * So widening wins ober boxing.
 */

public class B_LitVsBoxingOverloading {


	public static void main(String [] args) {
		int i = 5;
		go(i); // which go() will be invoked?
	}

	static void go(Integer x) { 
		System.out.println("Integer");
	}

	static void go(long x) { 
		System.out.println("long"); 
	}

}
