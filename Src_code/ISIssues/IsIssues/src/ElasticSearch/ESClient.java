package ElasticSearch;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Get;


public class ESClient {
	public static JestClient jestClient = null;
	public static final String ES_HOST = "localhost";
	public static final String ES_PORT = "9200";

	
	public static void init(){
		
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new  HttpClientConfig.Builder("http://" + ES_HOST +":" +ES_PORT ).multiThreaded(true).build());
		jestClient = factory.getObject();
		
	}
	
	public static JestClient getEsClient(){
		
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new  HttpClientConfig.Builder("http://" + ES_HOST +":" +ES_PORT ).multiThreaded(true).build());
		return jestClient; 
		
	}
	
	

	public static void main(String[] args) throws Exception {
		Get get = new Get.Builder("twitter", "1").type("tweet").build();
		JestResult  results = getEsClient().execute(get);
		// TODO Auto-generated method stub

	}

}
