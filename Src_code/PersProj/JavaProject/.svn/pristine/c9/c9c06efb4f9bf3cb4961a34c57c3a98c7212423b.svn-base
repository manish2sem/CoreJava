package Interview.Ola.httpClient.src.com.ola.httpclient.persistence;

import java.util.Map;

import com.ola.httpclient.model.Request;

public class  DataSourceStrategy {
	
	private AbstractDataSource persistenceObj;
	
	public DataSourceStrategy(AbstractDataSource persistenceObj){
		this.persistenceObj = persistenceObj; 
	}
	
	public void saveRequest(Request request){
		persistenceObj.saveRequest(request);
	}
	
	
	
}
