package Java8.B_IF_Default;

/**
 * Interface can have traditional methods, in addition of default methods.
 *   method2()
 *   
 *  Here default method log(str) leads to diamond problem in class ImpDimondIssue.
 * @author MAKUM
 *
 */

public interface Interface2 {
	
	//Traditional interface method
	void method2();

	default void defaultMethod(String str){
		System.out.println("I2 logging::"+str);
	}
		
}
