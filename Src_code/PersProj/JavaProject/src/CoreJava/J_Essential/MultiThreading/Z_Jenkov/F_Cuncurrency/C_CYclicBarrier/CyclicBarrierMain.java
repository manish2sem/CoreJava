package CoreJava.J_Essential.MultiThreading.Z_Jenkov.F_Cuncurrency.C_CYclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {
	public static void main(String args[]) {
		final CyclicBarrier cb = new CyclicBarrier(3, new Runnable(){
			@Override
			public void run(){
				//This task will be executed once all thread reaches barrier
				System.out.println("All parties are arrived at barrier, lets play");
			}
		});

		//starting each of thread
		Thread t1 = new Thread(new Task(cb), "Thread 1");
		Thread t2 = new Thread(new Task(cb), "Thread 2");
		Thread t3 = new Thread(new Task(cb), "Thread 3");

		t1.start();
		t2.start();
		t3.start();

	}
}




/**
 * we initialize CyclicBarrier with 3 parties, means in order to cross barrier, 3 thread needs to call await() method. 
 * each thread calls await method in short duration but they don't proceed until all 3 threads reached barrier, 
 * once all thread reach barrier, barrier gets broker and each thread started there execution from that point.
 */

