package CoreJava.J_Essential.MultiThreading.ThreadPool.ExByProduConsum;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import CoreJava.J_Essential.MultiThreading.ThreadPool.ExByProduConsum.ProducerConsumer.Producer;
import CoreJava.J_Essential.MultiThreading.ThreadPool.ExByProduConsum.ProducerConsumer.Consumer;

public class A_ProducerConsumer {
	private final BlockingQueue<Integer> queue;
	
	public A_ProducerConsumer() {
		queue = new LinkedBlockingQueue<Integer>(3);		
	}

	public static void main(String[] args) {
		A_ProducerConsumer prodconsumer = new A_ProducerConsumer();
		prodconsumer.init();
	}

	

	public void init() {
		for (int i = 0; i < 100; i++) {
			new Thread(new Producer(queue), "Producer-1 of iteration "+i).start();
			new Thread(new Producer(queue), "Producer-2 of iteration "+i).start();
			new Thread(new Producer(queue), "Producer-3 of iteration "+i).start();
			
			new Thread(new Consumer(queue), "Cosumer-1 of iteration "+i).start();
			new Thread(new Consumer(queue), "Cosumer-2 of iteration "+i).start();
			new Thread(new Consumer(queue), "Cosumer-3 of iteration "+i).start();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

/**
 * 
 * Disadvantage of one thread per task approach
 * 	The overhead of creating a new thread for each request is significant. 
 * 		Server that processing requests can spend more time and consume more system resources in creating and destroying threads than it would processing actual client requests.
 * Creating too many threads in one JVM can cause the system to run out of memory or thrash due to excessive memory consumption.
 * 
 * This code has a producer task to put an integer to queue and a consumer task to take one integer from queue. 
 * when running in loop, each time code creates a new thread to perform task. It creates 600 threads for short lived tasks.
 */
