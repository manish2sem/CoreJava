package CoreJava.J_Essential.Collection.lists.arraylistex;

import java.util.*; 

/**
 * 
 * @author Manish
 * There are a few basic operations you'll normally use with collections:
 *  	Add objects to the collection.
 *  	Remove objects from the collection.
 *  	Find out if an object (or group of objects) is in the collection.
 *  	Retrieve an object from the collection (without removing it).
 *  	Iterate through the collection, looking at each element (object) one after another.
 *
 */

/**
 * Each vector tries to optimize storage management by maintaining a capacity and a capacityIncrement. 
 * The capacity is always at least as large as the vector size; it is usually larger because as components are added to the vector, the vector's storage increases in chunks the size of capacityIncrement. 
 * An application can increase the capacity of a vector before inserting a large number of components; this reduces the amount of incremental reallocation. 
 * Vector is synchronized.
 * The Iterators returned by Vector's iterator and listIterator methods are fail-fast:
 * The iterators returned by iterator and listIterator methods are fail-fast: 
 * if list is structurally modified at any time after the iterator is created, in any way except
 * through the iterator's own remove or add methods, the iterator will throw a
 * ConcurrentModificationException.  Thus, in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than risking
 * arbitrary, non-deterministic behavior at an undetermined time in the future.
 *
 * Note that the fail-fast behavior of an iterator cannot be guaranteed
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification. 
 * Fail-fast iterators throw ConcurrentModificationException on a best-effort basis. 
 * Therefore, it would be wrong to write a program that depended on this exception for its correctness. 
 * the fail-fast behavior of iterators should be used only to detect bugs. 
 */
	class VectorEx { 
	  public static void main(String args[]) { 
	 
	    // initial size is 3, increment is 2 
	    Vector v = new Vector(3, 2); 
	 
	    System.out.println("Initial size: " + v.size()); 
	    System.out.println("Initial capacity: " + v.capacity()); 
	 
	    v.addElement(1); //1
	    v.addElement(2); 
	    v.addElement(3); 
	    v.addElement(4); 
	    
	 
	    System.out.println("Capacity after four additions: " +  v.capacity()); 
	    v.addElement(5); 
	    System.out.println("Current capacity: " + v.capacity()); 
	    v.ensureCapacity(100);
	    System.out.println("Current capacity after increeasing: " + v.capacity());
	   
	 
	 
	    System.out.println("First element: " + v.firstElement()); 
	    System.out.println("Last element: " + v.lastElement()); 
	 
	    if(v.contains(3)) {//3
	      System.out.println("Vector contains 3."); 
	    }
	 
	    // Enumerate the elements in the vector. 5
	    Enumeration vEnum = v.elements(); 
	 
	    System.out.println("\nElements in vector:"); 
	    while(vEnum.hasMoreElements()) {
	      System.out.print(vEnum.nextElement() + " "); 
	    }
	    System.out.println(); 
	    
	    Iterator ite = v.iterator();
	    while(ite.hasNext()){
	    	System.out.print(ite.next() + " "); 
	    }
	    v.add(3, 10);
	  //  Iterator ite1 = v.iterator();
	    while(ite.hasNext()){                       //Fail fast concept
	    	System.out.print(ite.next() + " "); 
	    }
	    
	  }

	}


