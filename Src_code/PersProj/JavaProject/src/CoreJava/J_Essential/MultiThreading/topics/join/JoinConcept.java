package CoreJava.J_Essential.MultiThreading.topics.join;

/**
 * The non-static join() method of class Thread lets one thread "join onto the end" of another thread. 
 * If you have a thread B that can't do its work until another thread A has completed its work,
 * then you want thread B to "join" thread A. 
 * This means that thread B will not become runnable until A has finished.

		Thread t = new Thread();
		t.start();
		t.join();
 *
 *
 * The preceding code takes the currently running thread (if this were in the main() method, then that would be the main thread) 
 * and joins it to the end of the thread referenced by t.
 * This blocks the current thread from becoming runnable until after the thread referenced by t is no longer alive. 
 * In other words, the code t.join() means "Join me (the current thread) to the end of t, 
 * so that t must finish before I (the current thread) can run again."
 * @author Manish
 *
 */

public class JoinConcept {
	
	public static void main (String [] args) {
		JoinConcept joinConcept = new JoinConcept();
		joinConcept.nonOrderedJoin();
		//joinConcept.orderedJoin();
	}

	private void nonOrderedJoin(){
	
		MyThread t1 = new MyThread(); 			//every thread of execution begins as an instance of class Thread.
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
	
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		
			
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exiting Non Order join");
	}

	


	private void orderedJoin(){
		MyThread t1 = new MyThread(); 			//every thread of execution begins as an instance of class Thread.
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.setPriority(Thread.MIN_PRIORITY);
		
	
		t1.start();
	
	/*for (int i=0; i<10000; i++){
		
	}*/
	
		try {
			t1.join();		
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		t2.start();
		try {
			t2.join();		
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		t3.start();
	
		try {
			t3.join();		
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}

class MyThread extends Thread {
	public void run() {
		for (int i=1000; i>0; i--){
			System.out.println(Thread.currentThread().getName() + "  count : " + i );	
			
		}
	}
}

/**
 * 
 * Observations on Results : nonOrderedJoin
 * Calling join in order does not mean that they will finish in same order, once they started.
 * It does not mean that t1.join() will force t1 to finish first, and 
 * only after its completion t2 will start.
 * t1.join(), t2.join() and t3.join() means they will complete before main thread finish.
 * they are called on main thread so main thread will join at the end of t1, t2 and t3.
 * 
 * calling join in order does not mean that they will finish in same order, if they all started before calling join.
 * 
 * Observations on Results : orderedJoin 
 * start is followed by join then it is certain that the followed thread will start after the completion of first thread.
 * even though last thread(last started after 2nd last join) has maximum priority.


It is possible to enforce the order of execution to some extent by setting different priorities for threads.
 */

