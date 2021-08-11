package CoreJava.J_Basic.PackageConcept.pkg1;

/**
 * Rule1: In same package CoreJava.protected methods behave as public methods.
 * 		  protected methods behave as private methods when accessed by differnt package..
 * 
 * Rule2: In differnt package CoreJava.protected methods are accessed by child class ONLY!!!
 * 
 */

public class MainApp {
	public static void main(String[] args) {
		SuperCls superCls = new SuperCls();
		superCls.superPublicMthd();		
		//No issue of calling protected method as it is in same package. - Rule1
		superCls.superProtectedMthd();
	}
}
