package Interview.Ola.httpClient.src.com.ola.httpclient.service;

import java.util.HashMap;
import java.util.Map;

import com.ola.httpclient.event.AppEvents;
import com.ola.httpclient.util.SenderUtil;

public class TestClient {

	public static void main(String[] args) {
		
		Map<String, String> headers = new HashMap<String, String>();
		String url = "http://localhost:8080/somecontext";
		String body = new AppEvents().cabBooked();
		SenderUtil sender = new SenderUtil(headers, body, url);
		int expectedResponseCode = 200;
		System.out.println("Sending request ...");
		
		sender.send(headers, url, body, expectedResponseCode);
	}

}
