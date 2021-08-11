package CoreJava.J_Essential.Collection.general.comprble.Basic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Manish
 * The sort() method of Collections takes a List argument,
 * and that the objects in the List must implement an interface called Comparable. 
 * Dog does not implements Comparable, and that's why Collections.sort() method does not work here. 
 * 
 * To make it work Dogclass should implement Comparable interface.
 * 		See next example.
 * 
 * public final class String implements java.io.Serializable, 
 *        Comparable<String>, CharSequence{}
 *        
 *        
 * Collections is the class that holds static utility methods for use with collections.
 */

public class B_ComparableNotWorksSimple {
	
	public static void main(String[] args) {
		ArrayList<Dog> dogList = new ArrayList<Dog>(); // #1
		dogList.add(new Dog("jimmy"));   
		dogList.add(new Dog("Tomy")); 
		dogList.add(new Dog("Tiget")); 
		dogList.add(new Dog("Sheru")); 
		
	//	Collections.sort(dogList); // Compiler Error : Bound mismatch : Dog is not a valid substitute for bounded param <T extends Comparable<? super T>> 
		System.out.println("sorted " + dogList);
	}	

}

class Dog {
	String name;
	Dog(String name) {
		this.name =name;
	}
	
}
