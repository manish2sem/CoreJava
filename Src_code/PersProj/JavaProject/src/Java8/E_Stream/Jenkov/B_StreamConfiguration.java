package Java8.E_Stream.Jenkov;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


/**
 *  
 *  The filter() method takes a Predicate as parameter. 
 *  
 *  The Predicate interface contains a function called test() 
 *  which the lambda expression(anonymous function) passed as parameter above is matched against.
 *   In other words, the lambda expression implements the Predicate.test() method.
 *   
 *  The test() method is defined like this:
 *  	boolean test(T t)
 *  
 *  When you call the filter() method on a Stream, the filter passed as parameter to the filter() method is stored internally. 
 *  No filtering takes place yet.
 *  
 *   If the Predicate.test() method 
 *   returns true for an item, that means it should be processed. 
 *   If false is returned, the item is not processed.
 * @author Manish
 *
 */
public class B_StreamConfiguration {

	public static void main(String[] args) {
		List<String> items = new ArrayList<String>();

		items.add("one");
		items.add("two");
		items.add("three");

		Stream<String> stream = items.stream();
		stream.filter( item -> item.startsWith("o") );
		
		System.out.println("Main End ...");

	}

}
