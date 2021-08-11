package CoreConcepts.ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import CoreConcepts.ThreadPool.ProducerConsume.Consumer;
import CoreConcepts.ThreadPool.ProducerConsume.Producer;


public class ProducerConsumer {
	private final BlockingQueue<Integer> queue;

	public static void main(String[] args) {
		ProducerConsumer prodconsumer = new ProducerConsumer();
		prodconsumer.init();

	}

	public ProducerConsumer() {
		queue = new LinkedBlockingQueue<Integer>(3);
	}

	private void init() {
		MyThreadPool pool = new MyThreadPool(10);// 10 Threads are created.
		for(int i = 0; i < 100; i++){
			pool.addTask(new Producer(queue));
			pool.addTask(new Producer(queue));
			pool.addTask(new Producer(queue));

			pool.addTask(new Consumer(queue));
			pool.addTask(new Consumer(queue));
			pool.addTask(new Consumer(queue));
		}

	}

}
