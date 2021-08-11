package CoreJava.J_Advance.JUnitConcept.RunnerClasses.JunitClasses;

import CoreJava.J_Advance.JUnitConcept.JunitTest.JunitClasses.TestCaseCls;
import CoreJava.J_Advance.JUnitConcept.JunitTest.JunitClasses.TestResultCls;
import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * TestSuite runs a collection of test cases from different test classes.
 * In JUnit, both @RunWith and@Suite annotation are used to run the suite test.
 * 
 * important methods of TestSuite class are :
 * 	- void addTest(Test test) Adds a test to the suite. 
 * 	- void addTestSuite(Class<? extends TestCase> testClass) Adds the tests from the given class to the suite.
 * 	- int countTestCases() Counts the number of test cases that will be run by this test. 
 * 	- String getName() Returns the name of the suite. 
 * 	- void run(TestResult result) Runs the tests and collects their result in a TestResult. 
 * 	- Test testAt(int index) Returns the test at the given index. 
 * 	- int runCount() Returns the number of tests in this suite.
 * @author sinhama
 *
 */

public class SuiteJunitClsses {

	public static void main(String[] a) { 
		// add the test's in the suite 

		TestSuite suite = new TestSuite(TestCaseCls.class, TestResultCls.class); 
		
		System.out.println("Number of test cases = " + suite.countTestCases()); 
		System.out.println("Number of testClass = " + suite.testCount()); 
		TestResult result = new TestResult();
		
		
		suite.run(result); 

		System.out.println("Number of test cases = " + result.runCount()); 
	}

}
