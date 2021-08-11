package CoreJava.J_Essential.MultiThreading.ThreadPool.ExByProduConsum;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import CoreJava.J_Essential.MultiThreading.ThreadPool.ExByProduConsum.ProducerConsumer.Consumer;
import CoreJava.J_Essential.MultiThreading.ThreadPool.ExByProduConsum.ProducerConsumer.Producer;

/**
 * Point to note ->
 * This maintains common Q shared by consumer and producer.
 * Creates the thread pool [of 10 threads].
 * and add the task into the workerQueue of thread pool.
 */

public class B_ProducerConsumer {

	private final BlockingQueue<Integer> queue;

	public static void main(String[] args) {
		B_ProducerConsumer prodconsumer = new B_ProducerConsumer();
		prodconsumer.init();

	}

	public B_ProducerConsumer() {
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


/**
 * We have two Q's
 * WorkerQ -> this maintain tasks to be executed.
 * queue -> this is shared between concumer and producer.
 * 
 */

/**
1. Performance

Object pooling provides better application performance As object creation is not done when client actually need it to perform some operation on it Instead objects are already created in the pool and readily available to perform any time. So Object creation activity is done much before So it does help in achieving better run-time performance

2. Object sharing :

Object Pooling encourage the concept of sharing. Objects available in pool can be shared among multiple worker threads . One thread Use the Object and once used it returns back to its Object pool and then it can be used by some other worker thread. So once created objects are not destroyed and thus destruction and creation again and again is not required. That again help in generating better performing code.

3. Control on Object instances : By declaring size of Object pool we can control the no of instance creation.
 Thus a finite no of objects are created as decided depending upon required application capacity and scalability or peak load.

4. Memory conservation : Finite no of instances are created So it helps in better memory management . Too many instances are not

*/
