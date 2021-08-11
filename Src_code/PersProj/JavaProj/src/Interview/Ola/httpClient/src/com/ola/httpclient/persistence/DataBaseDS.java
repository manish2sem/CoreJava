package Interview.Ola.httpClient.src.com.ola.httpclient.persistence;

import java.sql.Connection;
import java.util.Map;

import com.ola.httpclient.model.Request;

public class DataBaseDS implements AbstractDataSource {
	
	private Connection connection ;
	
	private static boolean isInitialized = false;

	@Override
	public void saveRequest(Request request) {
		
		//TO DO: Persist the request in the DB.
	}


	
	

}
