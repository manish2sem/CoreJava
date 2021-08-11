package CoreJava.J_Essential.Collection.sets;

/**
 * Basic Idea : 
 * This class implements the Set interface, backed by a TreeMap instance.  
 * This class guarantees that the sorted set will be in ascending(natural order) element order. or 
 * by the comparator provided at  set creation time, depending on which constructor is used.
 * 
 * Note that the ordering maintained by a set (whether or not an explicit  comparator is provided) 
 * must be consistent with equals if it is to  correctly implement the Set interface.  
 * This is so because the Set interface is defined in  terms of the equals operation, but 
 * a TreeSet instance  performs all key comparisons using its compareTo (or compare) method, 
 * so two keys that are deemed equal by this method are, from the standpoint of the set, equal.  
 * The behavior of a set is well-defined even if its ordering is inconsistent with equals;
 * it just fails to obey the general contract of the Set interface.
 *
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
 *   TreeSet are not ordered but not sorted.
 *   	
 *  
 *  Set excludes all indexed based operations.
 *  
 *  To get Synchronized Set
 *  Set s = Collections.synchronizedSet(new HashSet(...));
 *
 *
 */


import java.util.Set;
import java.util.TreeSet;

class TreeSetDemo { 

	public static void main(String args[]) { 
		    // Create an array list. 
		    Set<String> mySet = new TreeSet<String>();
		    TreeSetDemo myHashSet = new TreeSetDemo();
		    myHashSet.setInitialize(mySet);
		    myHashSet.display(mySet);
		    myHashSet.remove(mySet, "word");
		    myHashSet.remove(mySet, "Kumar");
		    		    
			System.out.println("Display after Removal :");
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
