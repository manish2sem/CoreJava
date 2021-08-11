package CoreJava.J_Advance.JUnitConcept.JunitTest.AdvTopics;

import org.junit.Test; 

import CoreJava.J_Advance.JUnitConcept.JunitSrc.AdvTopics.TimeoutCls;
import static org.junit.Assert.assertEquals;

/**
 * Junit provides a handy option of Timeout. 
 * If a test case takes more time than specified number of milliseconds then Junit will automatically mark it as failed. 
 * The timeout parameter is used along with @Test annotation as @Test(timeout).
 *
 */

public class TestTimeout {

	String message = "Robert";
	TimeoutCls messageUtil = new TimeoutCls(message); 

	@Test(timeout=1000)
	public void testPrintMessage() { 
		System.out.println("Inside testPrintMessage()");
		messageUtil.printMessage(); 
	} 

	@Test public void testSalutationMessage() { 
		System.out.println("Inside testSalutationMessage()"); 
		message = "Hi!" + "Robert"; assertEquals(message,messageUtil.salutationMessage()); 

	}

}
