package CoreJava.J_Essential.MultiThreading.ThreadIntrection;

/**
 * wait(), notify(), and notifyAll() are the methods of object class.
 * wait(), notify(), and notifyAll() must be called from within a synchronized context! 
 * A thread can't invoke a wait or notify method on an object unless it owns that object's lock. 
 * Most imp : 
 * 	- wait and notify must be owned by the lock of the same object for communication/interaction.
 * 
 * This implies (Clear from below ex)==>
 * no two [wait() or notify()] can be executed parallely.
 * Either wait() or notify(), whoever be access the object lock first will be executed first.
 * 
 * In the same way that every object has a lock, every object can have a list of threads that are waiting for a signal (a notification) from the object. 
 * A thread gets on this waiting list by executing the wait() method of the target object.
 * From that moment, it doesn't execute any further instructions until the notify() method of the target object is called. 
 * If many threads are waiting on the same object, only one will be chosen (in no guaranteed order) to proceed with its execution. 
 * If there are no threads waiting, then no particular action is taken.
 * 
 * For a thread to call wait() or notify(), the thread has to be the owner of the lock for that object.
 * When the thread waits, it temporarily releases the lock for other threads to use, but it will need it again to continue execution. 
 * 
 * When the wait() method is invoked on an object, the thread executing that code gives up its lock on the object immediately. 
 * However, when notify() is called, that doesn’t mean the thread gives up its lock at that moment. 
 * If the thread is still completing synchronized code, the lock is not released until the thread moves out of synchronized code. 
 * So just because notify() is called doesn’t mean the lock becomes available at that moment.
 * 
 *
 */

public class A_Concept {
	public static void main(String [] args) {
		ThreadA threadObj = new ThreadA();		
		threadObj.start();
		
		synchronized(threadObj) {
			try {
				System.out.println("***********Waiting for A to complete*********");
				Thread.sleep(5000);
				threadObj.wait();
			} catch (InterruptedException e) {}
			System.out.println("############Main Terminating ############# " );
		}
		
	}

}


class ThreadA extends Thread { 

	public synchronized void run() {
		int count = 0;
		while (true) {
			count++;
			System.out.println("Inside class  ThreadA : " + count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			notify();
			if (count>10 )
				break;
		}

	}
}


/**
 * wait() and notify() is called inside the synchronized block.
 * first main synchronized block is called on object  threadObj. 
 * main thread will be inside that block for 10 sec, till that time threadObj will wt for lock to release just before run method.
 * as soon as wait is called main thread will be placed on the wait list of object threadObj.
 * then immediately threadObj thread will run the run method.
 * Trick :
 * 	threadObj will loop for 10 times so it will call notify 10 times.
 * 	Even though main thread will not be notified.
 * 	It will be notified only when threadObj completes and come out the synchronized block.
 * 
 * once threadObj completes the block notify will be called and threadObj releases the lock.
 * Main thread grabs the lock and continue with execution.
 */