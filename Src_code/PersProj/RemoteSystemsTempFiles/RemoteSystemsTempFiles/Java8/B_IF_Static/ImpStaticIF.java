package Java8.B_IF_Static;

/**
 * 
 * In this example,
 * 	- static methods are accessed through their corresponding interface.
 * 		Interface2.print2(str);
 *  - Static methods of interfaces can't be accessed by inherited implementing class
 *  	myClass.print1(str); will not work
 *
 * @author Manish
 *
 */
public class ImpStaticIF implements Interface1, Interface2{
	
	@Override
	public void method1(String str) {
	}

	@Override
	public void method2() {
	}

	//MyClass won't compile without having it's own log() implementation
	//@Override
	
	public void log(String str){
		System.out.println("MyClass logging::"+str);
		Interface1.staticMethod("abc");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImpStaticIF myClass = new ImpStaticIF();
		myClass.log("Manish");
		
		
		
		
		Interface1 if1 = new ImpStaticIF();
		
		
	//	if1.print("Manish");
		Interface1.staticMethod("Manish");
		
		String str = "From ImpStaticIF";
		Interface2.staticMethod(str);
		Interface2.staticMethod2(str);
		Interface1.staticMethod1(str);
		
	//	myClass.print(str);
	//	myClass.print1(str);

	}

}
