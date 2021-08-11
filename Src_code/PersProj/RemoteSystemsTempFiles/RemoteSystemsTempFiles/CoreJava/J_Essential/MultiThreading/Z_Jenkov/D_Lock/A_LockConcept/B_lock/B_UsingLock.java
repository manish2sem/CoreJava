package CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock.A_LockConcept.B_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class B_UsingLock {

	private A_MyLock myLock = new A_MyLock();
	  private int count = 0;

	  public int incremtnt(){
			
	    try {
	    	myLock.lock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    int newCount = ++count;   //Synchronized code
	    
	    myLock.unlock();
	    return newCount;
	  }
}

/**
 * 
 * Anything between lock() and unlock() methods are synchronized.
 */
