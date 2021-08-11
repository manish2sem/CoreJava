package CoreJava.J_Essential.MultiThreading.ThreadPool.ExByProduConsum;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Point to note ->
 * No. of threads created [to run the task] is controlled by main class [B_ProducerConsumer].
 * only theses many thread.start() happens. Note, task.run() is called instead of task.start().
 * 
 * AddTask() method adds the task into separate Q workerQueue.
 * 
 *
 */
public class MyThreadPool {
	
	private final BlockingQueue<Runnable> taskQueue;
	private final Thread[] workerThreads;

	public MyThreadPool(int numThreads) {
		taskQueue = new LinkedBlockingQueue<Runnable>();
		workerThreads = new Thread[numThreads];

		int i = 0;
		for (Thread t : workerThreads) {
			i++;
			t = new Worker("Pool Thread "+i, taskQueue);
			t.start();
		}
	}
	
	public void addTask(Runnable r){
		try {
			taskQueue.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


