package CoreJava.J_Essential.IO.srlzation.objectGraph;

/**
 * We can not serialize a object if it refer to an object which is not serializable.
 * Cat can not be serializable because it refers CollarNonSrlzbl object which is not serializable.
 * We get runtime exception ->  java.io.NotSerializableException;
 * Solution -> make variable CollarNonSrlzbl transient.
 * Now we can serialize cat class.
 * 
 * But deserialization throws null pointer exception.
 * Reason: when the Cat is deserialized, it comes back with a null Collar.
 * Solution see ObjectReferenceNonSrlzblFinal
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectReferenceNonSrlzbl {
	
	public static void main(String[] args) throws Exception{
		CollarNonSrlzbl ocllar = new CollarNonSrlzbl(10);
		Cat dog = new Cat(ocllar, 20);
		
		File fileName= new File("Cat.ser");
		FileOutputStream os =new FileOutputStream(fileName); 
		ObjectOutputStream obj =new ObjectOutputStream(os);
		obj.writeObject(dog);
		obj.close();
		System.out.println("After susseccful serialization");
		
		FileInputStream fileinput =new FileInputStream(fileName); 
		ObjectInputStream objInput =new ObjectInputStream(fileinput);
		Cat dogDeSer = (Cat) objInput.readObject();
		System.out.println("After susseccful De-serialization");
		System.out.println("Collar Size = "+dogDeSer.getCollar().getCollarSize());
		
	}

}


class Cat implements Serializable{
	private transient CollarNonSrlzbl theCollar;
	private int catSize;
	
	public Cat(CollarNonSrlzbl collar, int size) {
		theCollar = collar;
		catSize = size;
	}
	
	public CollarNonSrlzbl getCollar() { 
		return theCollar; 
	}
}


class CollarNonSrlzbl {
	private int collarSize;
	public CollarNonSrlzbl(int size) { 
		collarSize = size; 
	}
	public int getCollarSize() { 
		return collarSize; 
	}
}

