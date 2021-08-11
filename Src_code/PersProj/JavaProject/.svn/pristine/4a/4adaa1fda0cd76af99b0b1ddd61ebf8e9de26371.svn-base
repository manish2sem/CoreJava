package CoreJava.J_Essential.MultiThreading.Synchronization.D_Mixed;

import CoreJava.J_Essential.MultiThreading.Synchronization.SampleObj.SynchronizedCls;
import CoreJava.J_Essential.MultiThreading.Synchronization.ThreadCls.MyRunnable;

public class MixtureSynchTest {
	
public static void main(String args[]){

		SynchronizedCls myObj = new SynchronizedCls();		
		MyRunnable myRunnable = new MyRunnable(myObj);
		
		Thread Thread1 = new Thread(myRunnable);		
		Thread1.setName("Thread1");
		
		Thread Thread3 = new Thread(myRunnable);		
		Thread3.setName("Thread3");	
		
		Thread Thread5 = new Thread(myRunnable);		
		Thread5.setName("Thread5");	
		
		
				
		Thread3.start();
		Thread1.start();
		Thread5.start();
		

	}

}
