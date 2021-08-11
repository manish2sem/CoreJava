package CoreJava.J_Advance.JUnitConcept.JunitTest.AdvTopics;

import org.junit.Test; 

import CoreJava.J_Advance.JUnitConcept.JunitSrc.AdvTopics.ExceptionCls;
import static org.junit.Assert.assertEquals;

/**
 * Junit provides a option of tracing the Exception handling of code.
 * You can test the code whether code throws desired exception or not. 
 * The expected parameter is used along with @Test annotation as @Test(expected).
 *
 */

public class TestExceptionCls {

	String message = "Robert"; 

	ExceptionCls messageUtil = new ExceptionCls(message);

	@Test(expected = ArithmeticException.class)	
	public void testPrintMessage() { 
		System.out.println("Inside testPrintMessage()");
		messageUtil.printMessage();
	}

	@Test public void testSalutationMessage() { 
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + "Robert"; 
		assertEquals(message,messageUtil.salutationMessage()); 
	}

}
