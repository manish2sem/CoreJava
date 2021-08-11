package CoreJava.J_Essential.xceptionHandling.Basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * java.lang.Throwable class has two child classes: Exception and Error.
 * The Error class is the parent class of all Java errors; 
 * the Exception class is the parent class of all exceptions, both run time and checked.
 * 
 * If a class is a child of Runtime-Exception, this child class represents a runtime exception.
 * If a class is a child of Exception but not a child of RuntimeException, this class is a checked exception.
 * Exceptions are Java objects of type Throwable. When you catch an exception, you catch a reference to a Java object.
 * 
 * With multiple catch blocks, the order in which the catch blocks are listed 
 * is the order they are checked when an exception occurs.
 */

public class BasicTryCatchBlock {
	
	private String fileName;
	public BasicTryCatchBlock(String name){
		fileName = name;
	}
	public byte readOneByte(){
		FileInputStream file = null;
		byte x = -1;
		try	{
			System.out.println("Opening file for reading...");
			file = new FileInputStream(fileName);
			System.out.println("Just opened file: " + fileName);
			System.out.println("Reading one byte from file...");
			x = (byte) file.read();
		}catch(FileNotFoundException f){
			System.out.println("** Could not find fileName **");
			f.printStackTrace();
			return -1;
		}catch(IOException i){
			System.out.println("** Error reading one byte **");
			i.printStackTrace();
			return -1;
		}
		System.out.println("Just read " + x);
		return x;
	}

}
