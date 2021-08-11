package CoreJava.J_Elementry.TrickyConcepts.Overloading;

/**
 * var-args method handle invocations with any number of [byte] parameters.
 * It is more like a catch-all method, in terms of what invocations it can handle.
 * So it makes most sense for catch-all capabilities to be used as a last resort.
 * 
 * The var-args method is "looser" than any other method.
 *
 */

public class C_BoxVsVarargsOverloading {

	public static void main(String [] args) {
		//byte b = 5;
		int b=5;
		go(b,b); // which go() will be invoked?
	}

	/*static void go(Byte x, Byte y){ 
		System.out.println("Byte, Byte");
	}
	
	static void go(byte... x) { 
		System.out.println("byte... "); 
	}*/
	
	static void go(Integer x, Integer y){ 
		System.out.println("Integer, Integer");
	}
	
	static void go(int... x) { 
		System.out.println("int... "); 
	}


}
