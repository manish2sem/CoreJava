package CoreJava.J_Essential.xceptionHandling.impConcepts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * R1 = A checked exception must be either handled or declared. 
 * 		- Handling an exception involves catching the exception. 
 * 		- Declaring an exception involves a method using the throws keyword in its signature,
 * 			 declaring any checked exceptions that is not going to be handled.
 * 
 * R2 -declaring a method forces it to eventually be handled down the call stack.
 * 
 *  The Handle or Declare Rule does not apply to runtime exceptions. This is only for checked exceptions.
 *  
 *  Even constructor can declare the exceptions which need to be thrown.
 *  	Ex: FileInputStream public FileInputStream(String name) throws FileNotFoundException
 */
public class HandleOrDeclare {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Lazy lazy = new Lazy("File_Name.txt");
		lazy.readOneByteDeclare();
		try {
			lazy.readOneByteThrows();
		} catch (FileNotFoundException e) {  // R2. Has to be handled all declared exceptions. 
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			throw new Exception(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			throw new Exception(e);
		}
	}
}

class Lazy {
	private String fileName;
	public Lazy(String name){
		fileName = name;
	}
	public byte readOneByteDeclare() throws Exception  {
		FileInputStream file = null;
		byte x = -1;
		System.out.println("Opening file for reading...");
		try {
		file = new FileInputStream(fileName);
		System.out.println("Just opened file: " + fileName);
		System.out.println("Reading one byte from file...");		
			x = (byte) file.read();
		}catch (FileNotFoundException e) { // Handled, This can be omitted as IOException being parent would take care
			// TODO Auto-generated catch block
			System.out.println("Exception occured  " + fileName);
			throw new Exception(e);
		//	e.printStackTrace();
		//	throw new Exception();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			throw new Exception(e);
			//e.printStackTrace();
		}
		System.out.println("Just read " + x);
		return x;
	}
	
	public byte readOneByteThrows() throws FileNotFoundException, IOException  { //Declared. Note since FileNotFoundException is child of IOException it should come first
		FileInputStream file = null;
		byte x = -1;
		System.out.println("Opening file for reading...");
		file = new FileInputStream(fileName);
		System.out.println("Just opened file: " + fileName);
		System.out.println("Reading one byte from file...");		
			x = (byte) file.read();
		System.out.println("Just read " + x);
		return x;
	}
	
}

/**
 * So, how do we know that some method throws an exception that we have to catch? 
 * 	Just as a method must specify what type and how many arguments it accepts and what is returned, 
 * 	the exceptions that a method can throw must be declared (except RuntimeException and its subclass). 
 * 	The throws keyword is used as follows to list the exceptions that a method can throw: 
 * 
 * or how does compiler know that some methods need to be handled for particular type of exceptions? 
 * 	because those methods declare particular exceptions at there signature.
 * 	Ex: public native int read() throws IOException;
 * 
 * 
 * You can also throw an exception yourself, and that exception can be either 
 * 	- an existing exception from the Java API or 
 * 	- one of your own. 
 * 
 * Very Imp:
 * If you throw a checked exception from a catch clause, you must also declare that exception! 
 * In other words, you must handle and declare, as opposed to handle or declare.
 */
