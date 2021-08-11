package CoreJava.J_Essential.InnerClasses.MethodLocal;


/**
 * Inner class can be defined inside method of any class.
 * 
 * RULE1:
 * 		A method-local inner class can be instantiated only within the method where the inner class is defined.
 * 		and after class definition.
 * 
 * RULE2:
 * 		method-local inner class can access the private members of outer class just as regular inner class. 
 * 		However, the inner class object cannot use the local variables of the method the inner class is in. 
 * 		Except final local variable.
 * 
 * modifiers for method-local inner classes : 
 * 		The same rules apply to method-local inner classes as to local variable declarations. 
 * 		You can't mark a method-local inner class public, private, protected, static, transient, and the like. 
 * 		The only modifiers you can apply to a method-local inner class are abstract and final, but never both at the same time.
 * 
 * BURN IN YOUR MIND:
 * 		- A method-local inner class can be instantiated only within the method where the inner class is defined and 
 * 			after class definition.
 * 		- method-local inner class access the private members of outer class but
 * 		 	cannot use the local variables of the method the inner class is in, Except final local variable.
 * 
 */

public class MyOuter {
	private String x = "Outer2";
	
	public static void main(String args[]) { 
		MyOuter outer = new MyOuter();
		outer.doStuff();
	}
	
	void doStuff() {
		
		int i=12;
		final int j=10;
		
		class MyInner {
			public void seeOuter() {
				System.out.println("Outer x is " + x);
			//	System.out.println("methods variable i is " + i); // compilation error
				System.out.println("methods variable j is " + j);
			} 			
		}
		System.out.println("methods variable i is " + i);
		
		MyInner mi = new MyInner(); // This line must come after the inner class definition
		mi.seeOuter();
	}

}

/**
 * the inner class object cannot use the local variables of the method the inner class is in. Why not?
 * The local variables of the method live on the stack, and exist only for the lifetime of the method. 
 * When the method ends, the stack frame is blown away and the variable is history. 
 * But even after the method completes, the inner class object created within it might still be alive on the heap if, 
 * for example, a reference to it was passed into some other code and then stored in an instance variable. 
 * Because the local variables aren't guaranteed to be alive as long as the method-local inner class object,
 * the inner class object can't use them. Unless the local variables are marked final! 
 */

/**
 * Local variable need to be initialized. Why?
 * Why not this rule is applicable for instance variables?
 * 
 */
