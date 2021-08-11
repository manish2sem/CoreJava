package Java8.E_Stream.Jenkov;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * http://tutorials.jenkov.com/java-collections/streams.html
 * 
 * A collection is an in-memory data structure to hold values and 
 * before we start using collection, all the values should have been populated. 
 * 
 * Whereas a java Stream is a data structure that is computed on-demand.
 * Java Stream doesn’t store data, it operates on the source data structure (collection and array) and
 *  produce pipelined data that we can use and perform specific operations.
 * 
 * Such as we can create a stream from the list and filter it based on a condition.
 *
 * Once obtained, you use that stream to process the elements in the collection.
 *  Processing the elements in the stream happens in two steps / phases:
 *  	- Configuration : This is first step.
 *  					The configuration can consist of filters and mappings.
 *  	- Processing : This is next step.
 *  					The processing consists of doing something to the filtered and mapped objects.
 *   No processing takes place during the configuring calls. Not until a processing method is called on the stream.
 */


public class A_Stream {

	public static void main(String[] args) {
		List<String> items = new ArrayList<String>();

		items.add("one");
		items.add("two");
		items.add("three");

		Stream<String> stream = items.stream();
		
	}

}
