package CoreJava.J_Essential.IO.srlzation.Inheritence;

import java.io.*;
import java.io.Serializable;

/**
 * When an instance of a serializable class is deserialized, the constructor does not run, and 
 * instance variables are NOT given their initially assigned values!
 * Reason -
 * 	if the constructor were invoked, and/or instance variables were assigned the values given in their declarations, 
 *  the object you’re trying to restore would revert back to its original state, 
 *  rather than coming back reflecting the changes in its state that happened sometime after it was created. 
 * 
 * The point is, when an object is deserialized we do NOT want any of the normal initialization to happen. 
 * We don’t want the constructor to run, and we don’t want the explicitly declared values to be assigned.
 * We want only the values saved as part of the serialized state of the object to be reassigned. 
 * 
 * It gets a little trickier when the serializable class has one or more non-serializable superclasses. 
 * 
 * If you have a serializable class, but your superclass is NOT serializable, then 
 * any instance variables you INHERIT from that superclass will be reset to the values 
 * they were given during the original construction of the object.
 * This is because the non-serializable class constructor WILL run! 
 * 
 * In fact, every constructor ABOVE the first non-serializable class constructor will also run, no matter what, 
 * because once the first super constructor is invoked, (during deserialization), 
 * it of course invokes its super constructor and so on up the inheritance tree.
 * 
 */
public class SuperNotSerial {
	
	public static void main(String [] args) {
		Dog d = new Dog(35, "Fido");
		System.out.println("before: " + d.name + " " + d.weight);
		try {
			FileOutputStream fs = new FileOutputStream("testSer.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			os.close();
		} catch (Exception e) { e.printStackTrace(); }
		try {
			FileInputStream fis = new FileInputStream("testSer.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			d = (Dog) ois.readObject();
			ois.close();
		} catch (Exception e) { e.printStackTrace(); }
			System.out.println("after: " + d.name + " "	+ d.weight);
		}

}

class Dog extends Animal implements Serializable {
	String name;
	//int weight;
	Dog(int w, String n) {
		weight = w; // inherited
		name = n; // not inherited
	}
}

class Animal { // not serializable !
	int weight = 42;
	String name ;
	Animal(){
		weight = 12;
		name = "tiger";
	}
	
}

/**
 * Remember, when an object is constructed using new (as opposed to being deserialized), the following things happen (in this order): 
 *  - All instance variables are assigned default values. 
 *  - The constructor is invoked, which immediately invokes the superclass constructor (or another overloaded constructor, until one of the overloaded constructors invokes the superclass constructor). 
 *  - All superclass constructors complete. 
 *  - Instance variables that are initialized as part of their declaration are assigned their initial value (as opposed to the default values they’re given prior to the superclass constructors completing). 
 *  - The constructor completes. 
 *  
 *  Because Animal is NOT serializable, any state maintained in the Animal class,
 *  even though the state variable is inherited by the Dog, isn’t going to be restored with the Dog when it’s deserialized! 
 *  The reason is, the (unserialized) Animal part of the Car is going to be reinitialized just as it would be 
 *  if you were making a new Car (as opposed to deserializing one).
 *  That means all the things that happen to an object during construction, will happen—but only to the Animal parts of a Dog. 
 *  In other words, the instance variables from the Dog’s class will be serialized and deserialized correctly, 
 *  but the inherited variables from the non-serializable Automobile superclass will come back with 
 *  their default/initially assigned values rather than the values they had at the time of serialization. 
 */