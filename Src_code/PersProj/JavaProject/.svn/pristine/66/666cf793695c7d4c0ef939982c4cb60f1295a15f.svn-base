package CoreJava.J_Essential.xceptionHandling.Basics;

/**
 * An Error is a subclass of Throwable that indicates serious problems 
 * that a reasonable application should not try to catch. Most such errors are abnormal conditions. 
 * 
 * The ThreadDeath error, though a "normal" condition, is also a subclass of Error
 *  because most applications should not try to catch it. 
 * @author sinhama
 *
 * OutOfMemoryError is Thrown when the JVM cannot allocate an object because it is out of memory, and 
 * no more memory could be made available by the garbage collector.
 * OutOfMemoryError -> VirtualMachineError -> Error
 * 
 * Error -> outside of the control of application. Like hardware failure, out of memory etc.
 * 
 * Anyway, you can catch it as it descends from Throwable as following.
 */

public class OutofMemoryCatching {

	public static void main(String [] args)	{
		System.out.println("Inside main...");
		int [] values = {1, 2, 3, 4};
		System.out.println("Invoking method1...");
		method(values);
		System.out.println("*** Back in main ***");
	}

	public static void method(int [] y){
		try {
			System.out.println("\nInside method2");
			System.out.println(y[5]);
			System.out.println("*** Leaving method2 ***");
		} catch (OutOfMemoryError E) {
			// release some (all) of the above objects
		}
	}
}
