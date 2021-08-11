package CoreJava.J_Essential.IO.srlzation.objectGraph;

import java.io.*;


/**
 * When you serialize an object, Java serialization takes care of saving that object's entire "object graph." 
 * That means a deep copy of everything the saved object needs to be restored.
 * 
 * For example, if you serialize a Dog object, the Collar will be serialized automatically. 
 * And if the Collar class contained a reference to another object, THAT object would also be serialized, and so on. 
 * And the only object you have to worry about saving and restoring is the Dog. 
 * The other objects required to fully reconstruct that Dog are saved (and restored) automatically through serialization.
 * To work this all the object coming to the path must be Serializable. 
 *
 */
public class ObjectReference {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Collar ocllar = new Collar(10);
		Dog dog = new Dog(ocllar, 20);
		
		File fileName= new File("Dog.ser");
		FileOutputStream os =new FileOutputStream(fileName); 
		ObjectOutputStream obj =new ObjectOutputStream(os);
		obj.writeObject(dog);
		obj.close();
		System.out.println("After susseccful serialization");
		
		FileInputStream fileinput =new FileInputStream(fileName); 
		ObjectInputStream objInput =new ObjectInputStream(fileinput);
		Dog dogDeSer = (Dog) objInput.readObject();
		System.out.println("After susseccful De-serialization");
		System.out.println("Collar Size = "+dogDeSer.getCollar().getCollarSize());
		
	}

}


class Dog implements Serializable{
	private Collar theCollar;
	private int dogSize;
	
	public Dog(Collar collar, int size) {
		theCollar = collar;
		dogSize = size;
	}
	
	public Collar getCollar() { 
		return theCollar; 
	}
}

class Collar implements Serializable{
	private int collarSize;
	public Collar(int size) { 
		collarSize = size; 
	}
	public int getCollarSize() { 
		return collarSize; 
	}
}

