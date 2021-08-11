package CoreJava.J_Importent.CollectionsClass.Arrays.Search;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Important point while searching Collections/Arrays class.
 * - The collection/array being searched must be sorted before you can search it.
 * - If you attempt to search an array or collection that has not already been sorted, the results of the search will not be predictable.
 * -  If the collection/array you want to search was sorted in natural order, it must be searched in natural order. 
 * ( this is accomplished by NOT sending a Comparator as an argument to the binarySearch() method.)
 *  - If the collection/array you want to search was sorted using a Comparator, it must be searched using the same Comparator,
 *    which is passed as the second argument to the binarySearch() method. 
 *  - Remember that Comparators cannot be used when searching arrays of primitives.
 * 
 *
 */

public class SearchObjArray {

	public static void main(String [] args) {
		String [] sa = {"one", "two", "three", "four"};
		System.out.println("four = " + Arrays.binarySearch(sa,"four")); // #2
		
		Arrays.sort(sa); // #1
		for(String s : sa)
			System.out.print(s + " ");
		System.out.println("\none = " + Arrays.binarySearch(sa,"one")); // #2
		System.out.println("now reverse sort");
		ReSortComparator rs = new ReSortComparator(); // #3
		Arrays.sort(sa,rs);
		
		for(String s : sa)
			System.out.print(s + " ");
		
		System.out.println("\none = " + Arrays.binarySearch(sa,"one")); // #4
		System.out.println("one = " + Arrays.binarySearch(sa,"one",rs)); // #5
	}

	static class ReSortComparator implements Comparator<String> { // #6
		public int compare(String a, String b) {
			return b.compareTo(a); // #7
		}
	}
}


