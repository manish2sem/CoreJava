package CoreJava.J_Essential.Collection.sets;

/**
 * Basic Idea : 
 * This class implements the Set interface, backed by a hash table (actually a HashMap instance).
 * This class offers constant time performance for the basic operations (add, remove, contains and size),
 * Iterating over this set requires time proportional to the sum of
 * the number of elements and Capacity(the number of buckets).  
 * 
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
 *   Generally Sets are not ordered not sorted.
 *   	Ordered Set - LinkedHashSet
 *   	Sorted Set - Tree Set 
 *  
 *  
 *  Set does not allows duplicates.
 *  null is allowed
 *  Set excludes all indexed based operations.
 *  The iterators returned by this class's <tt>iterator</tt> method are fail-fast.
 *  
 *  To get Synchronized Set
 *  Set s = Collections.synchronizedSet(new HashSet(...));
 *
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class HashSetBasics { 

	public static void main(String args[]) { 
		    // Create an array list. 
		    Set<String> mySet = new HashSet<String>(20);
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
	
	public void anotherDisplay(Set<String> mySet){
		
		Iterator itr = mySet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr);
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
