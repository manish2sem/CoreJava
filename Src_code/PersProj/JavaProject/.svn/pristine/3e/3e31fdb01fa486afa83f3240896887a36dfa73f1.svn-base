package CoreJava.J_Essential.MultiThreading.Basic;

/**
 * Defining a Thread : 
 * Extend the java.lang.Thread class.
 * 	 Override the run() method. * 
 * Implementing java.lang.Runnable
 * 
 * Extend the java.lang.Thread class.
 * The limitation with this approach (besides being a poor design choice in most cases) 
 * is that if you extend Thread, you can't extend anything else.
 * 
 * 
 * Remember, every thread of execution begins as an instance of class Thread.
 * Regardless of whether your run() method is in a Thread subclass or a Runnable implementation class.
 * 
 * A thread is done being a thread when its target run() method completes.
 * Once a thread has been started, it can never be started again.
 * The order in which runnable threads are chosen to run is not guaranteed.
 *
 */

public class A_ExtendThrd {

	public static void main (String [] args) {
		MyThread t1 = new MyThread(); 			//every thread of execution begins as an instance of class Thread.
		MyThread t2 = new MyThread();
		Thread t3 = new Thread();

		/*Thread foo = new Thread(r);
		Thread bar = new Thread(r);
		Thread bat = new Thread(r);*/
		/*foo.start();
		bar.start();
		bat.start();*/
		t1.start();
		t2.start();
	}

}

class MyThread extends Thread {
	SomeObj someObj;
	public MyThread(){

	}

	public MyThread(SomeObj someObj){
		this.someObj = someObj;
	}


	public void run() {
		while(true){
			System.out.println("Important job running in MyThread : " +Thread.currentThread().getName());
		}
	}
	/**	
	you're free to overload the run() method in your Thread subclass.
	 * The overloaded run(String s) method will be ignored by the Thread class unless you call it yourself. 
	 * The Thread class expects a run() method 	with no arguments, and 
	 * it will execute this method for you in a separate call stack after the thread has been started. 
	 * With a run(String s) method, the Thread 	class won't call the method for you, and 
	 * even if you call the method directly yourself,
	 * 		execution won't happen in a new thread of execution with a separate call stack. 
	 * 		It will just happen in the same call stack as the code that you made the call from, just like any other normal method call.	
	 */

	public void run(String s) {
		while(true){
			System.out.println("Important job running in MyThread overloaded" +s);
		}
	}
}

class SomeObj{}