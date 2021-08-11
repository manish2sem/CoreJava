package CoreJava.J_Elementry.WrapperClass.Boxing;
/**
 * 
 * When a class has overloaded methods, 
 * 	one of the compiler's jobs is to determine which method to use 
 * 	whenever it finds an invocation for the overloaded method.
 * 
 * In every case, when an exact match isn't found,
 * 	the JVM uses the method with the smallest argument that is wider than the parameter.
 *
 */

public class D_OverloadingConcept {
	
	public static void main (String [] args) {
		D_OverloadingConcept overloadingConcept= new D_OverloadingConcept();
		byte b = 5;
		short s = 5;
		long l = 5;
		float f = 5.0f;
		overloadingConcept.go(b);
		overloadingConcept.go(s);
		overloadingConcept.go(l);
		overloadingConcept.go(f);
		

		/*immutableCheck.equalCheck();
		immutableCheck.intactImutability();
		immutableCheck.equalCheckBoxing();
		immutableCheck.equalCheckObject();
		immutableCheck.compareInttoInteger();*/
	}
	
	void go(int x) { 
		System.out.println("int "); 
	}
	
	void go(long x) {
		System.out.println("long ");
	}
	
	void go(double x) { 
		System.out.println("double ");
	}
	

}
