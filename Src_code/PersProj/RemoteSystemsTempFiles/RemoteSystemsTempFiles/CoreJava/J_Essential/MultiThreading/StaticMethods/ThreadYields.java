package CoreJava.J_Essential.MultiThreading.StaticMethods;

/**
 *@author Manish
 *
 * To understand yield(), you must understand the concept of thread priorities.
 *
 * public static void yield() : 
 * make the currently running thread head back to runnable to allow other threads of the same priority to get their turn.
 * In reality, though, the yield() method isn't guaranteed to do what it claims, and 
 * even if yield() does cause a thread to step out of running and back to runnable, 
 * there's no guarantee the yielding thread won't just be chosen again over all the others.
 * 
 *
 */

public class ThreadYields {
	
	public static void main(String [] args) {
		System.out.println("Pick a number between 1 and 100...");
		Thread player1 = new GuessANumber(85);
		Thread player2 = new GuessANumber(85);
		Thread player3 = new GuessANumber(85);
		player3.setPriority(Thread.MAX_PRIORITY);
		player1.start();
		player2.start();
		player3.start();
	}
}	
	





/*
 * The player3 thread hogs the CPU until it is finished executing. After the player3 thread
is done, player1 and player2 politely take turns guessing numbers because each one calls
yield() after each guess. The output of YieldDemo will be similar on any platform, whether
or not time slicing is used.
If you want player3 to actually give up the CPU for lower-priority threads, player3 can
sleep for a short amount of time. You use the sleep() method in the Thread class to cause
the currently running thread to sleep:
*/


