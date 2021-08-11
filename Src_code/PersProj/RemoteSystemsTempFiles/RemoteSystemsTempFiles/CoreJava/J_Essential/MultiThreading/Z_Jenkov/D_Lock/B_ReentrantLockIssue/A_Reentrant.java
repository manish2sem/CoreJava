package CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock.B_ReentrantLockIssue;


/**
 * Synchronized blocks in Java are reentrant.
 * This means, that if a Java thread enters a synchronized block of code, 
 * and thereby take the lock on the monitor object the block is synchronized on, 
 * the thread can enter other Java code blocks synchronized on the same monitor object. 
 * See ReentrantCls.
 * 
 * Making sense, since object is locked by same thread it can access any synchronized method of that object.
 *
 */

public class A_Reentrant {

	public static void main(String[] args) {
		ReentrantCls reentrantCls = new ReentrantCls();
		MyThread1 myThread = new MyThread1(reentrantCls);
		myThread.start();
		System.out.println("Main exit");
	}
}

class MyThread1 extends Thread {
	ReentrantCls someObj;
	
	public MyThread1(){

	}

	public MyThread1(ReentrantCls someObj){
		this.someObj = someObj;
	}


	public void run() {
		someObj.outer();
		System.out.println("Thread exit");
	}
}

class ReentrantCls {

	public synchronized void outer(){
		inner();
		System.out.println("Inside Outer");
	}

	public synchronized void inner(){
		System.out.println("Inside Inner");
	}
}

/**
 * If a thread calls outer() there is no problem calling inner() from inside outer(), since both methods (or blocks) are synchronized on the same monitor object.
 * This is called reentrance. The thread can reenter any block of code for which it already holds the lock. 
 */

