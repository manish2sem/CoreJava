package CoreJava.J_Essential.MultiThreading.Z_Jenkov.E_ThreadPool.A_blockingQ;

import java.util.LinkedList;
import java.util.List;

/**
 * A blocking queue is a queue that blocks when you try to dequeue(remove) from it and the queue is empty, or
 * if you try to enqueue(insert) items to it and the queue is already full.
 * A thread trying to dequeue from an empty queue is blocked until some other thread inserts an item into the queue. 
 * A thread trying to enqueue an item in a full queue is blocked until some other thread makes space in the queue,
 * either by dequeuing one or more items or clearing the queue completely. 
 * 
 * Java 5 comes with blocking queue implementations in the java.util.concurrent package.
 * 
 * This code does not work completely because it's uses is wrong
 */

public class BlockingQueue {

	public static void main(String args[]) throws InterruptedException{
		MyBlockingQ blockingQ = new MyBlockingQ(3);
		blockingQ.enqueue("Name");
		Thread.sleep(1000);
		blockingQ.enqueue("Manish");
		Thread.sleep(1000);
		blockingQ.enqueue("Sam");
		Thread.sleep(1000);
		blockingQ.enqueue("Vir");
		Thread.sleep(1000);
		blockingQ.enqueue("XYZ");
		Thread.sleep(1000);

		blockingQ.dequeue();
		Thread.sleep(1000);
		blockingQ.dequeue();
		Thread.sleep(1000);
		blockingQ.dequeue();
		Thread.sleep(1000);

		blockingQ.display();
	}

	/*private List queue = new LinkedList();
	private int  limit = 10;

	public BlockingQueue(int limit){
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException  {
		while(this.queue.size() == this.limit) {
			System.out.println("Queue is full waiting to remove ... "); 
			wait();
		}
		if(this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException{

		while(this.queue.size() == 0){
			System.out.println("Queue is empty waiting for data ... "); 
			wait();
		}

		if(this.queue.size() == this.limit){
			notifyAll();
		}

		return this.queue.remove(0);
	}

	public void display(){
		for(Object q : queue) {
			System.out.println((String)q);
		}

	}
*/
}


/**
 * This code does not work completely because it's uses is wrong.
 * Mostly blocking Queue is used in multi-threading environment like consumer=producer.
 * Where one thread consumes the resource and other produces. 
 */







