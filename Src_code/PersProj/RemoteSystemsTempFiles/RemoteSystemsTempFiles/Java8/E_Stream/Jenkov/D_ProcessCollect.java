package Java8.E_Stream.Jenkov;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The collect() method is one of the stream processing methods on the Stream IF. 
 * When this method is invoked, the filtering and mapping will take place and 
 * the object resulting from those actions will be collected. 
 * 
 * This example 
 * 	creates a stream, 
 * 	adds a filter, and 
 * 	collects all object accepted by the filter in a List.
 *  	i.e. all strings from the items collection which starts with the character o. 
 *
 */

public class D_ProcessCollect {

	public static void main(String[] args) {
		List<String> items = new ArrayList<String>();

		items.add("one");
		items.add("two");
		items.add("three");

		Stream<String> stream = items.stream();
		List<String> filtered = stream.filter( item -> item.startsWith("o")).collect(Collectors.toList());
		
		//List<String> filtered = stream.collect(Collectors.toList());
		
		for(String str : filtered){
			System.out.println(str);
		}
		
		System.out.println("Main ends");
		

	}

}
