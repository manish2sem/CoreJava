package CoreJava.J_Essential.Collection.sets.TreeSet.Basics;

import java.util.Set;
import java.util.TreeSet;

import CoreJava.J_Essential.Collection.SampleObj.Cow;

/** 
 * We can't add any object into TreeSet
 * 	Which doesn't implements Comparable. 
 *
 */
public class A_ObjSort {
	
	public static void main(String[] args) {
		Set<Cow> treeSet = new TreeSet();
		treeSet.add(new Cow()); //java.lang.ClassCastException: Cow cannot be cast to java.lang.Comparable
		treeSet.add(new Cow());
		treeSet.add(new Cow());
	}

}
