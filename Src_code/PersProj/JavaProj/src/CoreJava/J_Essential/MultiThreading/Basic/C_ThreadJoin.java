package CoreJava.J_Essential.MultiThreading.Basic;
/**
 * public final void join(long millisec). 
 * The current thread invokes this method on a second thread, 
 * causing the current thread to block until the second thread terminates
 */

public class C_ThreadJoin {
	public static void main (String [] args) {
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
		
		System.out.println("**** Main thread exting in 5 sec ****");
		try {
			Thread.sleep(5000);
			System.out.println("**** Main thread exting ****");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

	/*
	class MyThread extends Thread {
		public void run() {
			while(true){
				System.out.println("Important job running in MyThread : " +Thread.currentThread().getName());
			}
		}
	}*/