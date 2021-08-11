package CoreJava.J_Advance.JUnitConcept.RunnerClasses;

import org.junit.runner.JUnitCore; 
import org.junit.runner.Result; 
import org.junit.runner.notification.Failure;

import CoreJava.J_Advance.JUnitConcept.JunitTest.Test_A_JunitBasics;

/**
 * The test cases are executed using JUnitCore class. 
 * JUnitCore is a facade for running tests. 
 * It supports running JUnit 4 tests, JUnit 3.8.x tests, and mixtures.
 * 
 * The package CoreJava.of org.junit.runner and classes defined there are :
 *  - JUnitCore : Use runClasses method of JUnitCore class of JUnit to run test case.
 * 	- Result : Get the result of test cases run(output of above step) in Result Object.
 * 	- Get failure(s) using getFailures() methods of Result object. 
 * 	- Get Success result using wasSuccessful() methods of Result object
 * @author sinhama
 *
 */

public class A_JunitBasicsRunner {

	public static void main(String[] args) { 
		
		System.out.println("Executing runner");

		Result result = JUnitCore.runClasses(Test_A_JunitBasics.class); 

		for (Failure failure : result.getFailures()) { 
			System.out.println("Failure : " +failure.toString()); 
		} 

		System.out.println(result.wasSuccessful()); 
	}

}
