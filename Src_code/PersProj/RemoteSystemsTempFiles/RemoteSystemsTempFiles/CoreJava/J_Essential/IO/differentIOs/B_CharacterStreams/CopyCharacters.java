package CoreJava.J_Essential.IO.differentIOs.B_CharacterStreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CopyCharacters {
	public static void main(String[] args) throws IOException {

		FileReader inputStream = null;
		FileWriter outputStream = null;

		try {
			inputStream = new FileReader("xanadu.txt");
			outputStream = new FileWriter("characteroutput.txt");

			int c;
			while ((c = inputStream.read()) != -1) {
            	System.out.println("C is : " +c);
				outputStream.write(c);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}


