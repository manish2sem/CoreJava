package CoreJava.J_Importent.Immutable.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * We cannot make map immutable by making it final.
 * Here immutable means :
 * 	can not add any key-value.
 *  can not delete any key-value.
 *  can not replace any key-value.
 *  
 *  Reason, myMap is final so we can not assign any other map to this but its key and values can be set or reset.
 *  
 *
 */
public class A_FinalMap {
	
	static final Map<String, String> myMap = new HashMap<String, String>();
	
	public static void main(String args[]) { 
		myMap.put("A", "abc");
		myMap.put("B", "bcd");
		myMap.put("C", "cde");
		 displayMap(myMap);
		 
		 System.out.println("After replacing - ");
		 myMap.put("A", "xyz");
		 displayMap(myMap);
		 
		 System.out.println("After Removing A - ");
		 myMap.remove("A");
		 displayMap(myMap);
		 
		 //myMap is final so we can not assign any other map to this.
	 
		 //	 myMap = new HashMap<String, String>();
		 
		 
	 }
	
	static void displayMap( Map<String, String> myMap) {
		for(String key : myMap.keySet()) {
			 System.out.print(key +" --> " +myMap.get(key) + "; ");
		 }
		System.out.println();
	}

}
