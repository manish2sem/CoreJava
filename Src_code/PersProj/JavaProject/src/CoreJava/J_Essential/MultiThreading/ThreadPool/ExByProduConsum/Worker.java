package CoreJava.J_Essential.MultiThreading.ThreadPool.ExByProduConsum;

import java.util.concurrent.BlockingQueue;

/**
 * Point to note ->
 * task.run() is called instead of task.start() inside run() method of Worker.
 * 		By doing this we avoid creating thread per task like ex1[A_ProducerConsumer]. 	
 * 
 * the run method of worker is started by MyThreadPool[Constructor] -> t.start(); 
 * 
 * Again this run method runs the task.run() method in infinite loop.
 * So these thread never die, once completes it waits for another task in loop[virtually in pool]. 
 * 
 * @author sinhama
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
