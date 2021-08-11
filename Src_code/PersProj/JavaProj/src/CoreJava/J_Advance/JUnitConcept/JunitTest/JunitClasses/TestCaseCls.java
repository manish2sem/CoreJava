package CoreJava.J_Advance.JUnitConcept.JunitTest.JunitClasses;

import junit.framework.TestCase; 
import org.junit.Before; 
import org.junit.Test;

/**
 * A test case defines the fixture to run multiple tests.
 * 
 * Important Methods :
 * 		protected void setUp() - runs before every testCase
 * 		protected void tearDown() - runs after every testCase
 * 		public int countTestCases() - Number of test cases executed by run
 * 		public String getName() - Name of test case
 * 
 * 
 * Class signature of TestCase 
 * 	public abstract class TestCase extends Assert implements Test
 *
 */

public class TestCaseCls extends TestCase{
	
	protected double fValue1; 
	protected double fValue2;
	
	//@Before 
	public void setUp() { 
		fValue1= 2.0; 
		fValue2= 3.0; 
		System.out.println("inside Setup");
	} 
	
	@Test 
	public void testAdd() { 
		//Count the number of test cases 
		System.out.println("No of Test Case = "+ this.countTestCases()); 
		//test getName 
		String name= this.getName(); 
		System.out.println("Test Case Name = "+ name);
		this.setName("testNewAdd"); 
		String newName= this.getName(); 
		System.out.println("Updated Test Case Name = "+ newName);
	}
	
	
	@Test 
	public void testAdd1() { 
		//Count the number of test cases 
		System.out.println("No of Test Case = "+ this.countTestCases()); 
		//test getName 
		String name= this.getName(); 
		System.out.println("Test Case Name = "+ name);
		this.setName("testNewAdd1"); 
		String newName= this.getName(); 
		System.out.println("Updated Test Case Name = "+ newName);
	}
	
	
	@Test 
	public void testAnotherTest() { 
		//Count the number of test cases 
		System.out.println("TestCaseName = "+ this.toString()); 
		
	}

	public void tearDown( ) {
		System.out.println("inside tearDown");
	}
}
