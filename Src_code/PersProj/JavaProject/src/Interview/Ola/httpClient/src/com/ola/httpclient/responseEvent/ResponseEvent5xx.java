package Interview.Ola.httpClient.src.com.ola.httpclient.responseEvent;

public class ResponseEvent5xx implements AbstractResponseEvent {

	@Override
	public int getNumberOfRetries() {
		return 5;
	}

}
