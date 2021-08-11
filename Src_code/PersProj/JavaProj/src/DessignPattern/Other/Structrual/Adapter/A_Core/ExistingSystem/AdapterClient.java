package DessignPattern.Other.Structrual.Adapter.A_Core.ExistingSystem;

import DessignPattern.Other.Structrual.Adapter.A_Core.IF.Shape;

/**
 * In following existing system Shape - Point, Line and Square 
 * 		Where each class of this system implements Shape IF.
 * 
 * we need to add a third party class vendorCircle to this existing system.
 * Problem is VendorCircle can not be used directly because 
 * method name and parameter of methods are different at already existing vendorCircle class. 
 * Some of the methods can not be overridden.
 * 
 * Solution is adapter Pattern. 
 * See SolutionCircle.java.
 *
 */

public class AdapterClient {
	public static void main(String [] args) {
		Shape[] shapes = new Shape[3];
		shapes[0] = new Point();
		shapes[1] = new Line();
		shapes[2] = new Square();
		
		
		for (Shape shape : shapes){
			shape.fill();
			shape.display();
			shape.unDisplay();
		}
		
		
	
	}
	
	

}








