package CoreConcepts.ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



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