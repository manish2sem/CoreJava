package CoreJava.J_Basic.PackageConcept.pkg1;

import CoreJava.J_Basic.PackageConcept.pkg2.ChildCls;

/**
 * Surprisingly to access  superProtectedMthd() from ChildCls you need to redefine it in ChildCls.
 * Method superProtectedMthd() can only be accessed by object of ChildCls[chilld class defined in different package.] from class ChildCls.
 * not from object of ChildCls instantiated in some other class [in different pacakage], like this example.
 * @author sinhama
 *
 */
public class Z_AnotherChild {
	private void mani() {
		ChildCls childCls = new ChildCls();
		
		childCls.superPublicMthd();
		// This works fine eventhough child class is in different package CoreJava.because...
		//superProtectedMthd is defined in this package CoreJava.only.
		//Rule1 - In same package CoreJava.protected methods behave as public methods.
		childCls.superProtectedMthd();  
		
	}
}
