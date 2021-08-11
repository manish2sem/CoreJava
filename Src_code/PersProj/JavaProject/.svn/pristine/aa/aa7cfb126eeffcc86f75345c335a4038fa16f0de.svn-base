package CoreJava.J_Essential.Collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * any classes that you use as a part of the keys for map must override the hashCode() and equals() methods. 
 * you only have to override them if you're interested in retrieving stuff from your Map. 
 * it's legal to use a class that doesn't override equals() and hashCode() as a key in a Map, 
 * your code will compile and run,
 * you just won't find your stuff.
 * 
 * 
 * retrieval occurs in following two stages : 
 * 1. Use the hashcode() method to find the correct bucket
 * 2. Use the equals() method to find the object in the bucket
 */

public class MapConceots {
	public static void main(String[] args) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("k1", new Dog("aiko")); // add some key/value pairs

		Dog d1 = new Dog("clover"); // let's keep this reference
		m.put(d1, "Dog key");
		m.put(new Cat("pussy"), "Cat key");
		System.out.println(m.get("k1")); // #1
		System.out.println(m.get("k2")); // #2
		System.out.println(m.get(d1)); // #3
		System.out.println(m.get(new Dog("clover"))); // #4
		System.out.println(m.get(new Cat("pussy"))); // #5
		System.out.println(m.size()); // #6
		
		//what happens when an object used as a key has its values changed?
		System.out.println(" OUTPUT when key has its values changed");
		System.out.println(); 
		
		d1.name = "magnolia";
		System.out.println(m.get(d1));
		d1.name = "arthuh";
		System.out.println(m.get(d1));
		d1.name = "aiko";
		System.out.println(m.get(d1));
		
	}
}





class Dog {
	public String name;
	public Dog(String n) { 
		name = n; 
	}
	
	public boolean equals(Object o) {
		if((o instanceof Dog) &&
				(((Dog)o).name == name)) {
			return true;
		} else {
			return false;
		}
	}
	
	public int hashCode() {	
		return name.length(); 
	}
	
}


class Cat { 
	public String name;
	public Cat(String n) { 
		name = n; 
	}
	public Cat() { 
		
	}
}

