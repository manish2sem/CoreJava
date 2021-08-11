package CoreJava.J_Essential.MultiThreading.wtnnotify;

/**
 * Thread has to be run infinitely.
 * 		So while loop inside run method.
 * Suspend and resume is controlled by boolean flag.
 * if suspended, thread has to (call) wait();
 * if resumed, make suspend false and notify().
 * 
 *  
 * @author Samrat
 *
 */


public class SuspendResume {
	public static void main(String args[]){

	newThreads myThread1 = new newThreads();	
	Thread threadOne = new Thread(myThread1, "Thread1");
	threadOne.start();
	newThreads myThread2 = new newThreads();
	Thread threadTwo = new Thread(myThread2, "Thread2");
	threadTwo.start();
	newThreads myThread3 = new newThreads();	
	Thread threadThree = new Thread(myThread1, "Thread3");
	threadThree.start();
//	myThread.mysuspend();
	
    try {
    	myThread1.mysuspend();//Thread1 will be suspended
		Thread.sleep(1000);
		myThread2.myresume();
		myThread2.mysuspend();// Thread2 will be suspended. At this moment both the threads would be suspended. after 10 sec Thread1 will resume.
		Thread.sleep(1000);
		myThread1.myresume();

	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
}

class newThreads implements Runnable {
	boolean suspendFlag;
	
	newThreads(){
		
	}
	
	public void run(){
		while(true){
			System.out.println("Inside run  : " +Thread.currentThread());
			synchronized(this){
				if (suspendFlag){
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		}
	}
	
	
	 void mysuspend() {
		    suspendFlag = true;
	 }

	 synchronized void myresume() {
		    suspendFlag = false;
		    notify();
	 }	
	
}
