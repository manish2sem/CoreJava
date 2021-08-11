package Java7.A_TypeInference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * you have to type less in Java 7, while working with Collections.
 * 
 * to specify types on both left and right hand side of object creation expression, but now it only needed on left hand side
 * @author Manish
 *
 */

public class TypeInference {

	public static void main(String[] args) {
		//Prior JDK 7
		Map<String, List<String>> employeeRecords =  new HashMap<String, List<String>>();
		List<Integer> primes = new ArrayList<Integer>();
		
		//JDK 7
		Map<String, List<String>> employeeRecords_7 =  new HashMap();
		List<Integer> primes_7 = new ArrayList();


	}

}
