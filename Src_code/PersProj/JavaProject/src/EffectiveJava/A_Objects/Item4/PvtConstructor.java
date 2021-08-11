package EffectiveJava.A_Objects.Item4;

import java.util.List;

/**
 * Item 4: Enforce noninstantiability with a private constructor.
 * 
 * Some utility classes were not designed to be instantiated.
 * 		- Classes used to group related methods on primitive values or arrays, 
 * 			Ex :  java.lang.Math  - public static double random(){};
 * 				  java.util.Arrays - public static void sort(Object[] a) {}
 * 		- Classes used to group static methods, including factory methods (Item 1), for objects that implement a particular interface.
 * 			Ex :  	java.util.Collections - public static <T extends Comparable<? super T>> void sort(List<T> list) {}
 * 		- Lastly, Classes used to group methods on a final class, instead of extending the class.
 *	
 *In the absence of explicit constructors, the compiler provides a public, parameterless default constructor.
 * It is not uncommon to see unintentionally instantiable classes in published APIs.
 * 
 * Attempting to enforce noninstantiability by making a class abstract does not work.
 *  The class can be subclassed and the subclass instantiated. 
 *  Furthermore, it misleads the user into thinking the class was designed for inheritance (Item 17).
 *  
 *   A default constructor is generated only if a class contains no explicit constructors.
 *   So, a simple idiom to ensure noninstantiability is to make a constructor private!!!
 */

public class PvtConstructor {
	public static void main(String args[])  {
		UtilityClass.printMsg();
	}


}

class UtilityClass {
	// Suppress default constructor for noninstantiability
	private UtilityClass() {
		throw new AssertionError();
	}
	static public void printMsg() {
		System.out.println("For using this class object is prohibited");
	}
	 // Remainder omitted
}


/*
 
  class subClassUtilityClass extends UtilityClass {
 
	public subClassUtilityClass(int x) {
		
	}
}
*/