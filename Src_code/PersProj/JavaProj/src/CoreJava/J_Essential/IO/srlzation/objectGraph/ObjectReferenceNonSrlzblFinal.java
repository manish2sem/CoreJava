package CoreJava.J_Essential.IO.srlzation.objectGraph;
/**
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Java serialization has a special mechanism to deal with deserialization of 
 *a set of private methods you can implement in your class that, if present, 
 *will be invoked automatically during serialization and deserialization. 
 *It's almost as if the methods were defined in the Serializable interface, except they aren't.
 * They are part of a special callback contract the serialization system offers you that basically says,
 *  "If you (the programmer) have a pair of methods matching this exact signature 
 *   these methods will be called during the serialization/deserialization process.
 */
public class ObjectReferenceNonSrlzblFinal {

	public static void main(String[] args) throws Exception{
		CollarNonSrlzbl ocllar = new CollarNonSrlzbl(10);
		Rat rat = new Rat(ocllar, 20);
		
		File fileName= new File("Rat.ser");
		FileOutputStream os =new FileOutputStream(fileName); 
		ObjectOutputStream obj =new ObjectOutputStream(os);
		obj.writeObject(rat);
		obj.close();
		System.out.println("After susseccful serialization");
		
		FileInputStream fileinput =new FileInputStream(fileName); 
		ObjectInputStream objInput =new ObjectInputStream(fileinput);
		Rat dogDeSer = (Rat) objInput.readObject();
		System.out.println("After susseccful De-serialization");
		System.out.println("Collar Size = "+dogDeSer.getCollar().getCollarSize());
		
	}
}


class Rat implements Serializable{
	private transient CollarNonSrlzbl theCollar;
	private int catSize;
	
	public Rat(CollarNonSrlzbl collar, int size) {
		theCollar = collar;
		catSize = size;
	}
	
	public CollarNonSrlzbl getCollar() { 
		return theCollar; 
	}
	
	private void writeObject(ObjectOutputStream os) {
		// throws IOException { // 1
		try {
			os.defaultWriteObject(); // 2
			os.writeInt(theCollar.getCollarSize()); // 3
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	private void readObject(ObjectInputStream is) {
		// throws IOException, ClassNotFoundException { // 4
		try {
			is.defaultReadObject(); // 5
			theCollar = new CollarNonSrlzbl(is.readInt()); // 6
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
}
