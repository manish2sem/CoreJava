package CoreJava.J_Essential.MultiThreading.StaticMethods;
/**
 * The sleep() method is a static method of class Thread. 
 * Notice that the sleep() method can throw a checked InterruptedException.
 *  (you'll usually know if that is a possibility, since another thread has to explicitly do the interrupting)
 *  Sleep is usually used to "slow a thread down" by forcing it to go into a sleep mode before coming back to runnable

Just because a thread’s sleep() expires, and it wakes up, does not mean
it will return to running! Remember, when a thread wakes up, it simply goes back to
the runnable state. So the time specified in sleep() is the minimum duration in which
the thread won’t run, but it is not the exact duration in which the thread won’t run.
 * @author Manish
 *
 */

public class ThreadSleep {
	public static void main (String [] args) {
		// Make one Runnable
		NameRunnable nr = new NameRunnable();
		Thread one = new Thread(nr);
		one.setName("Fred");
		Thread two = new Thread(nr);
		two.setName("Lucy");
		Thread three = new Thread(nr);
		three.setName("Ricky");
		one.start();
		two.start();
		three.start();
	}
}


class NameRunnable implements Runnable {
	public void run() {
		for (int x = 1; x < 4; x++) {
			System.out.println("Run by " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) { }
		}
	}
}

/*
the behavior in the preceding output is still not guaranteed.
You can't be certain how long a thread will actually run before it gets put to sleep,
so you can't know with certainty that only one of the three threads will be in the
runnable state when the running thread goes to sleep. In other words, if there are
two threads awake and in the runnable pool, you can't know with certainty that
the least recently used thread will be the one selected to run.
*/