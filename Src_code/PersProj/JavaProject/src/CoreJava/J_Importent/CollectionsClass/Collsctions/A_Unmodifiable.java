package CoreJava.J_Importent.CollectionsClass.Collsctions;

/**
 * Unmodifiable Map returns immutable map(read-only) on top of HashMap.
 * They throw UnsupportedOperationException on modification, insertion or deletion of node through direct or iterator.
 * 
 * 
 * 
 * When specified(HashMap) map is modified(After creation of Unmodifiable Map), the changes in actual map is reflected in Unmodifiable Map.
 * 
 * The returned collection will be serializable if the specified collection is serializable. 
 * The returned collection does not pass the hashCode and equals operations through to the backing collection, but relies on Object's equals and hashCode methods.
 * 
 * Types of Map creation:	 
 * 		Map/SortedMap
 * 		set/SortedSet
 * 		List and
 * 		Collection
 * Theses are passed as parameter.
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class A_Unmodifiable {
	
static Map<String, String> myMap = new HashMap<String, String>();

	public static void main(String args[]) { 
		
		myMap.put("A", "abc");
		myMap.put("B", "bcd");
		myMap.put("C", "cde");
		
		Map<String, String> myImmutableMap = Collections.unmodifiableMap(myMap);
		 System.out.print("Immutable Map ->  ");
		 displayMap(myImmutableMap);
		 
		// System.out.println("After replacing - ");
		// myImmutableMap.put("A", "xyz");		//java.lang.UnsupportedOperationException
		// myImmutableMap.put("D", "xyz");
		// displayMap(myMap);
		 
		// System.out.println("After Removing A - ");
		// myImmutableMap.remove("A");			//java.lang.UnsupportedOperationException
		// displayMap(myMap);
		 
		 //myMap is final so we can not assign any other map to this.
	 
		 //	 myMap = new HashMap<String, String>();
		 
		 myMap.put("D", "def");
		 System.out.print("Modifed Immutable Map - ");
		 displayMap(myImmutableMap);
		 System.out.print("Normal Map - ");
		 displayMap(myMap);
		 
		 
	 }
	
	static void displayMap( Map<String, String> myMap) {
		for(String key : myMap.keySet()) {
			 System.out.print(key +" --> " +myMap.get(key) + "; ");
		 }
		System.out.println();
	}


}
