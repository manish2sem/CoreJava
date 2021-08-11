package CoreJava.J_Importent.ClassLoder.A_Basics;

/**
 * B b = new B() 
 * 		is semantically equivalent to 
 * B b = B.class.getClassLoader().loadClass(“B”).newInstance()
 * 
 * Again 
 *  Every object in Java is associated with its class (A.class) and 
 *  Every class is associated with classloader (A.class.getClassLoader()) that was used to load the class.
 *
 */

public class B_ClassLoadMean {

	public static void main(String args[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException{ 	
		/*B b = new B();
		System.out.println("Loading with instantiation - ");
		b.doSomething();
		System.out.println("With ClassLoader - ");*/
		
		classLoadEquivalent();
	}
	
	static void classLoadEquivalent() throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		 B b = (B)B_ClassLoadMean.class.getClassLoader().loadClass("CoreJava.J_Importent.ClassLoder.A_Basics.B").newInstance(); 		 
		 b.doSomethingElse();
	}
	
	/**
	 * Notice how the B class is referenced in the code, as the type of the object variable. [B b]
	 * This causes the B class to be loaded by the same class loader that loaded the class this code is residing in. 
	 * 
	 * What does class loading means?
	 * 
	 */
}


class B {
	
	public B(){
		System.out.println("inside B Constructor ");
	}
	
	public void doSomething(){
		System.out.println("inside B - do Something ");
	}
	
	public void doSomethingElse() {
		System.out.println("inside B - do Something Else");
	}	
}
