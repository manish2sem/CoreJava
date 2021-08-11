package DessignPattern.Other.Structrual.Adapter.A_Core.Solution2;

import DessignPattern.Other.Structrual.Adapter.A_Core.ExternalObj.VendorCircle;
import DessignPattern.Other.Structrual.Adapter.A_Core.IF.Shape;

/**
 * This is an example of object Adapter.
 * 
 * This is useful when more than one class need to be adapted. in such cases class adapter fails
 *  because of the limitation of java multi-inheritence.
 * 
 * Limitation:
 * It can't override the methods of adaptee(VendorCircle) class.
 *
 */

public class SolutionCircle2 implements Shape {
	
	VendorCircle vendorCircle;
	SolutionCircle2(){
		super();
		vendorCircle = new VendorCircle();
	}
	
	public void fill(){
		vendorCircle.vendorFill();
	}
	
	public void display(){
		vendorCircle.vendorDisplay();
	}
	public void unDisplay(){
		vendorCircle.vendorUnDisplay();
	}

}
