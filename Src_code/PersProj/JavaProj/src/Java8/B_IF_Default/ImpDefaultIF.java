package Java8.B_IF_Default;

/**
 * Default methods can be(optional) overridden in implementing class.
 * 		Strictly with public visibility.
 * 
 * 	Exceptional case is - diamond problem(ambigous default function).
 * 		In this case overriding default method is mandatory.
 * 
 * @author MAKUM
 *
 */

public class ImpDefaultIF  implements Interface1{

	@Override
	public void method1(String str) {
		System.out.println("This is not default method");		
	}


	//Overriding default method
	@Override
	public void defaultMethod1(String str){
			System.out.println("ImpDefaultIF logging::"+str);
	}
	
	public static void main(String[] args) {
		ImpDefaultIF myCls = new ImpDefaultIF();
		myCls.defaultMethod("This is default method");
		myCls.defaultMethod1("Over ridden default method");

	}	

}
