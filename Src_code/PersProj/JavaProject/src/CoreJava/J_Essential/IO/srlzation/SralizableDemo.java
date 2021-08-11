package CoreJava.J_Essential.IO.srlzation;

/**
 * Serialization lets you save the object(Serializable) and all of its instance variables. but not all
 * Serializable objects are those which implements marker interface Serializable.
 * Followings are the exceptions : transient, static variables,
 * 
 *  
 * BURN IN YOUR MIND :
 *  Every IO operation takes one LOW-level and zero and more High-level classes.
 *  In Serialization we need one LOW-level and one High-level classes. 
 *  Low-Level class FileOutputStream is used as we need to copyobjects in terms of bytes.
 *  High-Level class ObjectOutputStream is used to persist objects state.
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
			FileOutputStream os = new FileOutputStream("xyz.ser"); //low-level obj of FileOutputStream connects to file.
			
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


/**
 * This is Serializable object as it implements Serializable.
 *
 */
class MyClass implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	transient int i;
	double d;
	static String staticStr;
	String normString;

	
	public MyClass(int i, double d, String str, String norStr){
		this.i=i;
		this.d=d;
		this.staticStr=str;
		this.normString=norStr;
	}
	
	public String toString(){
		System.out.println();
		return ":" +i +":"+d+":"+staticStr +":"+normString;

	}
}

