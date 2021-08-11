package CoreJava.J_Essential.Collection.general.collectionsConcept;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

/**
 *  @author Manish
 *  In General, Lists are ordered by index. Ex : ArrayList, LinkedList, Vector
 *  Maps/Hash are not ordered. Ex : HashMap, HashSet, HashTable etc
 *  But LinkedHashMap and LinkedHashSet are ordered.
 *
 */

public class C_OrderUnorderConcept {
	 public static void main(String args[]) { 
		 
		 String statement= "My Name is Manish Kumar";
		 Set hashSet = new HashSet(Arrays.asList(statement.split(" ")));  //Unordered set
		 Iterator itr = hashSet.iterator();
		// The output will be not in the same order in which list is inserted.
		 while(itr.hasNext()){
		    	System.out.print(itr.next() + " "); 
		    }
		 
		 System.out.println( " ");
		 Set linkedHashSet = new LinkedHashSet(Arrays.asList(statement.split(" "))); // Ordered Set
		 Iterator ite = linkedHashSet.iterator();
		// The output will be in the same order in which list is inserted.
		 while(ite.hasNext()){
		    	System.out.print(ite.next() + " "); 
		    }
		 
	 }

}
