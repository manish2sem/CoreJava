package Java8.E_Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 *  to iterate over a list of integers and 
 *  find out sum of all the integers greater than 10.
 * @author Manish
 *
 */

public class A_iterate {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList();
		list.add(12);
		list.add(2);
		list.add(32);
		list.add(22);
		list.add(9);
		
		System.out.println("Sum : " + sumIterator(list));

	}

	/**
	 * We just want to know the sum of integers but
	 *  - we would also have to provide how the iteration will take place.
	 *  - The program is sequential in nature.
	 *  - There is a lot of code to do even a simple task.
	 * @param list
	 * @return
	 */
	private static int sumIterator(List<Integer> list) {
		Iterator<Integer> it = list.iterator();
		int sum = 0;
		while (it.hasNext()) {
			int num = it.next();
			if (num > 10) {
				sum += num;
			}
		}
		return sum;
	}
}

/**
 * Java 8 Stream API was introduced to overcome above shortcomings. 
 * Java Stream API implements internal iteration.
 * Internal iteration provides several features such as 
 * 	- sequential and parallel execution, 
 * 	- filtering based on the given criteria, 
 * 	- mapping etc.
 * 
 * Most of the Java 8 Stream API method arguments are functional interfaces, 
 * so lambda expressions work very well with them. 
*/
