package CoreJava.J_Essential.Collection.general.EnumItr;

/**
 * public static Enumeration enumeration(Collection c)
Returns an enumeration over the specified collection. This provides interoperability with legacy APIs that require an enumeration as input
 */

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class A1_EnumInMap {
	
	public static void main(String[] args) {
		final Map <String,Integer> test = new HashMap<String,Integer>();
		 test.put("one",1);
		 test.put("two",2);
		 test.put("three",3);
		 final Enumeration<String> strEnum = Collections.enumeration(test.keySet());

		 while(strEnum.hasMoreElements()) {
		     System.out.println(strEnum.nextElement());
		 }
	}

}
