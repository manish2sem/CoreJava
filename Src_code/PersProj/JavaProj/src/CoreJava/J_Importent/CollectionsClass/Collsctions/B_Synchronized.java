package CoreJava.J_Importent.CollectionsClass.Collsctions;


/**
 * Returns a synchronized (thread-safe) sorted map backed by the specified sorted map.
 * 
 *  Backed Means -  When we add key-value pairs to either the original TreeMap or the partial-copy SortedMap, the new entries were automatically added to the other collection
 * 
 * User shpuld manually synchronize on the returned sorted map when iterating over any of its collection views, or
 * The collections views of any of its subMap, headMap or tailMap views. 
 * 
 * The returned sorted map will be serializable if the specified sorted map is serializable. 
 * 
 * Types of Map creation:	 
 * 		Map/SortedMap
 * 		set/SortedSet
 * 		List and
 * 		Collection
 * Theses are passed as parameter.
 */

import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class B_Synchronized {
	
	static SortedMap<String, String> sortedMap = new TreeMap<String, String>();

	public static void main(String args[]) { 
		
		sortedMap.put("A", "abc");
		sortedMap.put("B", "bcd");
		sortedMap.put("C", "cde");
		
				
		SortedMap<String, String> synchronizedMap = Collections.synchronizedSortedMap(sortedMap);
		Collections.singletonMap(key, value);
		
		 displayMap(synchronizedMap);
		 
		// System.out.println("After replacing - ");
		// myImmutableMap.put("A", "xyz");		//java.lang.UnsupportedOperationException
		// myImmutableMap.put("D", "xyz");
		// displayMap(myMap);
		 
		// System.out.println("After Removing A - ");
		// myImmutableMap.remove("A");			//java.lang.UnsupportedOperationException
		// displayMap(myMap);
		 
		 //myMap is final so we can not assign any other map to this.
	 
		 //	 myMap = new HashMap<String, String>();
		 
		 sortedMap.put("D", "def");
		 System.out.println("Immutable Map - ");
		 displayMap(synchronizedMap);
		 System.out.println("Normal Map - ");
		 displayMap(sortedMap);
		 
		 
	 }
	
	static void displayMap( Map<String, String> myMap) {
		for(String key : myMap.keySet()) {
			 System.out.print(key +" --> " +myMap.get(key) + ", ");
		 }
		System.out.println();
	}


}
