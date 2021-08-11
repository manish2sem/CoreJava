package CoreJava.J_Essential.Collection.general.failfast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * An Iterator is an object that's associated with a specific collection. 
 * It let's you loop through the collection step by step.
 * 
 * The three Iterator methods are :
 * 
 * boolean hasNext() Returns true if there is at least one more element in the collection being traversed.
 *  	Invoking hasNext() does NOT move you to the next element of the collection.
 *  
 * object next() This method returns the next object in the collection,
 * 		AND moves you forward to the element after the element just returned.
 * 
 * void remove  Removes from the underlying collection the last element returned by the iterator (optional operation). 
 * This method can be called only once per call to next. 
 *
 */

public class A2_IteratorConcept {
	public static void main(String args[]) { 
		 
		String statement ="My name is manish kumar";
		 ArrayList arrayList  = new ArrayList(Arrays.asList(statement.split(" ")));  //Unordered set
	//	 arrayList.add("Singh");  //This will not fail-fast because ArrayList is modified before iterator is created
		 Iterator<String> itr = arrayList.iterator();
		
		// arrayList.remove("kumar"); //This will fail-fast because ArrayList is modified After iterator is created.

		 while(itr.hasNext()){
			    String str = itr.next();
		    	System.out.print(str+ " " ); 
		    	if (str.equals("kumar")){
		    		itr.remove();            // This will not fail-fast
		    	//	arrayList.remove("kumar"); //This will fail-fast
		    	}
		    }
	//	 arrayList.add("Singh");  //This will fail-fast because ArrayList is modified After iterator is created.
		 Iterator<String> itr1 = arrayList.iterator();
		 while(itr1.hasNext()){
		    	System.out.println(itr1.next() + " "); 
		    }
		 
	 }

}
