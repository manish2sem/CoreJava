package CoreConcepts.ThreadPool.ProducerConsume;


import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	
	BlockingQueue sharedQ;
	
	public Consumer(BlockingQueue queue) {
		this.sharedQ = queue;
	}

	public void run(){
		try {
			System.out.println("Removing Element " + sharedQ.take());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
