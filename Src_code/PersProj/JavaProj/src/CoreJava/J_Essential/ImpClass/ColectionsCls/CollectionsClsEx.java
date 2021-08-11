package CoreJava.J_Essential.ImpClass.ColectionsCls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsClsEx {
	
	public static void main(String[] args) {
		List<String> mylist = new ArrayList<String>();
		
		mylist.add("Manish");
		mylist.add("Kishore");
		mylist.add("Samrat");
		mylist.add("Virat");
		
		CollectionsClsEx collectionsMethods = new CollectionsClsEx();
		
		List<String> unmodifiableList = collectionsMethods.unmodifiableList(mylist);
		for (String name : unmodifiableList) {
			System.out.println("name : " + name);
		}
		
		//unmodifiableList.add("Moh");
		System.out.println(unmodifiableList.isEmpty());
		System.out.println(unmodifiableList.contains("Virat"));
		System.out.println(unmodifiableList.size());
		unmodifiableList.clear();					//UnsupportedOperationException
		//unmodifiableList.remove(1);
		
		
		
	}
	
	/**
	* This method allows modules to provide users with "read-only" access to internal lists.  
	* Query operations on the returned list "read through" to the specified list, and 
	* attempts to modify the returned list, whether direct or via its iterator, 
	* result in an UnsupportedOperationException.
	* The returned list will be serializable if the specified list is serializable.
	* 
	* public static <T> List<T> unmodifiableList(List<? extends T> list)
    * 
    */
	private List<String> unmodifiableList(List<String> mylist) {
		List<String> unmodifialeList = Collections.unmodifiableList(mylist);		
		return unmodifialeList;
	}
	
	
	/**
	 *  public static <T> List<T> singletonList(T o) 
	 * 
	 */
	/*private List<String> immutableList(String name) {
		List<List<String>> immutableList = Collections.singletonList(mylist);
		return immutableList;
	}*/
	
	private List<String> synchronizedList(List<String> mylist) {
		List<String> immutableList = Collections.synchronizedList(mylist);
		return immutableList;
	}
	
	
	/**
	 * Returns a dynamically typesafe view of the specified list.
     * Any attempt to insert an element of the wrong type will result in an immediate ClassCastException.  
     * Assuming a list contains no incorrectly typed elements prior to the time a dynamically typesafe
     * view is generated, and that all subsequent access to the list
     * takes place through the view, it is guaranteed that the
     * list cannot contain an incorrectly typed element.
	 * @param mylist
	 * @return
	 */
	private List<String> synchronizedList(List<String> mylist) {
		List<String> immutableList = Collections.checkedList(mylist);
		return immutableList;
	}
	
	

}
