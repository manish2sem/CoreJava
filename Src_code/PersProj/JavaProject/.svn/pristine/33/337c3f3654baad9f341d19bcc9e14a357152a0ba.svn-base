package CoreJava.J_Essential.IO.srlzation;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Dsrlzation {
	public static void main(String args[]){
		
		try{
			FileInputStream is = new FileInputStream("xyz.ser");
			ObjectInputStream objos= new ObjectInputStream(is);
			MyClass class1 = (MyClass)objos.readObject();
			System.out.println("After susseccful Deserialization");
			System.out.println(class1);
		}catch(FileNotFoundException e){
			System.out.println("FileNotFound Exception");
		
		}catch(ClassNotFoundException e){
			System.out.println("ClassNotFound Exception");
		
		}catch(IOException e){
			System.out.println("IO Exception");
		
		}

	}
}
