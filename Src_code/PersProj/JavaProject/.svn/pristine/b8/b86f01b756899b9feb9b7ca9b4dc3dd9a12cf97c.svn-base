package CoreJava.J_Importent.CollectionsClass.Basic;

import java.util.ArrayList;

/**
 * 
 *  When you use the List.toArray() method, the array and the List are not joined at the hip. 
 *  
 * @author sinhama
 *
 */

public class D_ChangeReflectsToArrays {
	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("abc");
		myList.add("bcd");
		myList.add("cde");
		myList.add("def");

	//	String[] myArray = myList.toArray(new String[4]);
		
		Object[] myArray = myList.toArray();
		
		myArray[1] = "five"; // change array. Will not affect List

		for(Object str: myList) {
			System.out.print((String)str + " ");
		}
		
		System.out.println(" ");
		
		myList.set(1,"One");  // change List. Will not affect Array
		for(Object str: myArray) {
			System.out.print((String)str+ " ");
		}
	}
}
