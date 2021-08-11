package CoreJava.J_Elementry.initBlock;

/**
 * rules:
 * Initialization blocks execute in the order they appear.
 * 
 * Static Initialization blocks run once, when the class is first loaded. 
 * 			Since it is static it is first to execute even before any constructor.
 * 
 * Imp Q -- when the class is first loaded???
 * 
 * Instance Initialization blocks run every time a class instance is created.
 * Instance Initialization blocks run just after the constructor's call to super(). 
 * 			So it runs before constructor 1st line and after super. 
 * 
 * Note : Remember Super() is the 1st statement in constructor.
 * If you don't write explicitly; compiler will do for you. 
 *
 */
public class InitializationBlock extends ClassC {

	InitializationBlock(){
		System.out.println("Inside InitializationBlock");
	}

	static 
	{ 
		System.out.println("1st static init"); 
	}

	{ 
		System.out.println("1st instance init"); 
	}

	{ 
		System.out.println("2nd instance init"); 
	}

	static { 
		System.out.println("2nd static init");
	}

	public static void main(String[] args) {
		InitializationBlock initializationBlock = new InitializationBlock();
		
		System.out.println("");
		System.out.println("******2nd Object");
		new InitializationBlock();

	}
}

class ClassA {
	ClassA() 
	{
		System.out.println("Inside ClassA");
	}
	{ 
		System.out.println("InitializationBlock ClassA"); 
	}

}

class ClassB extends ClassA {
	ClassB() 
	{
		System.out.println("Inside ClassB");
	}
	{ 
		System.out.println("InitializationBlock ClassB"); 
	}

	static{ 
		System.out.println("Static InitializationBlock ClassB"); 
	}
}

class ClassC extends ClassB {
	ClassC() 
	{
		System.out.println("Inside ClassC");
	}
	{ 
		System.out.println("InitializationBlock ClassC"); 
	}

	static{ 
		System.out.println("Static InitializationBlock ClassC"); 
	}
}

