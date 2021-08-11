package CoreJava.J_Advance.JUnitConcept.JunitTest.JunitClasses;

import org.junit.Test; 
import junit.framework.AssertionFailedError; 
import junit.framework.TestResult;

/**
 * A TestResult collects the results of executing a test case. 
 * It is an instance of the Collecting Parameter pattern. 
 * The test framework distinguishes between failures and errors.
 * A failure is anticipated and checked for with assertions. 
 * Errors are unanticipated problems like an ArrayIndexOutOfBoundsException. 
 *  
 *  Some of the important methods of TestResult class are:
 *
 */

public class TestResultCls extends TestResult{

	public synchronized void addError(Test test, Throwable t) {
		super.addError((junit.framework.Test) test, t);
	} 

	// add the failure 
	public synchronized void addFailure(Test test, AssertionFailedError t) { 
		super.addFailure((junit.framework.Test) test, t); 
	} 

	@Test public void testAdd() { 
		// add any test 
	} 

	// Marks that the test run should stop. 
	public synchronized void stop() { 
		//stop the test here 
	}
}


