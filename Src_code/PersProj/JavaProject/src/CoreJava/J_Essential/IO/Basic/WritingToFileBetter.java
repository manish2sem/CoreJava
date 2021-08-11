package CoreJava.J_Essential.IO.Basic;

import java.io.*;

public class WritingToFileBetter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		File file = new File("fileWrite4.txt"); // create a File object
		try{
		FileWriter fw;		
		fw = new FileWriter(file); // Low-Level class directly connect with File object.		
		PrintWriter pw = new PrintWriter(fw); // High-Level class connects with Low-Level FileWriter object 
		pw.println("howdy"); // write the data
		pw.println("folks");
		pw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	File readFfile = new File("fileWrite4.txt"); // create a File object AND
	try{
		FileReader fr = new FileReader(readFfile); // create a FileReader to get
		BufferedReader br = new BufferedReader(fr); // create a BufferReader to
		String data = br.readLine();
		System.out.println(data);
		br.close();
	}catch (IOException e) {
		e.printStackTrace();
	}

	}

}
