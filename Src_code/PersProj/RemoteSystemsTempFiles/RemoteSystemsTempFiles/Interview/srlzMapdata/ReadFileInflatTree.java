package Interview.srlzMapdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.TreeMap;



/**
 *  A Java program to read a text file and print each of the unique words in alphabetical order together with the number of times the word occurs in the text. 
 *  Serialize the data structure and then deserialize it. 
 *  Make the code generis so can use it
 *  log every time text is inserted into tree.
 *  do the unit testing for imp methods
 *  
 *  Coverage - File I/O, Collection, Serialization, Generics, Junit, Log4J.
 * @author sinhama
 *
 */

public class ReadFileInflatTree {

	public static void main(String args[]) throws IOException, ClassNotFoundException {

		Map<String, Integer>  myMap = new TreeMap<String, Integer>();
		
		ReadFileInflatTree fileToMap = new ReadFileInflatTree();
		String path = ReadFileInflatTree.class.getName();
		String srcPath = "src/" + path.replaceAll("\\.", "/") + ".java";
		System.out.println("srcPath -> " +srcPath);
		//String srcPath= "src/Z_Exercise/srlzMapdata/ReadFileInflatTree.java";
		fileToMap.populateMap(myMap,srcPath);
	//	fileToMap.readMap(myMap);

		String srlzdPath= "src/Z_Exercise/srlzMapdata/srlzdTreeMap.ser";
		//String srlzdPath= "srlzdTreeMap.ser";
		fileToMap.serzMap(myMap, srlzdPath);
		Map<String, Integer>  newMap  = fileToMap.deserzMap(srlzdPath);
		fileToMap.readMap(newMap);

	}


	private void populateMap(Map<String, Integer>  myMap, String path) throws IOException{

		System.out.println("Reading File and populating Map");
		//File javaFile = new File("src/Z_Exercise/srlzMapdata/ReadFileInflatTree.java");
		
		File javaFile = new File(path);

		//	File javaFile = new File("xyz.ser");
		if(javaFile.exists()) {
			System.out.println("File exist");
			FileReader fileReader = new FileReader(javaFile); 
			//			DataInputStream in = new DataInputStream(fis);
			//           BufferedReader br = new BufferedReader(new InputStreamReader(fileReader));
			BufferedReader br = new BufferedReader(fileReader);
			String line;
			int countValue = 1;

			while ((br.readLine() != null)) {
				//  while (!br.readLine().isEmpty()) {
				line = br.readLine();
				String regex = "[*;,/.{}=-]";
				//	String regex = "[*]";
				String ParsedLine="";
				if (line!=null) {
				ParsedLine = line.replaceAll(regex, "");
				}
				String words[] = ParsedLine.trim().split(" ");
				for(String word : words){
					if (myMap.containsKey(word)){
						int count = myMap.get(word);
						myMap.put(word, ++count);

					}else {
						myMap.put(word, 1);
					}
				}
				//	System.out.println(ParsedLine);
			}
			br.close();
			fileReader.close();
		}
		else {
			System.out.println("File does not exist");
		}
		System.out.println();

		

	}
	
	private void readMap(Map<String, Integer>  myMap) {
		System.out.println("Reading inside read-map ->");
		for (String key : myMap.keySet()) {
			System.out.println(key + " --> " + myMap.get(key) );
		}
		System.out.println();
	}
	
	private void serzMap(Map<String, Integer>  myMap, String path) throws IOException 
	{
		System.out.println("serializing Tree");
		FileOutputStream fs = new FileOutputStream(path);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		os.writeObject(myMap);
		os.close();
		fs.close();
		System.out.println("After susseccful serialization");
		System.out.println();
	}
	
	private Map<String, Integer> deserzMap(String path) throws IOException, ClassNotFoundException 
	{
		
		System.out.println("Deserializing Tree");
		FileInputStream is = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(is);
		TreeMap<String, Integer>  newMap =  (TreeMap<String, Integer>)ois.readObject();
		ois.close();
		is.close();
		System.out.println("After susseccful serialization");
		System.out.println();
		return newMap;
	}


}

/**
 * An InputStreamReader is a bridge from byte streams to character streams: 
 * It reads bytes and decodes them into characters using a specified java.nio.charset.Charset.
 * Each invocation of one of an InputStreamReader's read() methods may  cause one or more bytes to be read from the underlying byte-input stream.
 * To enable the efficient conversion of bytes to characters, more bytes may be read ahead from the underlying stream than are necessary to satisfy the
 * current read operation.
 *
 * For top efficiency, consider wrapping an InputStreamReader within a  BufferedReader.  
 * For example:
 *  	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 *  
 *  Without buffering, each  * invocation of read() or readLine() could cause bytes to be read from the file, 
 *  converted into characters, and then returned, which can be very inefficient. 
 *
 * Programs that use DataInputStreams for textual input can be localized by replacing each DataInputStream with an appropriate BufferedReader.
 */
