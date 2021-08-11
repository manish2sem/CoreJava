package DS.linkedList.ZZ_JavaAPI;

import java.util.Collections;
import java.util.LinkedList;

public class B_BasicLinkedListOpThroughCollections {

	public static void reverse(LinkedList<String> linkedList){
		Collections.reverse(linkedList);
		System.out.println("Results after reverse operation:");
		for(String str: linkedList){
			System.out.println(str);
		}

	}

	public static void sort(LinkedList<String> linkedList){

	}


	public static void shuffle(LinkedList<String> linkedList){
		Collections.shuffle(linkedList);
		System.out.println("Results after shuffle operation:");
		for(String str: linkedList){
			System.out.println(str);
		}

	}        


	public static void swap(LinkedList<String> linkedList, int firstIndex, int secondIndex ){
		
		Collections.swap(linkedList, firstIndex, secondIndex);
        System.out.println("Results after swap operation:");
        for(String str: linkedList){
            System.out.println(str);
        }

	}


	/*public static void reverse(LinkedList linkedList){

	}
	 */

}
