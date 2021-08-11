package CoreJava.J_Essential.Collection.sets.TreeSet.Navigation;

/**
 * Java 6 introduced (among others) two new interfaces: java.util.NavigableSet [and java.util.NavigableMap]. 
 * Interessting to see how TreeSet [and TreeMap] implement these interfaces.
 * 
 * Let's look at some code that determines two things:
 *  - Time just before 1600.
 *  - Time just after 2000.
 */

import java.util.*;
public class Ferry {
	public static void main(String[] args) {
		TreeSet<Integer> times = new TreeSet<Integer>();
		
		times.add(1205); // add some departure times
		times.add(1505);
		times.add(1545);
		times.add(1830);
		times.add(2010);
		times.add(2100);
		
		// Java 5 version - before the addition of the NavigableSet
		TreeSet<Integer> subset = new TreeSet<Integer>();		
		subset = (TreeSet)times.headSet(1600);		
		System.out.println("J5 - last before 4pm is: " + subset.last());
		
		TreeSet<Integer> sub2 = new TreeSet<Integer>();		
		sub2 = (TreeSet)times.tailSet(2000);
		System.out.println("J5 - first after 8pm is: " + sub2.first());
		
		// Java 6 version [with NavigableSet] using the new lower() and higher() methods
		System.out.println("J6 - last before 4pm is: " + times.lower(1600));
		System.out.println("J6 - first after 8pm is: " + times.higher(2000));
	}
}

/**
 * NavigableSet methods related to this type of navigation are lower(), floor(), higher(), ceiling(), and 
 * the parallel NavigableMap methods are lowerKey(), floorKey(), ceilingKey(), and higherKey(). 
 * 
 * lower() returns the element less than the given element, and floor() returns the element less than or equal to the given element. 
 * Similarly, higher() returns the element greater than the given element, and ceiling() returns the element greater than or equal to the given element.
 * */

