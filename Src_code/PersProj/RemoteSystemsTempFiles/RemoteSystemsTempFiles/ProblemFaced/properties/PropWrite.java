/**
 * https://www.mkyong.com/java/java-properties-file-examples/
 */
package ProblemFaced.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropWrite {
  public static void main(String[] args) {

	Properties prop = new Properties();
	OutputStream output = null;

	try {

		

		// set the properties value
		prop.setProperty("database", "localhost");
		prop.setProperty("dbuser", "mkyong");
		prop.setProperty("dbpassword", "password");

		// save properties to project root folder
		output = new FileOutputStream("config.properties");
		prop.store(output, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
  }
}