package DessignPattern.Other.Structrual.Proxy.A_Core.Proxy;

import java.net.URL;

import DessignPattern.Other.Structrual.Proxy.A_Core.IF.Image;
import DessignPattern.Other.Structrual.Proxy.A_Core.Real.RealImage;


/**
 * the Proxy implementation provides access to the real object (RealImage class). 
 * @author Manish
 *
 */
public class ProxyImage implements Image{   
	private URL url;     

	public ProxyImage(URL url)    {       
		this.url = url;    
	}    

	//this method delegates to the real image   
	public void displayImage()   {        
		RealImage real = new RealImage(url);        
		real.displayImage();    
	}
}
