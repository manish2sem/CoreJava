package CoreJava.J_Importent.CollectionsClass.Basic;

import java.util.Arrays;
import java.util.List;

/**
 * VVI:
 * When you use the asList() method, the array and the List become joined at the hip. 
 * When you update one of them, the other gets updated automatically.
 * 
 * Note, this is true only for Arrays.asList() not for List.toArray()
 *
 */

public class C_ChangeReflects {
	public static void main(String[] args) {
		String[] sa = {"one", "two", "three", "four"};
		List sList = Arrays.asList(sa); // make a List

		sList.set(3,"six"); // change List
		sa[1] = "five"; // change array
		
		for(String s : sa){
			System.out.print(s + " ");
		}

		System.out.println("\nsl[1] " + sList.get(1));

	}

}
