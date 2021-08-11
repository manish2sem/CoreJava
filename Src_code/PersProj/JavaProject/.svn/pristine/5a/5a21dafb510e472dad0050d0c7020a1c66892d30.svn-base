package EffectiveJava.I_Concurrency.Item67;

import java.util.concurrent.TimeUnit;


/**
 * How long would you expect this program to run?
 * 
 *  this program may run for about a second.
 *  after which the main thread sets stopRequested to true, 
 *  causing the background thread’s loop to terminate.
 *  Sometimes this program never terminates: 
 *  the background thread loops forever!
 * 
 * In the absence of synchronization, there is no guarantee as to when,
 * if ever, the background thread will see the change 
 * in the value of stop-Requested that was made by the main thread.
 *
 */
public class A_StopThread {
	private static boolean stopRequested;
	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!stopRequested){
					i++;
					System.out.println("Thread is running.. "+i);
				}
			}
		});
		
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
		System.out.println("main terminated.");

	}
}

/**
 * the virtual machine to transform this code:
		while (!done)
		i++;
into this code:
		if (!done)
			while (true)
			i++;
 */