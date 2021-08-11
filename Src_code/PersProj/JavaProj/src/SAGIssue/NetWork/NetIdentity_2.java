package SAGIssue.NetWork;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Pattern;

public class NetIdentity_2 {
	
	private String loopbackHost = "";
	private String host = "";

	private String loopbackIp = "";
	private String ip = "";
	

	private static final Pattern IPv4RegexPattern = Pattern.compile(
	     //   "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
		//	"^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$)";
			"^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");

	
	public static void main(String[] args) { 
		getIpAddress();
	}
	
	public static void getIpAddress() {

	    String ipAddress = null;

	    try {
	        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

	        while (networkInterfaces.hasMoreElements()) {

	            NetworkInterface networkInterface = networkInterfaces.nextElement();

	            byte[] hardwareAddress = networkInterface.getHardwareAddress();
	            if (null == hardwareAddress || 0 == hardwareAddress.length || (0 == hardwareAddress[0] && 0 == hardwareAddress[1] && 0 == hardwareAddress[2])) continue;

	            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

	            if (inetAddresses.hasMoreElements()) {
	            	
	            	InetAddress ipadd = inetAddresses.nextElement();
	            	ipAddress = ipadd.toString();
	            	
	            	String hostAdd = ipadd.getHostAddress();
	            	String hostName = ipadd.getHostName();
	            	String CanHostName = ipadd.getCanonicalHostName();
	            	
	            	System.out.println("hostAdd " + hostAdd);
	            	System.out.println("hostName " + hostName);
	            	System.out.println("CanHostName " + CanHostName);
	            	//ipAddress = inetAddresses.nextElement().toString();
	            //	System.out.println("ipAddress : " + ipAddress);
	            }
	            
	            boolean flag = validate(ipAddress.substring(1));
	            
	            if (flag) {
	            	System.out.println("ipAddress : " + ipAddress);
	             }

	          //  break;
	        }
	    } catch (SocketException e) {
	        e.printStackTrace();
	    }

	   // return ipAddress;
	}
	
	


	public static boolean validate(final String ip) {
	    return IPv4RegexPattern.matcher(ip).matches();
	}

}
