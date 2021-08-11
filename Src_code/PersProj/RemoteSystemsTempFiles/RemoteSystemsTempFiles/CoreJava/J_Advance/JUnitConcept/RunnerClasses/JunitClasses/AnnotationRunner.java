package CoreJava.J_Advance.JUnitConcept.RunnerClasses.JunitClasses;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import CoreJava.J_Advance.JUnitConcept.JunitTest.JunitClasses.JunitAnnotation;

public class AnnotationRunner {

	public static void main(String[] args) { 

		Result result = JUnitCore.runClasses(JunitAnnotation.class); 

		for (Failure failure : result.getFailures()) { 
			System.out.println(failure.toString()); 
		} 

		System.out.println(result.wasSuccessful()); 
	}

}
