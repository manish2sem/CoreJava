package CoreJava.J_Essential.MultiThreading.Synchronization.C_ClasSyhnc;

import CoreJava.J_Essential.MultiThreading.Synchronization.SampleObj.SynchronizedCls;
import CoreJava.J_Essential.MultiThreading.Synchronization.ThreadCls.MyRunnable;
/**
 * Objective :
 
	 *  Two static Synchronized method can never be called [Even on different objects] simultaneously by two threads.
	 *  static Synchronized method locks the class object.
	 *  
	 *  every class loaded in Java has a corresponding instance of java.lang.Class representing that class. 
	 *  It's that java.lang.Class instance whose lock is used to protect the static methods of the class.
	 *  
	 *  Since lock happens on class-object, at any time there and Synchronized static locks the class object.method 
	 *  so two different thread gets the lock [by entering into synchronized method] on different object.
	 */ 
public class ClsSynchTest {
	

	public static void main(String args[]){

		
		MyRunnable myRunnable1 = new MyRunnable(new SynchronizedCls());		
		Thread Thread1 = new Thread(myRunnable1);
		Thread1.setName("Thread5");		
		
		MyRunnable myRunnable2 = new MyRunnable(new SynchronizedCls());	
		Thread Thread2 = new Thread(myRunnable2);
		Thread2.setName("Thread6");
				
		Thread1.start();
		Thread2.start();
		

	}

}
