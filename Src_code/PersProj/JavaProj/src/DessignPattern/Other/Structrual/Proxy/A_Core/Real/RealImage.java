package DessignPattern.Other.Structrual.Proxy.A_Core.Real;

import java.net.URL;

import DessignPattern.Other.Structrual.Proxy.A_Core.IF.Image;

/**
 * RealImage implementation does the actual work.
 *
 */
public class RealImage implements Image{   
	public RealImage(URL url)   {      
		//load up the image     
		loadImage(url);   
	}  

	public void displayImage()   {      
		//display the image  
		System.out.println("Displaying the image");	

	}   

	//a method that only the real image has  
	private void loadImage(URL url)  {      
		System.out.println("Loading the image");	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}