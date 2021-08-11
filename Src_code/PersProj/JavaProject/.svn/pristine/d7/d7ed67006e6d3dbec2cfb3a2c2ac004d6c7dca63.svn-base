package Interview.MorganStanley.SummingTenTasks.ExeFrmWork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * There are task each returns integers after finishing the job. 
 * Write a program which adds all 10 integers as soon as they are returned.
 * @author sinhama
 *
 */

public class AddTenTaskMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executors = Executors.newFixedThreadPool(10);

		List<Callable<Long>> callableList = new ArrayList<Callable<Long>>();

		for(int i=0; i < 10; i++){
			callableList.add(new MyCallable(5 + 2*i));
		}
		
		List<Future<Long>> futures = null;
		Long sum = 0L;
		try {
			futures = executors.invokeAll(callableList);

			for(Future<Long> future : futures){
				System.out.println(future.get());
				sum = sum + future.get();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("Total ----> " + sum);
	}

}
