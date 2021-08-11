package CoreJava.J_Essential.Collection.map.TreeMapExmpl;

import java.util.TreeMap;
//import java.util.Entry;

/**
 * Since TreeMaps are sorted by keys, the object for key has to be able to compare with each other, that's why it has to implement Comparable interface. 
 * For example,  you use String as key, because String implements Comparable interface.  Let's change the Dog, and make it comparable.  
 * @author sinhama
 *
 */

public class TreeMapEx {
	public static void main(String[] args) {
		Dog d1 = new Dog("red", 30);
		Dog d2 = new Dog("black", 20);
		Dog d3 = new Dog("white", 10);
		Dog d4 = new Dog("white", 10);
		TreeMap<Dog, Integer> treeMap = new TreeMap<Dog, Integer>();

		treeMap.put(d1, 20); //java.lang.ClassCastException: Dog cannot be cast to java.lang.Comparable
		treeMap.put(d2, 5);
		treeMap.put(d3, 15);
		treeMap.put(d4, 10);

		for (Dog dog : treeMap.keySet()) {
			System.out.println(dog.toString());
		}
	}

}

class Dog {
	String color;
	int size;

	Dog(String c, int s) {
		color = c;
		size = s;
	}

	public String toString(){  
		return color + " dog";
	}

}

