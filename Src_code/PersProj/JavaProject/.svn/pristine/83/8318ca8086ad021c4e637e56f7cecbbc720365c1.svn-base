package DessignPattern.Other.Structrual.Proxy.A_Core;

import java.net.MalformedURLException;
import java.net.URL;

import DessignPattern.Other.Structrual.Proxy.A_Core.Proxy.ProxyImage;

/**
 * A Proxy can be defined as a surrogate 
 * 	i.e. it can be used as a replacement for real.  
 * 
 * a cheque or credit card is a proxy for our bank account.
 * Proxy pattern does - controls and manage access to the object they are "protecting".
 * 
 *   
 *  When to use:
 *  The object being represented is external to the system.
 *  Objects need to be created on demand. 
 *  Access control for the original object is required
 *  Added functionality is required when an object is accessed.
 *  when communication with a third party is an expensive operation.
 *   	perhaps over a network. 
 *  	The proxy would allow you to hold your data until you are ready to commit, and can limit the amount of times that the communication is called.
 * @author Manish
 *
 * Client interacts with proxy which inturn calls the real object.
 */
public class Client {

	public static void main(String[] args) throws MalformedURLException {
		URL url;
		ProxyImage ProxyImage = new ProxyImage(new URL("http:\\URL string"));
		ProxyImage.displayImage();

	}

}
