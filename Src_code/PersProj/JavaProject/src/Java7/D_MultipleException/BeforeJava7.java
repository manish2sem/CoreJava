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
 *
 * Java program to catch multiple exception before Java 7
 */
public class BeforeJava7{

	public static void main(String args[]) {
		try {
			File file = new File("test.txt");
			FileInputStream fis = new FileInputStream(file);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(fis));
			String str = bReader.readLine();
			SimpleDateFormat format = new SimpleDateFormat("DD/MM/YY");
			Date date = format.parse(str);

		} catch (ParseException exception) {
			//code to handle ParseException
		} catch (IOException exception) {
			//code to handle IOException
		}
	}
}

