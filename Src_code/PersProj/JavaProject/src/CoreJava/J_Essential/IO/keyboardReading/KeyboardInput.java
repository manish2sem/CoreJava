package CoreJava.J_Essential.IO.keyboardReading;

/**
 * 
 * Streams. The stream classes are for performing I/O on bytes of data.
 * 
 * InputStream - The abstract class is the parent class of all the input streams
 * 
 * InputStreamReader - converts bytes to characters.
 * 		High level reader writer
 *  	constructor - InputStreamReader(InputStream) 
 *  
 *  System.in - refers to the standard input ie KeyBoard by default.
 *  	System is a class defined in java.lang Package.
 *  		public final static InputStream in = nullInputStream(); defined in System
 *  	So System.in is an object of type InputStream.
 *  	  
 *  keyboard input is typically characters. Therefore, to read in characters from the command
 *  prompt, you need to convert the System.in stream from a byte stream to a reader 
 *  using the InputStreamReader class.
 *  	
 *  BufferedInputReader : This is used for buffering input. High Level Reader
 *  Constructor - BufferedReader(Reader in); 
 *  	 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

	public class KeyboardInput {
	
		public static void main(String [] args)	{
			try	{
				System.out.print("Enter your name: ");
				InputStreamReader reader =	new InputStreamReader(System.in);
				BufferedReader in =	new BufferedReader(reader);
				String name = in.readLine();
				System.out.println("Hello, " + name + ". Enter three ints...");
				int [] values = new int[3];
				double sum = 0.0;
				for(int i = 0; i < values.length; i++){
					System.out.print("Number " + (i+1)	+ ": " );
					String temp = in.readLine();
					values[i] = Integer.parseInt(temp);
					sum += values[i];
				}
				System.out.println("The average equals " + sum/values.length);
			}catch(IOException e){
	
				e.printStackTrace();
			}
		}

	}
