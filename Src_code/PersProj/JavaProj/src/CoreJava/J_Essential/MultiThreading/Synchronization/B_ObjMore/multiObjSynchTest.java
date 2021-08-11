package CoreJava.J_Essential.MultiThreading.Synchronization.B_ObjMore;

import CoreJava.J_Essential.MultiThreading.Synchronization.SampleObj.SynchronizedCls;
import CoreJava.J_Essential.MultiThreading.Synchronization.ThreadCls.MyRunnable;

/**
 * Objective :
 *  Two Synchronized method on different object can always be called simultaneously by two threads.
 *  Since lock happens on object level, so two different thread gets the lock [by entering into synchronized method] on different object.
 *
 */

public class multiObjSynchTest {
	
	public static void main(String args[]){

		SynchronizedCls syhncObj1 = new SynchronizedCls();
		MyRunnable myRunnable1 = new MyRunnable(syhncObj1);		
		Thread Thread1 = new Thread(myRunnable1);
		Thread1.setName("Thread1");
		
		SynchronizedCls syhncObj2 = new SynchronizedCls();
		MyRunnable myRunnable2 = new MyRunnable(syhncObj2);	
		Thread Thread2 = new Thread(myRunnable2);
		Thread2.setName("Thread2");
				
				
		Thread2.start();
		Thread1.start();
		

	}

}
