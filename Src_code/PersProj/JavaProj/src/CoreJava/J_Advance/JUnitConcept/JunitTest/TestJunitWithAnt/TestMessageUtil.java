package CoreJava.J_Advance.JUnitConcept.JunitTest.TestJunitWithAnt;

import CoreJava.J_Advance.JUnitConcept.JunitSrc.TestJunitWithAnt.MessageUtil;
import org.junit.Test; 
import org.junit.Ignore; 
import static org.junit.Assert.assertEquals;

public class TestMessageUtil {

	String message = "Robert"; 
	MessageUtil messageUtil = new MessageUtil(message);

	@Test 
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		assertEquals(message,messageUtil.printMessage()); 
	} 

	@Test 
	public void testSalutationMessage() { 
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + "Robert";
		assertEquals(message,messageUtil.salutationMessage()); 
	}

}
