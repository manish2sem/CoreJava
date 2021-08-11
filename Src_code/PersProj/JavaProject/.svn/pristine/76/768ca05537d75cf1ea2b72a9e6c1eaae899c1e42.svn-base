package Java7.E_AutoResrcMngmnt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeforeJdk7 {
	public static void main(String args[]) {
		FileInputStream fin = null;
		BufferedReader br = null;
		try {
			fin = new FileInputStream("info.xml");
			br = new BufferedReader(new InputStreamReader(fin));
			if (br.ready()) {
				String line1 = br.readLine();
				System.out.println(line1);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Info.xml is not found");
		} catch (IOException ex) {
			System.out.println("Can't read the file");
		} finally {
			try {
				if (fin != null) fin.close();
				if (br != null) br.close();
			} catch (IOException ie) {
				System.out.println("Failed to close files");
			}
		}
	}


}
