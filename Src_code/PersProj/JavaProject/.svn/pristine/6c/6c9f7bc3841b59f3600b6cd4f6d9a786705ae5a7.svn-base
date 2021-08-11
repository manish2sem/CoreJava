package DessignPattern.Other.Structrual.Adapter.A_Core.Solution1;

import DessignPattern.Other.Structrual.Adapter.A_Core.ExternalObj.VendorCircle;
import DessignPattern.Other.Structrual.Adapter.A_Core.IF.Shape;

/**
 * This class is adapting vendorCircle to shape system.
 * For this it is implementing common interface Shape
 * Then overriding methods of shape by using vendorCircle class methods. 
 * To use vendorCircle methods it need to extend vendorCircle class.
 * 
 * Now vendorCircle is adapted to the shape.
 * 
 * This is an example of class adapter
 *
 */

public class SolutionCircle extends VendorCircle implements Shape{
	
	public void fill(){
		super.vendorFill();
	}
	
	public void display(){
		super.vendorDisplay();
	}
	public void unDisplay(){
		super.vendorUnDisplay();
	}

}
