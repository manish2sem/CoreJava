package CoreJava.J_Advance.JUnitConcept.RunnerClasses.JunitClasses;

import org.junit.runner.JUnitCore; 
import org.junit.runner.Result; 
import org.junit.runner.notification.Failure;

import CoreJava.J_Advance.JUnitConcept.JunitTest.JunitClasses.TestCaseCls;

public class TestRunnerofTestCase {

	public static void main(String[] args) { 
		Result result = JUnitCore.runClasses(TestCaseCls.class); 
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString()); 
		} 
		System.out.println(result.wasSuccessful()); 
	}
	
	

}
