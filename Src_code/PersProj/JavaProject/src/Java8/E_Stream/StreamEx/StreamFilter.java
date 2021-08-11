package Java8.E_Stream.StreamEx;

/**
 * https://www.tutorialspoint.com/java8/java8_streams.htm
 */

import java.util.Arrays;
import java.util.List;

public class StreamFilter {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		System.out.println("List: " + strings);
		
		System.out.println("Using java 7 " + getCountEmptyStringJava7(strings) );
		System.out.println("Using java 8 " + getCountEmptyStringJava8(strings) );
		
		
		System.out.println("Using java 7 string length > 3 : " + getCountLength3Java7(strings) );
		System.out.println("Using java 8 string length > 3 : " + getCountLength3Java8(strings) );
	}

	private static int getCountEmptyStringJava7(List<String> strings) {
		int count = 0;

		for (String string : strings) {

			if (string.isEmpty()) {
				count++;
			}
		}
		return count;
	}

	private static long getCountEmptyStringJava8(List<String> strings) {

		long count = strings.stream().filter(string -> string.isEmpty()).count();
		return count;
	}
	
	
	
	private static int getCountLength3Java7(List<String> strings) {
	      int count = 0;
			
	      for(String string: strings) {
			
	         if(string.length() == 3) {
	            count++;
	         }
	      }
	      return count;
	   }
	
	private static long getCountLength3Java8(List<String> strings) {
		long count = strings.stream().filter(string -> string.length() == 3).count();
		return count;
	   }

}

