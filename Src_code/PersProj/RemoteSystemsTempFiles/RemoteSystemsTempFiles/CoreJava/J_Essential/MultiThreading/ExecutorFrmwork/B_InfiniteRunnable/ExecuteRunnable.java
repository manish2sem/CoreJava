package CoreJava.J_Essential.MultiThreading.ExecutorFrmwork.B_InfiniteRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * execute() method takes a Runnable[Not callable] object, and executes it asynchronously. 
 * There is no way of obtaining the result of the executed Runnable. 
 *
 */

public class ExecuteRunnable {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		executor.execute(new MyRunnable());
	//	executor.shutdown();
		System.out.println("Done");
	//	System.exit(0);
		
		for (int i = 0; i < 20; i++) {
		      executor.execute(new MyRunnable());
		      
		  }

	 //   List<Future> list = new ArrayList<Future>();

	}
}
