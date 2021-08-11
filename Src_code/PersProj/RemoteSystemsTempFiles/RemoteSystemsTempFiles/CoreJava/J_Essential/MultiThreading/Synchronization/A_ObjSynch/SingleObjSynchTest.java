package CoreJava.J_Essential.MultiThreading.Synchronization.A_ObjSynch;

import CoreJava.J_Essential.MultiThreading.Synchronization.SampleObj.SynchronizedCls;
import CoreJava.J_Essential.MultiThreading.Synchronization.ThreadCls.MyRunnable;

/**
 * Tread name are set because they are hard-coded in run method [of MyRunnable],
 * and based of Thread-name different methods of SynchronizedCls is called.
 * 
 * Note, here only object of  SynchronizedCls is created and al three threads work on same object.
 * 
 * Objective :
 *  Two Synchronized method on same object can not be called simultaneously by two threads.
 *  If one thread occupies one synchronized method, it has to finish the execution (i.e. copmlete the method execution), then only
 *  second thread enters the another synchronized method. 
 * @author sinhama
 *
 */
public class SingleObjSynchTest {

	public static void main(String args[]){

		SynchronizedCls syhncObj = new SynchronizedCls();
		MyRunnable myRunnable = new MyRunnable(syhncObj);
		
		Thread Thread1 = new Thread(myRunnable);
		Thread1.setName("Thread1");
		Thread Thread2 = new Thread(myRunnable);
		Thread2.setName("Thread2");
		
		Thread Thread3 = new Thread(myRunnable);
		Thread3.setName("Thread3");
		
		Thread2.start();
		Thread1.start();
		Thread3.start();

	}


}

/*

*/