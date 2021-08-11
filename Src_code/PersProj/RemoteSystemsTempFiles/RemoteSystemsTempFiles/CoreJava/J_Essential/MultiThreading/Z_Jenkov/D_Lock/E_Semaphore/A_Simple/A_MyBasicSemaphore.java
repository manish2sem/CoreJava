package CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock.E_Semaphore.A_Simple;

/**
 * A Semaphore is a thread synchronization construct that can be used 
 * 		- either to send signals between threads to avoid missed signals, or 
 * 		- to guard a critical section like you would with a lock. 
 * 
 * Java 5 comes with semaphore implementations in the java.util.concurrent.Semaphore
 * 
 *  It is useful to understand the concept behind Semaphore implementation.
 * @author sinhama
 * 
 * The take() method sends a signal which is stored internally in the Semaphore.
 * The release() method waits for a signal.
 * When received the signal flag is cleared again, and the release() method exited.
 *
 */

public class A_MyBasicSemaphore {

	private boolean signal = false;

	public synchronized void take() {
		this.signal = true;
		this.notify();
	}

	public synchronized void release() throws InterruptedException{
		while(!this.signal){
			wait();
		}

		this.signal = false;
	}

}

/**
 * Using a semaphore like this you can avoid missed signals. You will call take() instead of notify() and release() instead of wait().
 * 
 * If the call to take() happens before the call to release() the thread calling release() will still know that take() was called, 
 * because the signal is stored internally in the signal variable.
 * 
 * This is not the case with wait() and notify().
 */
