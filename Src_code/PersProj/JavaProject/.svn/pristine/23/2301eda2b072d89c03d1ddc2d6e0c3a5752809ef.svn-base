package CoreJava.J_Essential.MultiThreading.topics.join;

/**
 * Threads always run with some priority, usually represented as a number between 1 and 10. 
 * The scheduler in most JVMs uses preemptive, priority-based scheduling (some sort of time slicing). 
 * This does not mean that all JVMs use time slicing.
 * 
 * the scheduler does use thread priorities in one important way: 
 * If a thread enters the runnable state, and it has a higher priority than any of the threads in the pool and
 * a higher priority than the currently running thread, the lower-priority running thread usually will be
 * bumped back to runnable and the highest-priority thread will be chosen to run.
 * 
 * thread-scheduling priority behavior is not guaranteed
 * What is also not guaranteed is the behavior when threads in the pool are of equal priority.
 * 
 * Default priority is 5. Thread class has the three following constants (static final variables)
 * Thread.MIN_PRIORITY (1) 
 * Thread.NORM_PRIORITY (5)
 * Thread.MAX_PRIORITY (10)
 * 
 */

public class ThreadPriority {
	public static void main (String [] args) {
		// Make one Runnable
		NewRunnable nr = new NewRunnable();
		Thread one = new Thread(nr);
		one.setName("Fred");
		one.setPriority(Thread.MIN_PRIORITY);
		Thread two = new Thread(nr);
		two.setName("Lucy");
		two.setPriority(Thread.MAX_PRIORITY);
		Thread three = new Thread(nr);
		three.setName("Ricky");
		three.setPriority(Thread.NORM_PRIORITY);
		one.start();
		two.start();
		three.start();
	}

}

class NewRunnable implements Runnable {
	public void run() {
		for (int x = 1; x < 10; x++) {
			System.out.println("Run by " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) { }
		}
	}
}

