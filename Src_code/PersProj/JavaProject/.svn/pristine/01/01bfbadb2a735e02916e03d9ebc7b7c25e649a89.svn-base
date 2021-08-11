package CoreConcepts.ThreadPool;

import java.util.concurrent.BlockingQueue;

/**
 * This is the actual component(Thread) of ThreadPool.
 * The worker thread is started by MyThreadPool[Constructor] -> t.start(); 
 * These thread never die, once completed it waits for another task in loop[virtually in pool]. 
 * 
 * run method runs the task.run()[NOT task.start()] method.
 *
 */
public class Worker extends Thread{
	
	private final BlockingQueue<Runnable> taskQueue;
	
	public Worker(String name, BlockingQueue<Runnable> taskQueue){
		super(name);
		this.taskQueue = taskQueue;
	}
	
	public void run() {
		while (true) {
			try {
				Runnable r = taskQueue.take();
				r.run(); //
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	}

}
