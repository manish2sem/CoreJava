package SAGIssue.NetWork;

import java.net.InetAddress;

public class HostNameResolver {
	
	public static void main(String args[])	{
		
		if(args.length < 1) {
			System.out.println("Provide Host Name as Program Argument");
			System.exit(0);
		}
		
		String hostName = args[0];
		
		System.out.println("HostName :" +hostName);
		InetAddress  localhost = resolveHost(hostName);
		
		System.out.println("HostName Resolved as : " + localhost.getHostName());
		System.out.println("HostAddress Resolved as : " + localhost.getHostAddress());
		System.out.println();
		InetAddress  localhost2 = resolveHost2(hostName);
		System.out.println("HostName Resolved as : " + localhost2.getHostName());
		System.out.println("HostAddress Resolved as : " + localhost2.getHostAddress());

	}
	
	
	public static InetAddress resolveHost(String hostname)
	{
		InetAddress  localhost = null;
		if (hostname == null || hostname.length() == 0)
			return null;
		
		try {			
			localhost = InetAddress.getByName(hostname);
			System.out.println("HostName Intermediate step : " + localhost);
			localhost = InetAddress.getByName(localhost.getHostAddress());
		} catch (Exception e) {
			System.out.println("Exception : " + localhost);
		}
		
		return localhost;
	}
	
	public static InetAddress resolveHost2(String hostname)
	{
		InetAddress  localhost = null;
		if (hostname == null || hostname.length() == 0)
			return null;
		
		try {			
			localhost = InetAddress.getByName(hostname);
			System.out.println("HostName Intermediate step : " + localhost);
			localhost = InetAddress.getByName(localhost.getHostName());
		} catch (Exception e) {
			System.out.println("Exception : " + localhost);
		}
		
		return localhost;
	}

}
