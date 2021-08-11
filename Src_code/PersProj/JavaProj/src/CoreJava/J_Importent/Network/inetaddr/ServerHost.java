package CoreJava.J_Importent.Network.inetaddr;

import java.net.InetAddress;

public class ServerHost {

	public static void main(String[] args) {
		//setLocalHost("lwukwvdi22.opd.ads.uk.rsa-ins.com");
		setLocalHost("mcmakum01");
	}
	
	public static void setLocalHost(String hostname)
	{
		InetAddress localhost = null;

		if (hostname == null || hostname.length() == 0)
			return;
		try {
			localhost = InetAddress.getByName(hostname);
			localhost = InetAddress.getByName(localhost.getHostAddress());
		} catch (Exception e) {
			System.out.println("Exception : " + e.toString());			
		}		
		System.out.println("localhost : " + localhost);
	}

}
