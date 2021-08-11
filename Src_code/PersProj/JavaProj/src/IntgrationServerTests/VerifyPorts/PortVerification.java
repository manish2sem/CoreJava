package IntgrationServerTests.VerifyPorts;

import java.io.IOException;
import java.util.StringTokenizer;

public class PortVerification {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		verifyPorts("rdvmva22:1510,http://rdvmva22:9510d,https://rdvmva22:9510");

	}
		
	 
    public static void verifyPorts(String tsaUrls) throws IOException{
		if (tsaUrls != null) {
			boolean invalidPort = false;
			String badPort = null;
			String errorMsg = null;
			StringTokenizer tokens = new StringTokenizer(tsaUrls, ",");

			while (tokens.hasMoreElements()) {
				String url = tokens.nextToken();
				if (url != null) { 	

					long port;

					int lastIndex = url.lastIndexOf(":");

					if (lastIndex>0){
						String portString = url.substring(lastIndex+1);
						try {
							port = Long.parseLong(portString);

							if (port < 1000 || port > 5000) {
								invalidPort = true;
								badPort =  String.valueOf(port);
								errorMsg = "invalid range for port in URL " +url;
								break;
								
							}
						} catch (NumberFormatException excp){
							invalidPort = true;
							badPort =  portString;
							errorMsg = excp.getMessage();
							break;
						}
					} else {
						invalidPort = true;
						errorMsg = "port is missing in URL " +url;
						break;
						
					} 
				}
			}
			
			if (invalidPort) {
				throw new IOException(errorMsg+  " : "+badPort);
			}
			

		}

	}


	/*public static void verifyPorts(String tsaUrls) {
		if (tsaUrls != null) {
			StringTokenizer tokens = new StringTokenizer(tsaUrls, ",");

			while (tokens.hasMoreElements()) {
				String url = tokens.nextToken();
				if (url != null) { 	

					long port;

					int lastIndex = url.lastIndexOf(":");

					if (lastIndex>0){
					//	try {
							port = Long.parseLong(url.substring(lastIndex+1));

							if (port < 1000 || port > 5000) {
								System.out.println("Throw invalid range for port");
							}
						} catch (NumberFormatException excp){
							System.out.println("Catch no format exception");
						}


					}
				}
			}

		}

		System.out.println("End of verifyPorts");
	}
*/

}
