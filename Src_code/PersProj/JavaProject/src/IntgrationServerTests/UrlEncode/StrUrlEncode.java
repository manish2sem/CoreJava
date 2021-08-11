package IntgrationServerTests.UrlEncode;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StrUrlEncode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String q = "random word £500 bank %00";
		String url = URLEncoder.encode(q, "UTF-8");
		
		System.out.println(q +" is encoded as : "+url);
	}

}
