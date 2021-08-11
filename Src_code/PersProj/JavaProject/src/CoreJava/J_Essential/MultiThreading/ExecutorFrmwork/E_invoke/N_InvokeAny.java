package CoreJava.J_Essential.MultiThreading.ExecutorFrmwork.E_invoke;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * The invokeAny() method takes a collection of Callable[not Runnable] objects.
 * And returns the result of one of the Callable objects. 
 * You have no guarantee about which of the Callable's results you get. Just one of the ones that finish.
 * 
 *
 */
public class N_InvokeAny {
	
	private static final int NTHREDS = 10;

	public static void main(String[] args) {	
		
		
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		Set<Callable<Long>> callables = new HashSet<Callable<Long>>();
		
		for (int i = 0; i < 20;i++) {
			Callable worker = new MyCallableInvoke(30-i);
			callables.add(worker);			
		}
		
		try {
			Long result = executor.invokeAny(callables);
			System.out.println("result = " + result);

			executor.shutdown();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
