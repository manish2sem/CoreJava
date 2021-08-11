package CoreJava.J_Advance.JUnitConcept.RunnerClasses.AdvTopics;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import CoreJava.J_Advance.JUnitConcept.JunitTest.AdvTopics.TestExceptionCls;

public class RunnerExceptionCls {
	
	public static void main(String[] args) { 
		Result result = JUnitCore.runClasses(TestExceptionCls.class);

		for (Failure failure : result.getFailures()) { 
			System.out.println(failure.toString()); 
		} 

		System.out.println(result.wasSuccessful()); 
	}


}
