package CoreJava.J_Essential.IO.Basic;

import java.io.*;

/**
 * 
 * Almost all of the classes in the java.io package CoreJava fit into one of the following two categories: 
 * 		- Streams. The stream classes are for performing I/O on bytes of data. 
 * 					They are child classes of OutputStream and InputStream.
 * 		- Readers and Writers. The reader and writer classes are for performing I/O on characters. 
 * 					They are child classes of Reader and Writer.  
 * These four classes are abstract and represent the common functionality among their child classes.
 *
 * Low-Level and High-Level Streams :
 * 		- Low-level streams : An IO stream that connects directly to a data source, such as a file or socket. 
 * 			The low-level streams take in actual data sources in their constructors.
 * 			FileOutputStream and each of its constructors takes in a variation of a filename.
 * 			EX : FileInputStream and FileOutputStream
 * 				ByteArrayInputStream and ByteArrayOutputStream.
 * 				PipedInputStream and PipedOutputStream
 * 		- High-level streams. An IO stream that reads or writes to another input or output stream.
 * 			The high-level streams take in other streams.
 * 			DataOutputStream and it only has one constructor, which takes in an existing output stream:
 * 			public DataOutputStream(OutputStream out)
 * 			EX : BufferedInputStream and BufferedOutputStream.
 * 				ObjectInputStream and ObjectOutputStream
 * 				CheckedInputStream and CheckedOutputStream.
 * 				ZipInputStream and ZipOutputStream 		
 * 				JarInputStream and JarOutputStream
 * 
 * Low-Level and High-Level Readers and Writers : CONCEPT IS THAT OF similar to streams.
 * 		- Low-Level Readers/Writers : The low-level readers and writers connect directly to a data source, similarly to memory or a file.
 *  		EX :-	CharArrayReader and CharArrayWriter. For reading from and writing to arrays of characters.
 *  				FileReader and FileWriter. For reading from and writing to files containing character data.
 *  				PipedReader and PipedWriter. For creating character streams between two threads. 
 *  				StringReader and StringWriter. For reading from and writing to String objects.
 * 		- High-Level Readers/Writers : the high-level readers and writers connect to existing readers and writers. 
 * 				BufferedReader and BufferedWriter. For buffering the characters in the character stream. 
 * 				InputStreamReader and OutputStreamWriter. For converting between byte streams and character streams. 
 * 				PrintWriter. For printing text to either an output stream or a Writer. System.out is a PrintWriter object. 
 * 				PushbackReader. For readers that allow characters to be read and then pushed back into the stream.
 * 
 * Design Pattern used = Decorator
 * 
 * BURN IN YOUR MIND :
 *  Every IO operation takes one LOW-level and zero and more High-level classes.
 *  Low-level class connects to the file. so its constructor take a file type object.
 *  High-level classes connects to the other low-level class or other High level classes
 *  
 */
public class IOConcept {
	public static void main(String [] args)	{
		try {
			File file = new File("dataIOConcept.txt");
			FileOutputStream fileOut =	new FileOutputStream(file);  //Low level take file in constructor 
			BufferedOutputStream buffer = new BufferedOutputStream(fileOut); // High level takes low level object fileOut.
			DataOutputStream dataOut = 	new DataOutputStream(buffer); // High level takes high level object buffer. 
		// They all are chained together. so whatever operation we do on dataOut it directly affect to the file object. 
			dataOut.writeUTF("Hello!");
			dataOut.writeInt(4);
			dataOut.writeDouble(100.0);
			dataOut.writeDouble(72.0);
			dataOut.writeDouble(89.0);
			dataOut.writeDouble(91.0);
			dataOut.close();
			buffer.close();
			fileOut.close();
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	//FileOutputStream fileOut =	new FileOutputStream(file);  //Low level take file in constructor 
	//BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(new File("dataIOConcept.txt"))); // High level takes low level object fileOut.
//	DataOutputStream dataOut = 	new DataOutputStream( new BufferedOutputStream(new FileOutputStream(new File("dataIOConcept.txt"))));
}


