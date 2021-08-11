package CoreJava.J_Essential.MultiThreading.ExecutorFrmwork.C_RunnableExecute;

/**
 * http://www.vogella.com/tutorials/JavaConcurrency/article.html
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class N_SimpleThreadExe {

	public static void main(String[] args) {
		// We will store the threads so that we can check if they are done
		List<Thread> threads = new ArrayList<Thread>();
		// We will create 500 threads
		int threadCnt = 10;
		for (int i = 0; i <threadCnt; i++) {
			Runnable task = new MyRunnable(10L + i);
			Thread worker = new Thread(task);			// Creating a new thread causes some performance overhead
			// We can set the name of the thread
			worker.setName(String.valueOf(i));
			worker.start();								// Too many threads can lead to reduced performance - context switching.
			// Remember the thread for later usage
			threads.add(worker);						// No control on the number of threads. Leads to out of memory errors due to too many threads[imagine threadCnt = 100000].
		}
		int running = 0;
		do {
			running = 0;
			for (Thread thread : threads) {
				if (thread.isAlive()) {
					running++;
				}
			}
			System.out.println("We have " + running + " running threads. ");
		} while (running > 0);

	}
}


/**
 * Issue with this code - 
 * 	- Creating a new thread causes some performance overhead.
 * 	- You cannot easily control the number of threads, therefore you may run into out of memory errors due to too many threads.
 *	- Too many threads can lead to reduced performance, as the CPU needs to switch between these threads.
 * 	
 * 
 */
