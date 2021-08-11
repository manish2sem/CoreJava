package CoreJava.J_Essential.xceptionHandling.impConcepts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The throw keyword is used for throwing an exception, and 
 * it can be used anywhere you want to throw an exception. 
 * 		- You can throw only objects of type java.lang.Throwable. 
 * 		- In almost all situations, you will throw an object that is a child of java.lang.Exception.
 * 
 * You can throw an exception yourself by using the throw keyword, and that exception can be either 
 * 	- an existing exception from the Java API or 
 * 	- one of your own. 
 * 
 * A throw statement causes the current method to immediately stop executing, much like a return statement, 
 * and the exception is thrown to the previous method on the call stack.
 * 
 * If you throw a checked exception from a catch clause, 
 * 		you must also declare that exception! (That force it to handle somewhere down the call trace)
 * In other words, you must handle and declare, as opposed to handle or declare.
 * 
 *
 */

public class ExceptionThrow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length == 0) {
			throw new ArrayIndexOutOfBoundsException(5);
		}
		try	{
			method1(args[0]);
		}catch(IOException e){
			System.out.println("Sorry, but an exception occurred. in main");
			return;
		}
		System.out.println("End of main");
	}
	
	public static void method1(String fileName) throws IOException {
		System.out.println("Inside method1");
		try {
			method2(fileName);
		}catch(IOException e){
			System.out.println("Something went wrong! in method1");
			e.printStackTrace();
			throw e;
		}
		System.out.println("Leaving method1");
	}
	
	public static void method2(String fileName) throws IOException {
		System.out.println("Inside method2");
		NotSoLazy util = new NotSoLazy(fileName);
		System.out.println(util.readOneByte());
		System.out.println("Leaving method2");
	}
	
}


class NotSoLazy {
	private String fileName;
	public NotSoLazy(String name) {
		fileName = name;
	}
	public byte readOneByte() throws FileNotFoundException, IOException {
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
//Remainder of class definition
}