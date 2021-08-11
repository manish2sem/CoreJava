package CoreJava.J_Essential.xceptionHandling.Basics;

/**
 * 
 * @author Manish
 * A runtime exception is an exception that occurs 
 * that probably could have been avoided by the programmer.
 * 
 * EX : ArrayIndexOutOfBoundsException, NullPointerException, ClassCastException.
 * ArithmeticException
 * 
 * Since they are typically the result of programmer error;  therefore, 
 * you want the exception to crash your program so you can find and fix the problem.
 *
 */



public class RunTimeXception {
	
	public static void main(String [] args)	{
		System.out.println("Inside main...");
		int [] values = {1, 2, 3, 4};
		System.out.println("Invoking method1...");
		method1(values);
		System.out.println("*** Back in main last line***");
	}
	
	public static void method1(int [] x){
		System.out.println("\nInside method1...");
		method2(x);
		System.out.println(" Back in method1 ***");
	}
	
	public static void method2(int [] y){
		System.out.println("\nInside method2");
		
		System.out.println(y[5]);
		/*try{
			System.out.println(y[5]);
		}catch (RuntimeException rte) {
			System.out.println("Runtime Exception ->"+rte.getMessage());
		}*/
		System.out.println("*** Leaving method2 ***");
	}

}
