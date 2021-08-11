package CoreConcepts.ThreadPool.ProducerConsume;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	private static final Random rnd = new Random();
	
	BlockingQueue sharedQ;
	
	public Producer(BlockingQueue queue) {
		this.sharedQ = queue;
	}
	
	public void run() {
		Integer e = rnd.nextInt(100);
		System.out.println("Inserting Element " + e);
		try {
			sharedQ.put(e);
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

}
