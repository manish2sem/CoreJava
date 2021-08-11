package Java8.E_Stream.Jenkov;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * It is possible to map the items in a collection to other objects. 
 * In other words, for each item in the collection you create a new object based on that item. 
 * How the mapping is done is up to you.
 * 
 * This example maps all strings in the items collection to their uppercase equivalents.
 * Again, It only configures the stream for mapping.
 * Once one of the stream processing methods are invoked, the mapping (and filtering) will be performed.
 *
 */
public class C_StreamMap {

	public static void main(String[] args) {
		List<String> items = new ArrayList<String>();

		items.add("one");
		items.add("two");
		items.add("three");

		Stream<String> stream = items.stream();
		stream.map( item -> item.toUpperCase());

	}

}
