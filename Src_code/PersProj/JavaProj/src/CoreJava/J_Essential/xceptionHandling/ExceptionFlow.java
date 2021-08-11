package CoreJava.J_Essential.xceptionHandling;

/**
 * When a method is invoked, it is pushed onto the method call stack.
 * When a method throws an exception, the method is popped off the call stack, and 
 * the exception is thrown to the previous method on the stack.
 * 
 * With an exception heading its way, method has three choices: 
 * 	- Catch the exception so that it does not go any further down the call stack.
 * 	- Catch the exception, then throw it back down the call stack.
 * 	- Not catch the exception, thereby causing method1() to be popped off the call stack, with the exception continuing down the call stack to main().
 * When an exception reaches the bottom of a call stack and no method has stopped it along the way including main(), 
 * the JVM will crash and inform you of the details of the exception.
 * An exception is considered handled by a method if the method stops the exception from continuing down the method call stack.
 * 
 * You can print this stack trace yourself with any exception you catch by using the printStackTrace() method of the Throwable class.
 */

public class ExceptionFlow {
	
	public static void main(String [] args)	{
		System.out.println("Inside main...");
		int [] values = {1, 2, 3, 4};
		System.out.println("Invoking method1...");
		method1(values);
		System.out.println("*** Back in main ***");
	}
	
	public static void method1(int[] x){
		System.out.println("\nInside method1...");
		method2(x);
		System.out.println("*** Back in method1 ***");
	}
	
	public static void method2(int[] y){
		System.out.println("\nInside method2");
		System.out.println(y[5]);
		System.out.println("*** Leaving method2 ***");
	}
}

/**
 * The array referenced by y has only four elements, so three is the largest index that can be used. 
 * This exception is thrown by the JVM, which pops method2() off the call stack. 
 * Because method1() does not do anything with the exception, method1() is popped off the call stack. 
 * Because main() ignores the exception as well, main() is popped off the call stack. 
 * The exception is then passed on to the JVM, and the JVM prints out the stack trace before terminating.
*/
