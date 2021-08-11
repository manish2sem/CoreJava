package Interview.Ola.httpClient.src.com.ola.httpclient.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import Interview.Ola.httpClient.src.com.ola.httpclient.model.Request;

public class FileDS implements AbstractDataSource {
	
	String path ;
	public FileDS(String path) {
		this.path = path;
	}

	@Override
	public void saveRequest(Request request) {
		File file = new File(path);
		
		System.out.println("Saving Request to " +file);
		
		try {
			FileInputStream fi = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
