package CoreJava.J_Advance.JUnitConcept.JunitSrc;

/**
 * This is three step process:
 * - Create a java class to be tested
 * - Write a Test class for java class
 * - Write a runner class  for running test class.
 * 
 * @author sinhama
 *
 */

public class A_JunitBasics {
	
	public static void main(String[] args) {
		A_JunitBasics junitBasics = new A_JunitBasics("Test Msg");
		junitBasics.printMessage();
	}

	private String message; 

	//Constructor 
	//@param message to be printed 
	public A_JunitBasics(String message){ 
		this.message = message; 
	} 
	
	// prints the message 
	public String printMessage(){ 
		System.out.println(message);
		return message;
	}

}
