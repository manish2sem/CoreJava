package Java8.D_LamdaExp;

/**
 * An interface with exactly one abstract method is known as Functional Interface.
 * 	- It may have one or more default IF
 *  - It may have one or more Static IF
 *  - It will have exactly one abstract IF.
 * 
 * @FunctionalInterface
 *  A new annotation @FunctionalInterface has been introduced 
 *  to avoid accidental addition of abstract methods in the functional interfaces.

 * it enables us to use lambda expressions 
 * A new package java.util.function with bunch of functional interfaces are added 
 * to provide target types for lambda expressions and method references. 
 */

@FunctionalInterface
public interface A_FuctionalIF {

	//Required abstarct method
	public void method2(int i); 

	// Optional default/static methods
	public default void method1(){ }	
	public static void method3(){ }

	/*
	public void method2() {
	}
	*/
}
