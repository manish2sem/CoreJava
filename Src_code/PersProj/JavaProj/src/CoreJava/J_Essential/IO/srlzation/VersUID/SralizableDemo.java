package CoreJava.J_Essential.IO.srlzation.VersUID;

/**
 * You serialized the class MyClass.
 * Before de-serialization you changed the class. i.e. changed one instance variable type int to double.
 * Now you deserialized the class. 
 * You will get run time exception.
 * local class incompatible: stream classdesc serialVersionUID = -5354086768898665620, local class serialVersionUID = -5209777712990439730	
 * 
 * Concept:
 * Each time an object is serialized the object is stamped with a version ID no.[serialVersionUID] for the object class.
 * This ID is computed based on info about the class structure.
 * As an object is being deserialized the class could have a different version-ID(due to change in class) and deserialization will fail.
 * 
 * Solution:
 * If you think there is ANY possibility that your class might evolve, put a serial version ID in your class.
 *  
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SralizableDemo {
	
	public static void main(String args[]){
	
		MyClass class1 = new MyClass(1,2.3,"Manish", "Kumar");	
	
		try{
			FileOutputStream os =new FileOutputStream("xyz.ser"); //low-level obj of FileOutputStream connects to file.
			
		//	Here we have used stream because we are dealing with bytes of data.
			ObjectOutputStream objos= new ObjectOutputStream(os); //High-level ObjectOutputStream deals with low-level FileOutputStream object
			objos.writeObject(class1);
			objos.close();
			System.out.println("After susseccful serialization");
		}catch(FileNotFoundException e){
			System.out.println("Exception");
		
		}catch(IOException e){
			System.out.println("Exception");		
		}
	}
}


