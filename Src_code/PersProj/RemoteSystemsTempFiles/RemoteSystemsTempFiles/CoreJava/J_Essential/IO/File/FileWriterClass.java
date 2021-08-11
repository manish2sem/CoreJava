package CoreJava.J_Essential.IO.File;

/**
 * Second way of creating file.
 * 
 * Whenever you're done using a file, either reading it or writing to it, 
 * you should invoke the close() method.
 * 
 * BURN IN YOUR MIND :
 *  Every IO operation takes one LOW-level and zero and more High-level classes.
 */

import java.io.*;

public class FileWriterClass {
	public static void main(String [] args) {
		try {
			File file = new File("fileWrite2.txt");
			FileWriter fw = new FileWriter(file); // create an actual file because of Low-level FileWriter object.221
			System.out.println(file.exists());
			fw.close();
		} catch(IOException e) { }
	} 
}

/**
 * FileWriter fw = new FileWriter(file) did three things:
 * a. It created a FileWriter reference variable, fw. 
 * b. It created a FileWriter object, and assigned it to fw. 
 * c. It created an actual empty file out on the disk (and you can prove it).
 * 
 * When you are doing file I/O you're using expensive and limited operating system resources, and
 * so when you're done, invoking close() will free up those resources.
 */
