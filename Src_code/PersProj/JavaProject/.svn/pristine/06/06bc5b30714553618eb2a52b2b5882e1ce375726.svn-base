package CoreJava.J_Essential.Collection.general.comprble.Basic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Manish
 * The sort() method of Collections takes a List argument,
 * and that the objects in the List must implement an interface called Comparable. 
 * String implements Comparable, and that's why we were able to sort a list of Strings using 
 * the Collections.sort() method. 
 * 
 * public final class String implements java.io.Serializable, 
 *        								Comparable<String>, 
 *        								CharSequence{}
 *        
 *        
 * Collections is the class that holds static utility methods for use with collections.
 */

public class A_CollectionSort {
	
	public static void main(String[] args) {
		ArrayList<String> stuff = new ArrayList<String>(); // #1
		stuff.add("Denver");
		stuff.add("Boulder");
		stuff.add("Vail");
		stuff.add("Aspen");
		stuff.add("Telluride");
		System.out.println("unsorted " + stuff);
		Collections.sort(stuff); // #2
		System.out.println("sorted " + stuff);
	}	

}


/*public class CollectionSort {
	
	public static void main(String[] args) {
		ArrayList<Integer> stuff = new ArrayList<Integer>(); // #1
		stuff.add(1);   //autoboxing
		stuff.add(2);
		stuff.add(3);
		stuff.add(6);
		stuff.add(4);
		System.out.println("unsorted " + stuff);
		Collections.sort(stuff); // #2
		System.out.println("sorted " + stuff);
	}	

}
*/