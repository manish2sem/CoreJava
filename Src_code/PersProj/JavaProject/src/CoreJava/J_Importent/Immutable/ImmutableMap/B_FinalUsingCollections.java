package CoreJava.J_Importent.Immutable.ImmutableMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * unmodifiableMap method of collections class returns immutable map. 
 * You can not add, delete or update anything from returned immutable map.
 * @author sinhama
 * 
 * We can use the same concept to make our own immutable implementaion.
 *
 */

public class B_FinalUsingCollections {
	
static final Map<String, String> myMap = new HashMap<String, String>();
	
	public static void main(String args[]) { 
		
		myMap.put("A", "abc");
		myMap.put("B", "bcd");
		myMap.put("C", "cde");
		
		Map<String, String> myImmutableMap = Collections.unmodifiableMap(myMap);
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
		 System.out.println("Immutable Map - ");
		 displayMap(myImmutableMap);
		 System.out.println("Normal Map - ");
		 displayMap(myMap);
		 
		 
	 }
	
	static void displayMap( Map<String, String> myMap) {
		for(String key : myMap.keySet()) {
			 System.out.println(key +" --> " +myMap.get(key));
		 }
	}

}
