package CoreJava.J_Importent.CollectionsClass.Collsctions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Collections.checkedList will only decorate the list to prevent any future inserts with objects of the wrong class, 
 * it won't check all the elements that are already in the list.
 * 
 * Any attempt to insert an element of the wrong type will result in an immediate ClassCastException.
 * 
 * 
 * Uses:
 * 		- as a debugging aid (if someone has used an unchecked cast).
 * 		- to ensure safety when passing a collection to be populated by third-party code.
 *
 */

public class C_Checked {
	
	static List<String> myList = new ArrayList<String>();

	public static void main(String args[]) { 
		
		myList.add("abc");
		myList.add("bcd");
		myList.add("cde");
		
				
		SortedMap<String, String> synchronizedMap = Collections.checkedList(list, type);
		
		Collections.checkedList(list, type)
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

