package CoreJava.J_Essential.Collection.sets.TreeSet.Basics;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import CoreJava.J_Essential.Collection.SampleObj.Dog;

/**
 * If TreeSet need to store those objects which doesn't implements comparable
 * In theses cases create the TreeSet with Comparator object
 * @author Manish
 *
 */
public class C_Comprator {

	public static void main(String[] args) {
		Set<Dog> treeSet = new TreeSet(new MyComparator());
		treeSet.add(new Dog("Rocket")); //java.lang.ClassCastException: Cow cannot be cast to java.lang.Comparable
		treeSet.add(new Dog("Zimmy"));
		treeSet.add(new Dog("Tiger"));
		
		for(Dog dog : treeSet){
			System.out.println(dog.getName());
		}

	}

}

class MyComparator implements Comparator<Dog>{

	@Override
	public int compare(Dog dog1, Dog dog2) {		
		return dog1.getName().compareTo(dog2.getName());
	}
	
}
