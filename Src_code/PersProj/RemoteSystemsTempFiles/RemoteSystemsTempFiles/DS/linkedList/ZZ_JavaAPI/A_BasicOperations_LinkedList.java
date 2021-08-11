package DS.linkedList.ZZ_JavaAPI;

import java.util.Iterator;
import java.util.LinkedList;

public class A_BasicOperations_LinkedList {

	public static void main(String a[]){

		LinkedList<String> linkedList = new LinkedList<String>();
		addElement(linkedList);
		System.out.println(linkedList);
		System.out.println("Size of the linked list: "+linkedList.size());
		System.out.println("Is LinkedList empty? "+linkedList.isEmpty());
		System.out.println("Does LinkedList contains 'Grape'? "+linkedList.contains("Grape"));

		// IteratingList(linkedList);

		readFirstElement(linkedList);
	}

	static void addElement(LinkedList<String> ll){
		ll.add("Orange");
		ll.add("Apple");
		ll.add("Grape");
		ll.add("Banana");
	}

	static void IteratingList(LinkedList<String> ll){

		Iterator<String> itr = ll.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}		
	}

	/**
	 * LinkedList provides few methods to read first element, those methods are:
	 * element(): Retrieves, but does not remove, the head (first element) of this list.
	 * getFirst(): Returns the first element in this list. 
	 *  peek(): Retrieves, but does not remove, the head (first element) of this list.
	 *  peekFirst(): Retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
	 * @param ll
	 */
	static void readFirstElement(LinkedList<String> ll){		
		System.out.println("First Element: "+ll.element());
		System.out.println("First Element: "+ll.getFirst());
		System.out.println("First Element: "+ll.peek());
		//   System.out.println("First Element: " ll.peekFirst());		
	}

	/*static void reverseIterating(LinkedList<String> ll){

		Iterator<String> itr = ll.descendingIterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}		
	}*/


}
