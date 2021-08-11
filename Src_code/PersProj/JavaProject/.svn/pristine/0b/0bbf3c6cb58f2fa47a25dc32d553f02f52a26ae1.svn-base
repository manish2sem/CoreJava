package CoreJava.J_Essential.Collection.sets;

/**
 * Basic Idea : 
 * <p>Hash table and linked list implementation of the <tt>Set</tt> interface, with predictable iteration order.  
 * This implementation maintains a doubly-linked list running through all of its entries. 
 * Performance is likely to be just slightly below that of <tt>HashSet</tt>, 
 * due to the added expense of maintaining the linked list, with one exception: 
 * Iteration over a LinkedHashSet requires time proportional to the size of the set, regardless of its capacity.  
 * Iteration over a HashSet is likely to be more expensive, requiring time proportional to its capacity. 
 * 
 * Basic operations used with collections:
 *  	Add : Add objects to the collection. - add(obj), addAll(col)
 *  	Remove : Remove objects from the collection. - remove(obj), removeAll(Col), RetainAll(col).
 *  	Find : Find out if an object (or group of objects) is in the collection. -contains(obj), containsAll(col)
 *  	Iterate : Iterate through the collection, looking at each element (object) one after another. - iterator.
 *  	Basic : Others - isEmpty, size, clear.
 *  
 * 
 *  Sorting & Ordered : 
 *   LinkedHashSet are ordered but not sorted.
 *   	
 *  
 *  Set does not allows duplicates.
 *  null is allowed
 *  Set excludes all indexed based operations.
 *  
 *  To get Synchronized Set
 *  Set s = Collections.synchronizedSet(new HashSet(...));
 *
 *
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

class LinkedHashSetBasics { 

	public static void main(String args[]) { 
		    // Create an array list. 
		    Set<String> mySet = new LinkedHashSet<String>(20);
		    HashSetBasics myHashSet = new HashSetBasics();
		    myHashSet.setInitialize(mySet);
		    myHashSet.display(mySet);
		    myHashSet.remove(mySet, "word");
		    myHashSet.remove(mySet, "Kumar");
		    myHashSet.display(mySet);
		    
	}
	
	public void setInitialize(Set<String> mySet){
		mySet.add("my");
		mySet.add("Name");
		mySet.add("Is");
		mySet.add("Manish");
		mySet.add("Kumar");
	}

	public void display(Set<String> mySet){
		for(String word : mySet) {
			System.out.println(word);
		}
		
	}
	
	public void remove (Set<String> mySet, String word) {
		if (mySet.contains(word)){
			mySet.remove(word);
		}else {
			System.out.println("word not found");
		}
	}
}
