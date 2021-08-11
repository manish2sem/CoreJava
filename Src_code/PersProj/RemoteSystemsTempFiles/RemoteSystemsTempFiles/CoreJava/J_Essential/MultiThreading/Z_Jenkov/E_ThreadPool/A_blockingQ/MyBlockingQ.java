package CoreJava.J_Essential.MultiThreading.Z_Jenkov.E_ThreadPool.A_blockingQ;

import java.util.LinkedList;
import java.util.List;

/**
 * Blocking-Q : Blocks itself on limit conditions(i.e. empty or full).
 * 
 * Wait condition:
 * 		For consumer : When Q is empty. while deque.
 * 		For Producer : When Q is Full. while enque.
 * 
 * Notify condition:
 * 		For consumer : As soon as consumer finds Q is full, before consuming. while deque.
 * 		For Producer :  As soon as Producer finds Q is empty, before producing. while enque.
 * 
 * @author Manish
 *
 */

public class MyBlockingQ {

	private List queue = new LinkedList();
	private int  limit;

	public MyBlockingQ(int limit){
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
		System.out.println("Adding item ..." +item); 
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
		System.out.println("Removing item ..." ); 
		return this.queue.remove(0);
	}

	public void display(){
		for(Object q : queue) {
			System.out.println((String)q);
		}

	}

}
