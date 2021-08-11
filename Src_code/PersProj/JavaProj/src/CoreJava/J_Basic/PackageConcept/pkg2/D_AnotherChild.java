package CoreJava.J_Basic.PackageConcept.pkg2;

/**
 * Surprisingly to access  superProtectedMthd() from ChildCls you need to redefine it in ChildCls.
 * 		as Package of child and parent is different.
 * Method superProtectedMthd() can only be accessed by object of ChildCls[chilld class defined in different package.] from class ChildCls.
 * not from object of ChildCls instantiated in some other class [in different pacakage], like this example.
 * @author sinhama
 *
 */
public class D_AnotherChild {
	private void mani() {
		ChildCls childCls = new ChildCls();
		
		childCls.superPublicMthd();
		//Rule1 - superProtectedMthd() behave as private as it is defined in different package CoreJava.than this.
		//and D_AnotherChild is not child class of SuperCls (where protected method is defined)
		//	childCls.superProtectedMthd();  //Surprisingly to work this you need to redefine superProtectedMthd() in ChildCls.

	}
}
