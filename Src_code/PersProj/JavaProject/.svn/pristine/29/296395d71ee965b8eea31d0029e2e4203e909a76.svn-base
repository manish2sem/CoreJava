package CoreJava.J_Essential.Collection.lists.arraylistex;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * 
 * @author Manish
 * Basic operations used with collections:
 *  	Add : Add objects to the collection. - add(obj), add(inx,obj), addAll(col), addAll(inx,obj), set
 *  	Remove : Remove objects from the collection. - remove(obj), removeAll(Col), RetainAll(col).
 *  	Retrieve : Retrieve an object from the collection (without removing it). - get(indx).
 *  	Find : Find out if an object (or group of objects) is in the collection. -contains, containsAll, IndexOf, lastIndexOf.
 *  	Iterate : Iterate through the collection, looking at each element (object) one after another. - iterator, entrySet, values.
 *  	Basic : Others - isEmpty, size, clear.
 *  Other = listIterator; ensureCapacity; trimToSize;
 *  
 *  Concept talk :
 *  private transient E[] elementData : array buffer into which the elements of the ArrayList are stored.
 *  		The capacity of the ArrayList is the length of this array buffer.
 *  		size() returns no. of elements in elementData.
 *  		trimToSize() Trims the capacity of ArrayList to the list's current size. used to minimize the storage.
 *  
 *  Sorting & Ordered : 
 *   		All Lists implementations are ordered by index
 *   		and not sorted
 *  
 *  Add - Set : 
 *  add() always inserts a new element into the ArrayList.
 *  set() Replaces the element at the specified position, with the specified element
 *  
 *  ArrayList allows duplicates.
 *  
 *   
 *
 */

class ArrayListDemo { 
	  public static void main(String args[]) { 
	    // Create an array list. 
	    ArrayList al = new ArrayList(20); 
	   // al.trimToSize();
	    
	    System.out.println(al.isEmpty());
	    System.out.println(al.size()); 
	    
	    ArrayOp arrayOp = new ArrayOp();
	    arrayOp.add(al);
	 
	    //  Add - add. 
	    /*al.add("A"); 
	    al.add("B"); 
	    al.add("C"); 
	    al.add("D"); 	     
	    al.add(1, "E"); 
	    al.add("D");*/
	    
	   //Add - set = Replaces the element at the specified position, with the specified element
	    al.set(3, "X");
	    
	    Object arr[]=al.toArray();
	    System.out.println("length : " + arr.length);
	    
	    
	    
	   //Find : contains = returns Boolean.
	    System.out.println(al.contains("B"));
	    System.out.println(al.contains("F"));
	    
	   //Find : indexOf = returns position.
	    System.out.println("index : "+al.indexOf("Z"));
	    System.out.println("index : "+al.lastIndexOf("D"));
	    
	    	    
	    System.out.println("Size : " +  al.size()); 
	 
	    // Display the array list. 
	    System.out.println("Contents of al: " + al); 
	 
	    // Remove : remove = by value and by index. 
	    al.remove("D"); 
	    al.remove(2); 
	    
	 	     
	    System.out.println("Contents of al after removal: " + al); 
	    
	  //Retrieve : get = argument is index and returns the value.
	    String val = (String)al.get(1);
	    
	    System.out.println("Retrieved value: " + val); 
	    System.out.println("Contents of al after removal: " + al); 
	    
	    ArrayList bl = new ArrayList(); 
		   // al.trimToSize();
		    
		    		   
		 
		    //  Add - retainAll. 
		    bl.add("A"); 
		    bl.add("B"); 
		    bl.add("Y"); 
		    bl.add("X"); 
		    System.out.println("Contents of al : " + al); 
		    System.out.println("Contents of bl: " + bl); 


		    al.retainAll(bl);
		    System.out.println("Contents of al after retaining bl: " + al); 
	    

	    al.clear();
	    System.out.println("Size : " +  al.size());
	    
	    ListIterator li = al.listIterator();
	    Iterator itr = al.iterator();
	    
	  } 
	  
	 
	  
	}


class ArrayOp {
	  void add(ArrayList al){
		  al.add("A"); 
		    al.add("B"); 
		    al.add("C"); 
		    al.add("D"); 	     
		    al.add(1, "E"); 
		    al.add("D");		  
	  }
}


 