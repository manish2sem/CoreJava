package CoreJava.J_Essential.MultiThreading.topics.join;

import CoreJava.J_Essential.MultiThreading.StaticMethods.GuessANumber;

/**
 * public final void join(long millisec). 
 * The current thread invokes this method on a second thread, 
 * causing the current thread to block until the second thread terminates
 */

public class ThreadJoin {
	
	public static void main(String [] args) {
		System.out.println("Starting thread2 ...");
		Thread thread2 = new GuessANumber(27); //GuessANumber is defined at ThreadYields.java
		Thread thread1 = new GuessANumber(27); //GuessANumber is defined at ThreadYields.java
		thread2.setName("thread2");
		thread1.setName("thread1");
		thread1.start();
		thread2.start();
		try
		{
			thread2.join();
		}catch(InterruptedException e)
		{
			
		}
		System.out.println("Starting thread3...");
		Thread thread3 = new GuessANumber(75);
		thread3.setName("thread3");
		thread3.start();
		System.out.println("main() is ending...");
	}
}

/*
 * There are a total of four threads involved. (Don’t forget the thread that main() executes in.)
 * The main() thread invokes join() on thread2. This causes main() to block until thread2 finishes, 
 * which is an indefinite amount of time because thread3 runs until it guesses the number 27.
 * 
 * While main() is waiting for thread2, there are two runnable threads: thread1 and thread2.
 * 
 * When thread2 terminates, main() becomes runnable again and starts thread3. 
 * Then main() ends and its thread dies, leaving thread1(if not dead), and thread4 as the remaining runnable threads of the process.
 * 
 * thread1 and thread3 runs until it guesses the number 27 and 75. This causes the process to terminate.
*/
