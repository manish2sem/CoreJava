package Java8.B_IF_Static;

/**
 * static interface: 
 * We can use static keyword to create interfaces with method implementation.
 * 
 * Similarity with regular static methods
 * 	it is used with the reference of interface. 
 * 
 * Unlike  regular static methods 
 * 	Static methods of interfaces are never inherited in implementing class
 * 
 * Unlike default methods 
 *   Implementing classes can't override them as it is static.
 *
 */

public interface Interface1 {
	
	void method1(String str);
	
	static void staticMethod(String str){
		System.out.println("Interface1 Printing  "+str);
	}
	
	static void staticMethod1(String str){
		System.out.println("Interface1 Printing  "+str);
	}

}
