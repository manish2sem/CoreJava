package CoreJava.J_Advance.JUnitConcept.JunitTest.JunitClasses;

import org.junit.After; 
import org.junit.AfterClass; 
import org.junit.Before; 
import org.junit.BeforeClass; 
import org.junit.Ignore; 
import org.junit.Test;

/**
 * Annotations are like meta-tags that you can add to you code and apply them to methods or in class. 
 * These annotation in JUnit gives us information about test methods.
 * 
 * List of annotations and their meaning in JUnit :
 * @Test the public void method to which this annotation is attached can be run as a test case. 
 * @Before Several tests need similar objects created before they can run. Annotating a public void method with @Before causes that method to be run before each Test method. 
 * @After If you allocate external resources in a Before method you need to release them after the test runs. Annotating a public void method with @After causes that method to be run after the Test method. 
 * @BeforeClass Annotating a public static void method with @BeforeClass causes it to be run once before any of the test methods in the class. 
 * @AfterClass This will perform the method after all tests have finished. This can be used to perform clean-up activities. 
 * @Ignore A test method annotated with @Ignore will not be executed.
 * 		If a test class is annotated with @Ignore then none of its test methods will be executed.
 * 
 * JUnit execution procedure :
 *  First of all methods preceded with @BeforeClass Annotation execute only once.  
 *  Methods preceded with @Before Annotation executes for each test case but before executing the test case.
 *  Methods preceded with @After Annotation executes for each test case but after the execution of test case.
 *  In between before() and after() each test case executes.
 *  Lastly, methods preceded with @AfterClass Annotation execute only once.
 *
 */



public class JunitAnnotation {

	@BeforeClass 
	public static void beforeClass() { 
		System.out.println("in before class");
		System.out.println();
	} 

	@AfterClass 
	public static void afterClass() {
		System.out.println("in after class");
	}


	@Before 
	public void before() { 
		System.out.println();
		System.out.println("in before"); 
	} 

	@After 
	public void after() {
		System.out.println("in after"); 
		System.out.println();
	} 

	@Test 
	public void test() { 
		System.out.println("in test"); 
	}
	
	@Test 
	public void test2() { 
		System.out.println();
		System.out.println("in test2"); 
	}

	@Ignore 
	public void ignoreTest() { 
		System.out.println("in ignore test"); 
	}
}
