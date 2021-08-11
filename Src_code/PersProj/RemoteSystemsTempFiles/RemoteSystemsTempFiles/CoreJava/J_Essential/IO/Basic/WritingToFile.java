package CoreJava.J_Essential.IO.Basic;

import java.io.*;

/**
 * When you write data out to a stream, some amount of buffering will occur, and 
 * you never know for sure exactly when the last of the data will actually be sent. 
 * You might perform many write operations on a stream before closing it, and 
 * invoking the flush() method guarantees that the last of the data you thought you had already written
 * actually gets out to the file
 * 
 * BURN IN YOUR MIND :
 *  Every IO operation takes one LOW-level and zero and more High-level classes.

*/

public class WritingToFile {
	public static void main(String [] args) {
		char[] in = new char[50]; // to store input
		int size = 0;
		try {
			File file = new File("fileWrite3.txt");
			FileWriter fw = new FileWriter(file); // create an actual file & a FileWriter obj which is low-level
			fw.write("howdy\nfolks\n"); // write characters to the file
			fw.flush(); // flush before closing
			fw.close();
			FileReader fr = new FileReader(file); // create a FileReader  object
			size = fr.read(in); // read the whole file!
			System.out.println(size + " "); // how many bytes read
			System.out.println("Reading the file ... ");
			for(char c : in) // print the array
				System.out.print(c);
			fr.close(); // again, always close
		} catch(IOException e) { }
	}
			
}

/**
 * In this program no high-level classes are used.
 * We directly use Low-level class FileWriter which directly connects to the file and perform operations.
*/

/**
 * Problem of using just one low-level class: * 
 * When we were reading data back in, we put it into a character array. 
 * It being an array and all, we had to declare its size beforehand, 
 * so we'd have been in trouble if we hadn't made it big enough!
 * For ex : - Try this <char[] in = new char[5];>
 * 
 * We could have read the data in one character at a time, looking for the end of file after each read(), 
 * but that's pretty painful too.
 * 
 * Solution :
 * we'll typically want to use higher-level I/O classes like BufferedWriter or 
 * BufferedReader in combination with Low-Level FileWriter or FileReader.
 */
