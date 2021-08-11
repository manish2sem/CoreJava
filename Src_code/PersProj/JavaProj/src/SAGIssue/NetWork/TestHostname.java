
import java.net.InetAddress;
import java.io.*;
import java.net.UnknownHostException;

public class TestHostname
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//
		try
		{
			String val = "localhost";

			if(args.length > 0)
			{
				val = args[0];
			}

		//	InetAddress address = InetAddress.getByName(val);
			System.out.println("==========================================");

			InetAddress localhost1 = InetAddress.getLocalHost();
			System.out.println(">> getLocalHgetHostNameost : " + val);
			System.out.println("1. toString : " + localhost1.toString());
			System.out.println("1. getHostAddress : " + localhost1.getHostAddress());
			System.out.println("1. getHostName : " + localhost1.getHostName());
			System.out.println("==========================================");

			InetAddress localhost2 = InetAddress.getByName(localhost1.getHostAddress());
			System.out.println(">> getByName : " + localhost1.getHostAddress());
			System.out.println("2. toString : " + localhost2.toString());
			System.out.println("2. getHostAddress : " + localhost2.getHostAddress());
			System.out.println("2. getHostName : " + localhost2.getHostName());
			System.out.println("==========================================");

			InetAddress localhost3 = InetAddress.getByName(localhost1.());
			System.out.println(">> getByName : " + localhost1.getHostName());
			System.out.println("3. toString : " + localhost3.toString());
			System.out.println("3. getHostAddress : " + localhost3.getHostAddress());
			System.out.println("3. getHostName : " + localhost3.getHostName());
			System.out.println("==========================================");

		}
		catch (UnknownHostException e)
		{
			System.out.println(e);
		}
	}

}