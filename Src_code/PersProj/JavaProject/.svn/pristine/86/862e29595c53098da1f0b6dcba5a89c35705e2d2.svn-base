package CoreJava.J_Essential.Generics.Basics;

import java.util.ArrayList;
import java.util.List;
import CoreJava.J_Essential.Generics.ExampleClass.*;


/**
 * Before Java 5 there was no syntax for declaring a type safe collection. see code 
 * 
 * A non-generic collection is quite happy to hold anything that is NOT a primitive.
 * And since a collection could hold anything, the methods that get objects out of the collection 
 * could have only one kind of return type—java.lang.Object. 
 * That meant that getting a String back out of our only-Strings-intended list required a cast: 
 * 		String s = (String) myList.get(0);
 * And since you couldn't guarantee that what was coming out really was a String, the cast could fail at runtime.
 * 
 * generics takes care of both ends (the putting in and getting out) by enforcing the type of your collections.
 *
 */
public class OldStyleCollection {

	static List myList = new ArrayList();
	public static void main(String[] args) {
		OldStyleCollection legacyCollection = new OldStyleCollection();
		legacyCollection.takeListOfStrings(myList, "Manish");
		legacyCollection.takeListOfStrings(myList, new Integer(42));
		legacyCollection.takeListOfStrings(myList, "is");
		legacyCollection.takeListOfStrings(myList, new Dog("Jimmy"));
		
		legacyCollection.displyListOfStrings(myList);
	}
	
	void takeListOfStrings(List strings, Object obj) {
		strings.add(obj); // no problem adding a String or Integer in same list
	}
	
	void displyListOfStrings(List strings) {
		for (Object s : strings) {
	    	System.out.print(s+ " " );
	    	if (s instanceof String) {					//instanceof check is must with pre-generic code. Instanceof works because of object type.
	    		System.out.print(((String) s).length()); //cast is must with pre-generic code
	    	}
	    	if (s instanceof Integer) {					//instanceof check is must with pre-generic code
	    		System.out.print(" : This is an Integer "); 
	    		Integer myInt = (Integer)s;					//cast is must with pre-generic code
	    	}
	    	System.out.println();
		}
		System.out.println();
	}	

}

