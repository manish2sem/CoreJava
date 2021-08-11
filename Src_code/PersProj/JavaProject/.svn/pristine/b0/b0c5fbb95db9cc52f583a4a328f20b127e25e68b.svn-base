package CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock;


/**
 * A lock is a thread synchronization mechanism like synchronized blocks except locks can be more sophisticated than Java's synchronized blocks. 
 * Locks (and other more advanced synchronization mechanisms) are created using synchronized blocks.
 * @author sinhama
 *
 */
public class A1_LockConcept {
	public class B_MyLock {

	}
	private int count = 0;

	public int synchInc(){
		synchronized(this){
			return ++count;
		}
	}


	private Lock lock = new Lock();
	public int lockInc() throws InterruptedException{
		lock.lock();
		int newCount = ++count;
		lock.unlock();
		return newCount;
	}

}

//The lock() method locks the Lock instance so that all threads calling lock() are blocked until unlock() is executed. 
class Lock{

	private boolean isLocked = false;

	public synchronized void lock() throws InterruptedException{
		while(isLocked){
			wait();
		}
		isLocked = true;
	}

	public synchronized void unlock(){
		isLocked = false;
		notify();
	}
}
/**
 * Notice the "spin lock" while(isLocked) loop. 
 * While isLocked is true, the thread calling lock() is parked waiting in the wait() call. 
 * In case the thread should return unexpectedly(Spurious Wakeup) from the wait() call without having received a notify() call,
 * the thread re-checks the isLocked condition to see if it is safe to proceed or not, rather than just assume that being awakened means it is safe to proceed.
 * If isLocked is false, the thread exits the while(isLocked) loop, and sets isLocked back to true, to lock the Lock instance for other threads calling lock(). 
 * 
 */
