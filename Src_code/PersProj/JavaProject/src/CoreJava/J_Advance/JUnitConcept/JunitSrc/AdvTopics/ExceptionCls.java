package CoreJava.J_Advance.JUnitConcept.JunitSrc.AdvTopics;

/**
 * Junit provides a option of tracing the Exception handling of code. 
 * You can test the code whether code throws desired exception or not. 
 * The expected parameter is used along with @Test annotation as @Test(expected).
 *
 */

public class ExceptionCls {

	private String message;

	public ExceptionCls(String message){ 
		this.message = message; 
	}

	public void printMessage(){ 
		System.out.println(message); 
		int a =0; 
		int b = 1/a; 
	}

	public String salutationMessage(){ 
		message = "Hi!" + message;
		System.out.println(message); 
		return message; 
	}

}
