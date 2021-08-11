package Java8.B_IF_Default;

/**
 * From Java 8, interfaces are enhanced to have method with implementation. 
 * Theses are called default methods.
 * There can be more than one default methods.
 * 
 * Implementing class of this interface need not to define (or redefine) them in normal cases.
 * Ex : MyClass1.
 * 
 * 
 * 
 * special case is dimond problem
 * 
 * 
 * We can use default and static keyword to create interfaces with method implementation.
 * 
 *  If any class in the hierarchy has a method with same signature, 
 *  then default methods become irrelevant and compiler will throw exception 


 * @author Manish
 *
 */

public interface Interface1 {
	
	//Traditional interface method
	void method1(String str);

	default void defaultMethod(String str){
		System.out.println("I1 logging::"+str);
	}

	default void defaultMethod1(String str){
		System.out.println("I1 logging::"+str);
	}

}
