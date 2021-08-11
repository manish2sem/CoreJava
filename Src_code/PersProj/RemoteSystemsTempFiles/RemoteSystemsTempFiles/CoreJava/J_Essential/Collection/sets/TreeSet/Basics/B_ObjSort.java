package CoreJava.J_Essential.Collection.sets.TreeSet.Basics;

import java.util.Set;
import java.util.TreeSet;

import CoreJava.J_Essential.Collection.SampleObj.ComprableDog;

/**
 *  This code will work fine as ComprableDog object implements Comparable interface
 */
public class B_ObjSort {

	public static void main(String[] args) {
		Set<ComprableDog> treeSet = new TreeSet();
		treeSet.add(new ComprableDog("A")); 
		treeSet.add(new ComprableDog("Z"));
		treeSet.add(new ComprableDog("F"));
		
		for(ComprableDog dog : treeSet){
			System.out.println(dog.getName());
		}
	}
}
