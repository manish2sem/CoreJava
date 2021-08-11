package CoreJava.J_Essential.Collection.map.TreeMapExmpl;

import java.util.Map;
import java.util.TreeMap;

/**
 * We get following run time exception. 
 * Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer at java.lang.Integer.compareTo(Unknown Source)
 *
 *The issue is that whenever you want a collection to be sorted, its elements must be mutually comparable.
 * Remember that unless otherwise specified, objects of different types are not mutually comparable.
 * We are putting here String->"a" and Integer->42 as key. 
 * they are not mutually comparable so the exception.
 *
 */

public class TreeMapComp {

	public static void main(String[] args) {
		boolean[] ba = new boolean[5];
		Map s = new TreeMap();
		s.put("a", "abc");
		s.put("b", "bcd");
		s.put("c", "abc");
		s.put("d", "abc");
		s.put(new Integer(42), "42");
		
		
		System.out.println("\n");
		for(Object key : s.keySet())
			System.out.print(key + " ");
	}
}
