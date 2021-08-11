package CoreJava.J_Essential.MultiThreading.Basic;

/**
 * Defining a Thread : 
 * Extend the java.lang.Thread class.
 * 	 Override the run() method.
 * 
 * Implementing java.lang.Runnable
 * 
 * Remember, every thread of execution begins as an instance of class Thread.
 * Regardless of whether your run() method is in a Thread subclass or a Runnable implementation class.
 * 
 * If you implement Runnable, to have code run by a separate thread, you still need a Thread instance.
 * 
 * If you create a thread using the no-arg constructor, the thread will call its own run() method when it's time to start working. 
 * 	- That's exactly what you want when you extend Thread, 
 * But when you use Runnable, you need to tell the new thread to use your run()method rather than its own. 
 * The Runnable you pass to the Thread constructor is called the target or the target Runnable.
 * 
 * Starting a Thread   : t.start();
 * Prior to calling start() on a Thread instance, the thread is said to be in the new state as we said. 
 * 	-The new state means you have a Thread object but you don't yet have a true thread. 
 * So what happens after you call start()?
 * 		- A new thread of execution starts (with a new call stack). 
 * 		- The thread moves from the new state to the runnable state.
 * 		- When the thread gets a chance to execute, its target run() method will run.
 * 
 * Remember You start a Thread, not a Runnable. You call start() on a Thread instance, not on a Runnable instance. 
 * 
 * BURN IN MIND :
 *  - Every thread of execution begins as an instance of class Thread. It doesn't matter if it extends Thread or implements Runnable.
 *  - You call start() on a Thread instance, not on a Runnable instance. 
 *  - Remember, Even class Thread implement Runnable
 *  	class Thread implements Runnable {}
 * 

 *
 */

public class B_TestThreads {
	public static void main (String [] args) {
		MyRunnable r = new MyRunnable();

		Thread foo = new Thread(r); //*Remember every thread of execution begins as an instance of class Thread.
		Thread bar = new Thread(r); //  to have code run by a separate thread, you still need a Thread instance.
		Thread bat = new Thread(r);
		Thread tst = new Thread(r);
		//	foo.start();
		//	bar.start();
		bat.start();
		tst.start();
	}

}

class MyRunnable implements Runnable {
	//synchronized public void run() {
	public void run() {

		while(true){
			System.out.println("Important job running in MyRunnable " +Thread.currentThread().getName());
		}
	}
}



