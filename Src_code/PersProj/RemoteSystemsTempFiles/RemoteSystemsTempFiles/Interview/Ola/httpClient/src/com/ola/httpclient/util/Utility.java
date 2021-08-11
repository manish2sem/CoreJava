package Interview.Ola.httpClient.src.com.ola.httpclient.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utility {

	public Properties getProp() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			prop.load(input);

			System.out.println(prop.getProperty("dataSource"));
			

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

		}
		return prop;
	}

}
