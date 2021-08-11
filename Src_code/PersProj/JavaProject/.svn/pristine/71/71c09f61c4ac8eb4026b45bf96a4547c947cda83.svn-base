package CoreJava.J_Essential.Collection.general.failfast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
* The iterators returned by this class's iterator and listIterator methods are fail-fast.
* if list is structurally modified at any time after the iterator is created, in any way except
* through the iterator's own remove or add methods, the iterator will throw a ConcurrentModificationException.
* Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking
* arbitrary, non-deterministic behavior at an undetermined time in the future.
*
* Note that the fail-fast behavior of an iterator cannot be guaranteed
* as it is, generally speaking, impossible to make any hard guarantees in the
* presence of unsynchronized concurrent modification.  
* Fail-fast iterators throw ConcurrentModificationException on a best-effort basis. 
* Therefore, it would be wrong to write a program that depended on this exception for its correctness. 
* the fail-fast behavior of iterators should be used only to detect bugs.
* **/
public class A1_FailFastConcept {
	
	public static void main(String args[]) { 
		 
		String statement ="My name is manish kumar";
		 ArrayList arrayList  = new ArrayList(Arrays.asList(statement.split(" ")));  //Unordered set
	//	 arrayList.add("Singh");  //This will not fail-fast because ArrayList is modified before iterator is created
		 Iterator itr = arrayList.iterator();
		
		 arrayList.add("Singh"); //This will fail-fast because ArrayList is modified After iterator is created.

		 System.out.print("runtime exception after this, when iterator encountes next "); 
		 while(itr.hasNext()){
		    	System.out.print(itr.next() + " "); 
		    }
	//	 arrayList.add("Singh");  //This will fail-fast because ArrayList is modified After iterator is created.
		 while(itr.hasNext()){
		    	System.out.println(itr.next() + " "); 
		    }
		 
	 }
}
