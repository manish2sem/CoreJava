package CoreJava.J_Essential.MultiThreading.ExecutorFrmwork.C_RunnableExecute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * http://www.vogella.com/tutorials/JavaConcurrency/article.html
 * 
 * ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
 * 		ExecutorService is created using the newFixedThreadPool() factory method of Executors class.
 *      This creates a thread pool with 10 threads executing tasks.
 * 
 * xecutorService.execute(worker);
 * 		The execute(Runnable) method takes a java.lang.Runnable object, and executes it asynchronously. 
 *		There is no way of obtaining the result of the executed Runnable. 
 *  Similar to this we have two following methods - 
 *  	submit(Runnable) - returns a Future object. future.get() returns null. Remember run method is void.
 *  	submit(Callable) - returns a Future object. and you can get the returned value by future.get().
 *  
 *  executor.shutdown() - 
 *  The active threads inside this ExecutorService prevents the JVM from shutting down. 
 *  To terminate the threads inside the ExecutorService you call its shutdown() method. 
 *  The ExecutorService will stop accepting new tasks, and once all threads have finished current tasks, the ExecutorService shuts down. 
 *  
 *  to shut down the ExecutorService immediately, you can call the shutdownNow() method. 
 *  This will attempt to stop all executing tasks right away, and skips all submitted but non-processed tasks.
 *  
 */	

public class O_ExecutorExe {
	
	private static final int NTHREDS = 10;

	  public static void main(String[] args) {
	    ExecutorService executor = Executors.newFixedThreadPool(NTHREDS); //Creating 10 threads in threadpool.
	    int threadCnt = 100;
	    for (int i = 0; i < threadCnt; i++) {				//creating 12 task. 
	      Runnable worker = new MyRunnable(25L + i);
	      executor.execute(worker);					// ASSIGNing this task TO any free thread of pool of 10 threads.
	    }
	    // This will make the executor accept no new threads
	    // and finish all existing threads in the queue
	    executor.shutdown();
	   // executor.shutdownNow();
	    // Wait until all threads are finish
	    try {
			executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Finished all threads");
	  }

}

/**
 * Code Explanation:
 * 	We have 10 threads in threadpool.
 * 		so any task will be assigned any of these 10 threads[free] in pool.
 * 
 * We have 12 task. see the for loop. in every loop one task is created AND ASSIGNED TO any free thread of pool of 10 threads.
 * 
 * With This - 
 *  Executors.newFixedThreadPool(NTHREDS)  - This control no of thread creation i.e. NTHREDS.
 *  We overcome all the issues discussed in N_SimpleThreadExe.
 * 
 */ 
