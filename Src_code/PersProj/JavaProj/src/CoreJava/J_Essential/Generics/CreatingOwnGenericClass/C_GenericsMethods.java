package CoreJava.J_Essential.Generics.CreatingOwnGenericClass;

import java.util.*;

/**
 * Generic Methods
 * It's possible to define a parameterized type(instance of any type) at a method level,
 * without being class generic.
 * 
 * BURN IT IN MIND :
 * In order to use a type variable <T>, you must declared it either 
 * 	- as the class parameter type or 
 * 	- in the method, before the return type.
 * 
 * It’s tempting to forget that the method argument is NOT where you declare the type parameter variable T. 
 *
 */

public class C_GenericsMethods {
	
	public <T> void makeArrayList(T t) { // take an object of an unknown type and use a "T" to represent the type
		List<T> list = new ArrayList<T>(); // now we can create the list using "T"
		list.add(t);
	}
	
	public <T> void makeArrayList(List<T> list) { // take an object of an unknown type and use a "T" to represent the type
		List<T> list1 = new ArrayList<T>(); // now we can create the list using "T"
		list1.addAll(list);
	}
	
	public <T extends Number> void restrciedArrayList(T t){
		List<T> list = new ArrayList<T>(); // now we can create the list using "T"
		list.add(t);
	}
	
	public static void main (String[] args) {
		
	//	List<String> strList = new ArrayList<String>();
		C_GenericsMethods genericsMethods = new C_GenericsMethods();
		genericsMethods.makeArrayList("Manish");
		genericsMethods.makeArrayList("Kumar");
		genericsMethods.makeArrayList("Samrat");
		genericsMethods.makeArrayList("Virat");
		genericsMethods.makeArrayList(123);
		genericsMethods.restrciedArrayList(123);
	//	genericsMethods.restrciedArrayList("Virat");

	}

}

/**
 * The <T> before void simply defines what T is before you use it as a type in the argument.
 *  You MUST declare the type like that unless the type is specified for the class. 
 * 
 * 
 * You're also free to put boundaries on the type you declare 
 * 	E.G. -> public <T extends Number> void makeArrayList(T t){} 
 */
