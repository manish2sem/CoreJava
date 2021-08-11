package CoreJava.J_Importent.Immutable.ImmutableMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestOwnImmutableMap {

	static Map<String, String> myMap = new HashMap<String, String>();

	public static void main(String args[]) { 

		myMap.put("A", "abc");
		myMap.put("B", "bcd");
		myMap.put("C", "cde");

		Map<String, String> myImmutableMap = new C_OwnImmutableMap(myMap);
		displayMap(myImmutableMap);

		myMap.put("D", "def");
		displayMap(myImmutableMap);
		/*myImmutableMap.put("D", "def");
		System.out.println("Immutable Map - ");
		displayMap(myImmutableMap);
		System.out.println("Normal Map - ");
		displayMap(myMap);
*/

	}

	static void displayMap( Map<String, String> myMap) {
		for(String key : myMap.keySet()) {
			 System.out.print(key +" --> " +myMap.get(key) + "; ");
		 }
		System.out.println();
	}


}
