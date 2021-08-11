package CoreJava.J_Basic.staticEx.BasicConcepts;

/**
 * 
 * Static members are not tied to any particular instance of a class.
 * No classes instances are needed in order to use static members of the class.
 * Use the dot operator to access static members.
 * 
 * Funda:
 * Remember that using a reference variable with the dot operator is really a syntax trick,
 * and the compiler will substitute the class name for the reference variable 
		Dog d = new Dog();
		d.doStuff(); 
			becomes:
		Dog.doStuff();// here Dog is class not object.
 
 * 
 * Use static methods to implement behaviors that are not affected by the state of any instances.
 * Use static variables to hold data that is class specific as opposed to instance specific
 * 		—there will be only one copy of a static variable, class and all instances share it.
 * 		-All static members belong to the class, not to any instance.
 * 		-static methods do not have direct access to non-static members(methods/variables). they can access via object
 * 		- But non-static method can have direct access to static members.
 * 

 *  static methods can't be overridden, but they can be redefined.
 *
 */

public class BasicStaticClass {
	//@SuppressWarnings("static-access")
	public static void main(String args[] ){
		FrogClass frog1 = new FrogClass();
		FrogClass frog2 = new FrogClass();
		FrogClass frog3 = new FrogClass();
		
		System.out.println("Count inside Main: " +FrogClass.staticFrogCount);
		FrogClass.staticPrint();
		//Frog.simplePrint();   //--> Not Possible
		frog1.simplePrint();
		frog2.staticPrint();// This is equivalent to FrogClass.staticPrint()
		
		FrogClass frog4 = new FrogClass();
		System.out.println("Count inside Main : " +frog4.staticFrogCount); //equivalent to FrogClass.staticFrogCount
	}
}

class FrogClass {
	static int staticFrogCount = 0; // Declare and initialize
	int frogCount = 0;
	// static variable
	public FrogClass() {
	staticFrogCount += 1; // Modify the value in the constructor
	frogCount +=1;
	}
	
	static void staticPrint()
	{
		System.out.println("Count inside staticPrint : " +staticFrogCount);
		
	//Note : This is not possible, Non-Static called by Static
	//	System.out.println("Count inside staticPrint : " +nonStaticCount);
	//	simplePrint();							
	}
	
	void simplePrint()
	{
		System.out.println("Count inside simplePrint: " +staticFrogCount);
		staticPrint();
		System.out.println("Count inside nonStaticCount : " +frogCount);// Note : This is possible
	}
}
