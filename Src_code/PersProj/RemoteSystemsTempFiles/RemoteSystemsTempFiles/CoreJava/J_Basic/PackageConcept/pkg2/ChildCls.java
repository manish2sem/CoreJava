package CoreJava.J_Basic.PackageConcept.pkg2;

import CoreJava.J_Basic.PackageConcept.pkg1.SuperCls;

/**
 * Object of child class can call the protected method.
 * 
 *  Object of Parent class can not call the protected method.
 * 
 * 
 * 
 * @author sinhama
 *
 */

public class ChildCls extends SuperCls{
	public static void main(String[] args) {
		ChildCls childCls = new ChildCls();
		SuperCls superCls = new SuperCls();
		
		childCls.superPublicMthd();
		//Rule2 - superProtectedMthd() can only be accessed by child class in different package.
		childCls.superProtectedMthd();
		
		superCls.superPublicMthd();
		
		SuperCls.superStaticPublicMthd();
		
		//Rule1 - superProtectedMthd() behave as private as it is defined in different package CoreJava.than this.
	//	superCls.superProtectedMthd();  // Not Possible
		
	}
}
