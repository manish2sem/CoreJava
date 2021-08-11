package CoreJava.J_Essential.MultiThreading.ExecutorFrmwork.E_invoke;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The invokeAll() method invokes all of the Callable objects you pass to it in the collection.
 * The invokeAll() returns a list of Future objects via which you can obtain the results of the executions of each Callable.
 *
 */
public class O_InvokeAll {
	
	private static final int NTHREDS = 10;

	public static void main(String[] args) throws InterruptedException, ExecutionException {	
		
		
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		Set<Callable<Long>> callables = new HashSet<Callable<Long>>();
		
		for (int i = 0; i < 20; i++) {
			Callable worker = new MyCallableInvoke(30+i);
			callables.add(worker);			
		} 
		
		List<Future<Long>> futures = executor.invokeAll(callables);

		for(Future<Long> future : futures){
		    System.out.println("future.get = " + future.get());
		}

		executor.shutdown();		
		
	}

}
