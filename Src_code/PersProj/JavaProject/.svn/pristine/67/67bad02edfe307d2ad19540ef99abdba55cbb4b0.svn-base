package CoreJava.J_Essential.Generics.Basics;

/**
 * Declaring a List with a type parameter of <Object> makes a collection that works in almost the same way 
 * as the original pre-Java 5, non-generic collection—you can put ANY Object type into the collection. 
 * 			 List myList = new ArrayList(); // old-style, non-generic
 * is almost identical to 	
 * 			List<Object> myList = new ArrayList<Object>();
 * 
 * You'll see a little later that non-generic collections and collections of type <Object> aren't entirely the same, 
 * but most of the time the differences do not matter.
 */

import java.util.ArrayList;
import java.util.List;
import CoreJava.J_Essential.Generics.ExampleClass.*;


public class HetroGenerics {
	
	static List<Object> myList = new ArrayList<Object>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HetroGenerics hetroGenerics = new HetroGenerics();
		hetroGenerics.takeListOfStrings(myList, "My");
		hetroGenerics.takeListOfStrings(myList, new Integer(42));
		hetroGenerics.takeListOfStrings(myList, "is");
		hetroGenerics.takeListOfStrings(myList, new Dog("Jimmy"));
		
		hetroGenerics.displyListOfStrings(myList);
		List<Object> newList=hetroGenerics.getListOfStrings();
		System.out.println(" New List : " ); 
		for (Object s : newList) {
	    	//System.out.println(s+ " " +s.length()); 
			// no need for a cast before calling a String method! The
			// compiler already knew "s" was a String coming from newList
		}
	}

	void takeListOfStrings(List<Object> strings, Object str) {
		strings.add(str); // no problem adding a String
	}
	
	void displyListOfStrings(List<Object> strings) {
		for (Object s : strings) {
	    	System.out.println(s+ " " ); 
			// no need for a cast before calling a String method! The
			// compiler already knew "s" was a String coming from MyList
		}
		System.out.println();
	}
	
	//Return types can obviously be declared type safe as well	
	List<Object> getListOfStrings() {		
			List<Object> newList = new ArrayList<Object>();
			newList.addAll(myList);
			return newList;
		}
}
