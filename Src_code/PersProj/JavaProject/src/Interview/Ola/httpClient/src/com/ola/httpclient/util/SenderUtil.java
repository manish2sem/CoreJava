package Interview.Ola.httpClient.src.com.ola.httpclient.util;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.ola.httpclient.model.Request;
import com.ola.httpclient.persistence.DataSourceStrategy;
import com.ola.httpclient.persistence.FileDS;
import com.ola.httpclient.responseEvent.AbstractResponseEvent;
import com.ola.httpclient.responseEvent.ResponseEventFactory;

public class SenderUtil {

	private Map<String, String> header;
	private String body;
	private String url;

	public SenderUtil(Map<String, String> header, String body, String url) {
		this.header = header;
		this.body = body;
		this.url = url;
	}

	private int sendPost() throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// construct the request header
		con.setRequestMethod("POST");
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(body);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		return responseCode;

	}

	private void sendRetry(int responseCode) {

		System.out.println("Retrying Posting....");

		AbstractResponseEvent event = ResponseEventFactory.getInstance()
				.getResponseEvent(responseCode);

		int noOfRetryAttempts = event.getNumberOfRetries();
		int i = 0;
		persistData();
		
		while (i < noOfRetryAttempts) {
			try {
				int code = sendPost();
				if (code == 200)
					break;
			} catch (Exception e) {

				System.err.println("Error while sending Request..");

			}
			i++;
		}
		
	}

	private void persistData() {
		
		DataSourceStrategy dataSource = new DataSourceStrategy(new FileDS("C:/persist/out.txt"));
		Request request = buildRequestObject();
		dataSource.saveRequest(request);

	}

	private Request buildRequestObject() {

		Request req = new Request();
		req.setBody(body);
		req.setUrl(url);
		req.setHeaderParams(header);
		
		return req;
	}
	
	public void send(Map<String, String> headers, String url, String body,
			int expectedResponseCode) {
		
		if (null == body) {
			throw new RuntimeException("Empty Body");
		}
		if (null == url) {
			throw new RuntimeException("Invalid URL");
		}

		int responseCode = 0;
		try {
			responseCode = sendPost();
		} catch (Exception e) {

			System.err.println("Error while sending Request..");

			sendRetry(responseCode);

		}

		System.out.println("Done");
	
	}

}
