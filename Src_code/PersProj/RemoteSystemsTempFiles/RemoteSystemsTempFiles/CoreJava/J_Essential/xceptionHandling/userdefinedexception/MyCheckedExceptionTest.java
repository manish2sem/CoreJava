package CoreJava.J_Essential.xceptionHandling.userdefinedexception;

/**
 * Keep the following points in mind when writing your own exception classes:
 * - All exceptions must be a child of Throwable.
 * - If you want to write a checked exception that is AUTOMATICALLY ENFORCED BY THE HANDLE OR DECLARE RULE,
 * 		 you need to extend the Exception class. 
 * - If you want to write a runtime exception, you need to extend the RuntimeException class.
 * 
 * You will never directly extends Throwable because then it will be neither a checked nor a runtime exception.
 * 
 * Its two step process :
 * 1. Define the exception by extending exception/runtime
 * 2. declare it in method signature to handle it.
 * 
 * 
 * Practical Scenario:
 * 	- Create customize exception (by extending RuntimeException or Exception)
 *  - In your API method Throw that exception based on certain exceptional condition.
 *  		In case of Checked Exception you need to declare it as well,  in API method.
 *  - Whenever user use this method they need to handle (using try catch) if it is checked.
 *  		Handling is optional in case of unchecked. 
 *
 */

public class MyCheckedExceptionTest{

	public static void main(String[] args) throws MyCheckedException {
		
		RandomGenerator randomGenerator = new RandomGenerator();
		
	//	try {
			randomGenerator.throwOnMinus();
			System.out.println("This willNever execute");
		/*}catch (MyCheckedException e){
			e.printMsg();
			System.out.println("cheched Exception occured");
		}*/
		
		System.out.println("This will execute as exception caught gracefully");
		
		System.out.println("End of main");


	}

}

class RandomGenerator{
	int x;
	int y;
	
	public RandomGenerator(){
	//	x = (int) (Math.random() * 100 + 1);
	//	y = (int) (Math.random() * 100 + 1);		
	}
	
	
	public void throwOnMinus() throws MyCheckedException{ //step 2.a this makes it checked exception
//	public void throwOnMinus(){ //step 2.a this makes it checked exception
		int i =0;
		do {
			
			x = (int) (Math.random() * 100 + 1);
			y = (int) (Math.random() * 100 + 1);	
			int z = x*3-y;
			
			System.out.println("Z : "+z);
			
			if (z<0) {
				z=1000;
				throw new MyCheckedException(); // step 2.b
				
			}
			
			System.out.println("This will not execute once exception thrown : " +z  +" i is : " +i);
			i++;
		}while(i < 10000);
		
		System.out.println("This will never execute  : "+i);
	}
	
	
}

//class MyCheckedException extends Exception { // step1
//checked exception is AUTOMATICALLY ENFORCED BY THE HANDLE OR DECLARE RULE

class MyCheckedException extends Exception { // step1
	
	public MyCheckedException(){
		super("checked exception");
	}
	
	void printMsg(){
		System.out.println("cheched Exception is thrown");
	}	
}

/**
 * So, how do we know that some method throws an exception that we have to catch?
Just as a method must specify what type and how many arguments it accepts and
what is returned, the exceptions that a method can throw must be declared (unless
the exceptions are subclasses of RuntimeException). The list of thrown exceptions
is part of a method's public interface. The throws keyword is used as follows to list
the exceptions that a method can throw:
*/
