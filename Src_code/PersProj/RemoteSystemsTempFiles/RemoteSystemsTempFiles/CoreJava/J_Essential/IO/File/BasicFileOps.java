package CoreJava.J_Essential.IO.File;

import java.io.File;
import java.io.IOException;

/**
 * When you make a new instance of the class File < new File("fileWrite1.txt") >, you're not yet making an actual file, 
 * you're just creating a filename. Once you have a File object, there are several ways to make an actual file.
 * 1.) createNewFile()
 * 2.) FileWriter()
 * 
 *notice that we have to put our file creation code in a try/catch. This is true for almost all of the file I/O code.
 *I/O is one of those inherently risky things.
 */

public class BasicFileOps {
	public static void main(String [] args) {
		try { // warning: exceptions possible
			boolean newFile = false;
			File file = new File("fileWrite1.txt"); // it's only an object
			System.out.println(file.exists()); // look for a real file
			newFile = file.createNewFile(); // This method creates a new file if it doesn't already exist.
			System.out.println(newFile); // already there?
			System.out.println(file.exists()); // look again
		} catch(IOException e) { }
	}

}
