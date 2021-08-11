package CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock.B_ReentrantLockIssue;

import CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock.A_LockConcept.B_lock.A_MyLock;

/**
 * This code does not behave as reentrant because of one issue in A_MyLock.
 * 
 * A thread calling outer() will first lock the Lock instance. 
 * Then it will call inner(). Inside the inner() method the thread will again try to lock the Lock instance. 
 * This will fail (and the thread will be blocked), since the Lock instance was locked already in the outer() method. 
 * The reason the thread will be blocked the second time it calls lock() without having called unlock() in between.
 * See the code of A_MyLock for clear picture if not clear.
 * @author sinhama
 *
 */

public class ReentrantLockIssue {
	
	A_MyLock myLock = new A_MyLock();
	
	/*public void outer() throws InterruptedException{
		System.out.println("Inside Outer before getting Lock");
		myLock.lock();
		inner();
		myLock.unlock();
		System.out.println("Inside Outer");
	}

	public synchronized void inner() throws InterruptedException{
		System.out.println("Inside Inner before getting Lock");
		myLock.lock();
		System.out.println("Inside Inner");
		myLock.unlock();
	}*/
	
	public void outer() throws InterruptedException{
		System.out.println("Inside Outer before getting Lock");
		Thread.sleep(100);
		myLock.lock();
		inner();
		System.out.println("Processing Outer");
		myLock.unlock();
		System.out.println("Leaving Outer");
	}

	public void inner() throws InterruptedException{
		System.out.println("Inside Inner before getting Lock");
		myLock.lock();
		System.out.println("Processing Inner");
		myLock.unlock();
		System.out.println("Leaving Inner");
	}

}
