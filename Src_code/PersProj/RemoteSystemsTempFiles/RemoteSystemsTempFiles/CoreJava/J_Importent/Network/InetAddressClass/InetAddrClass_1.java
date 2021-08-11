package CoreJava.J_Importent.Network.InetAddressClass;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 * The java.net.InetAddress class is Java’s high-level representation of an IP address, both IPv4 and IPv6.
 * it includes both a hostname and an IP address.
 * 
 * There are no public constructors in the InetAddress class. 
 * InetAddress has static factory methods that connect to a DNS server to resolve a hostname.
 * 
 * The most common factory method is InetAddress.getByName().
 * It makes a connection to the local DNS server to look up the name and the numeric address (This info is cahched for later use). 
 * If the DNS server can’t find the address, this method throws an UnknownHostException. 
 * 
 * Source : https://www.oreilly.com/library/view/java-network-programming/9781449365936/ch04.html
 * @author MAKUM
 *
 */

public class InetAddrClass_1 {

	public static void main(String[] args) {
	//	getByName();
		reverseLookup();
	}
	
	
	public static void getByName() {
		try {
			InetAddress address = InetAddress.getByName("www.oreilly.com");
			System.out.println(address);
			System.out.println(address.getHostName());
		} catch (UnknownHostException ex) {
			System.out.println("Could not find www.oreilly.com");
		}
		
		//OUTPUT : www.oreilly.com/23.76.66.20
	}
	
	/*
	 * reverse lookup :
	 *  INPUT - IP address. 
	 *  OUTPUT - hostname for the address 
	 *  
	 *  If the address you look up does not have a hostname, getHostName() simply returns the dotted quad address you supplied.
	 */	
	public static void reverseLookup() {
		InetAddress address = null;
		try {
			address = InetAddress.getByName("23.76.66.20");
			System.out.println(address);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(address.getHostName());

	}
	
	

}
