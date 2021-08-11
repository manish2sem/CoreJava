package CoreJava.J_Essential.xceptionHandling.Tricky;

/**
 * - Code within a try/catch block is referred to as protected code
 * - Exception(being the parent of both checked and runtime) catches all exceptions, both checked and run time.
 * - A try block can be followed by multiple catch blocks. but catch blocks cannot simply appear in a random order. 
 * When an exception occurs, the catch blocks are checked in the order in which they appear. order is child to parent.
 * 
 * - The finally keyword is used to create a block of code that follows a try block. 
 * - A finally block of code always executes, whether or not an exception has occurred.
 * 
 * Remember, finally clauses are not mandatory..
 * Also, catch clauses are not mandatory after try block!!!
 * so, sometimes you'll run across code that has a try block immediately followed by a finally block.
 *
 */

public class ExcepionHierachy {
	public static void main(String [] args)	{
		ArithmeticExceptionEx arithmeticExceptionEx = new ArithmeticExceptionEx();
		arithmeticExceptionEx.methodWithException();
		System.out.print(" ");	
		arithmeticExceptionEx.methodWithoutCatch();
	}
}

class ArithmeticExceptionEx {
	public void methodWithException() {
		try {
			int n =45/0;
		}catch (ArithmeticException e) {
			System.out.print("1 ");		
		}catch (RuntimeException e) {
			System.out.print("2 ");		
		}catch (Exception e) {
			System.out.print("3 ");		
		}finally{
			System.out.print("4 ");			
		}

		System.out.println("5");
	}

	public void methodWithoutCatch() {
		try {
			int n =45/0;
		}finally{
			System.out.print("4 ");			
		}

		System.out.println("5 ");

	}
}

/**
 * A finally block encloses code that is always executed at some point after the try block, 
 * whether an exception was thrown or not; Even if there is a return statement in the try block. 
 * the finally block executes right after the return statement is encountered, and before the return executes!
 */

