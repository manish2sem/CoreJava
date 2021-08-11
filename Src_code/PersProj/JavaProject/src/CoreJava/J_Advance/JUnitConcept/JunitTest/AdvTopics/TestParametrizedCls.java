package CoreJava.J_Advance.JUnitConcept.JunitTest.AdvTopics;

import java.util.Arrays; 
import java.util.Collection; 
import org.junit.Test; 
import org.junit.Before; 
import org.junit.runners.Parameterized; 
import org.junit.runners.Parameterized.Parameters; 
import org.junit.runner.RunWith; 

import CoreJava.J_Advance.JUnitConcept.JunitSrc.AdvTopics.ParametrizedCls;
import static org.junit.Assert.assertEquals;

/**
 * JUnit 4 has introduced a new feature Parameterized tests. 
 * Parameterized tests allow developer to run the same test over and over again using different values.
 * 
 *  Following five steps need to be followed to create Parameterized tests.  
 * 	- Annotate test class with @RunWith(Parameterized.class).
 * 	- Create a public static method annotated with @Parameters that returns a Collection of Objects (as Array) as test data set. 
 * 	- Create a public constructor that takes in what is equivalent to one "row" of test data. 
 * 	- Create an instance variable for each "column" of test data. 
 * 	- Create your tests case(s) using the instance variables as the source of the test data.
 * The test case will be invoked once per each row of data.
 * 
 *
 */

@RunWith(Parameterized.class)
public class TestParametrizedCls {
	private Integer inputNumber; 
	private Boolean expectedResult;
	private ParametrizedCls primeNumberChecker;

	@Before public void initialize() { 
		System.out.println("Initializing ... "); 

		primeNumberChecker = new ParametrizedCls();
	}

	public TestParametrizedCls(Integer inputNumber, Boolean expectedResult) {
		this.inputNumber = inputNumber; 
		this.expectedResult = expectedResult; 
	}

	@Parameters 
	public static Collection primeNumbers() { 
		return Arrays.asList(new Object[][] { 
				{ 2, true }, 
				{ 6, false }, 
				{ 19, true }, 
				{ 22, false },
				{ 23, true } 
		}); 
	}

	@Test
	public void testParametrizedCls() { 
		System.out.println("Parameterized Number is : " + inputNumber); 
		assertEquals(expectedResult, primeNumberChecker.validatePrime(inputNumber)); 
	}
}
