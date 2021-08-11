package CoreJava.J_Essential.Collection.sets.TreeSet;
/**
 * The following code which is perfectly correct with HashSet.
 * Will throw runTimeException with TreeSet.
 * 
 * Why?
 */
import java.util.*;
class SetTest {
	public static void main(String[] args) {
		boolean[] ba = new boolean[5];
		// insert code here
		//Set s = new HashSet();  //This is fine
		Set s = new TreeSet();  // RuntimeException ->> java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
		
		ba[0] = s.add("a");
		ba[1] = s.add(new Integer(42));
		ba[2] = s.add("b");
		ba[3] = s.add("a");
		ba[4] = s.add(new Object());
		for(int x=0; x<ba.length; x++)
			System.out.print(ba[x] + " ");
		
		System.out.println("\n");
		
		for(Object o : s)
			System.out.print(o + " ");
	}
}


/**
 * The issue is that whenever you want a collection to be sorted, its elements must be mutually comparable.
 * Remember that unless otherwise specified, objects of different types are not mutually comparable.
 * Here String and Integer are comparable separately as they implement comparable IF but are not mutually comparable. 
 */
 