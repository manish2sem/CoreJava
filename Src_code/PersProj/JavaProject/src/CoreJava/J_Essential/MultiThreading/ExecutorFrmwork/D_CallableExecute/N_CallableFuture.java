package CoreJava.J_Essential.MultiThreading.ExecutorFrmwork.D_CallableExecute;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The submit(Callable) method takes a Callable implementation, but returns a Future object.
 * 	Future submit = executor.submit(worker);
 * 
 * This Future object can be used to check the status of a Callable and to retrieve the result from the Callable.
 * 		future.get();
 * @author sinhama
 *
 */

public class N_CallableFuture {
	private static final int NTHREDS = 10;

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		List<Future> list = new ArrayList<Future>();
		for (int i = 0; i < 20;i++) {
			Callable<Long> worker = new MyCallable();
			Future<Long> submit = executor.submit(worker);
			list.add(submit);
		}
		long sumTotal = 0;
		System.out.println(list.size());
		// now retrieve the result
		for (Future<Long> future : list) {
			try {
				long sum = future.get();
				System.out.println(sum);
				sumTotal += sum;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sumTotal);
		executor.shutdown();
	}
} 

