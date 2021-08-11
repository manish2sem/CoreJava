package Interview.Ola.httpClient.src.com.ola.httpclient.persistence;

import java.util.Map;

import com.ola.httpclient.model.Request;

public interface AbstractDataSource {

	public void saveRequest(Request request);
	
}
