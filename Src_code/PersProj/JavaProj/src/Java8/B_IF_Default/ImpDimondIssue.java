package Java8.B_IF_Default;

/**
 * In case of conflict (ambiguity, Diamond problem) 
 * implementing class must provide it's own implementation of ambigous method.
 * 
 * In this example,
 * public void log(String str) is ambigous
 * as it is present (implemented) in both implemented interfaces.
 * @author Manish
 *
 */
public class ImpDimondIssue implements Interface1, Interface2{
	
	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	//MyClass won't compile without having it's own log() implementation
	//@Override
	
	public void defaultMethod(String str){
		System.out.println("ImpDimondIssue logging::"+str);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImpDimondIssue myClass = new ImpDimondIssue();
		myClass.defaultMethod("Manish");

	}
	
}
