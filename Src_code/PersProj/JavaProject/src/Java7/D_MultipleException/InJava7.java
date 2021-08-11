package Java7.D_MultipleException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * http://www.java67.com/2013/01/java-7-improved-exception-handling-multiple-catch-block.html
 * After Java 7, more than one catch block can be replaced
 *  with a simple multiple exception catch block

 */
public class InJava7{

	public static void main(String args[]) {
		try {
			File file = new File("test.txt");
			FileInputStream fis = new FileInputStream(file);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(fis));
			String str = bReader.readLine();
			SimpleDateFormat format = new SimpleDateFormat("DD/MM/YY");
			Date date = format.parse(str);

		
		} catch (IOException | ParseException exception) {
			
			//code to handle IOException
		}
		catch (Exception exception) {
			//code to handle IOException
		}
	}
}

/*
 * The important point to note is that variable ex is  final variable here and
 * can not be reassigned. 
 * Another place where you can use this improved Exception handling feature is 
 * to combine two catch blocks which are essentially doing the same job or just a copy paste.
 * By using Java 7 multiple catch block, you can reduce a lot of boilerplate code in Java.

*/
