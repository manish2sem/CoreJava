package CoreJava.J_Essential.MultiThreading.Z_Jenkov.F_Cuncurrency.C_CYclicBarrier.OtherEx;

import java.util.concurrent.CyclicBarrier;

public class TechLead extends Thread {

	CyclicBarrier cyclicBarrier;
	int timeToSleep = 0;

	public TechLead(CyclicBarrier cyclicBarrier, String name, int time) {
		super(name);
		this.cyclicBarrier = cyclicBarrier;
		timeToSleep = time;

	}

	@Override
	public void run() {

		try {
			Thread.sleep(timeToSleep);
			System.out.println(Thread.currentThread().getName() + " recruited developer");
			System.out.println(Thread.currentThread().getName() + " waiting for others to complete....");
			cyclicBarrier.await();			
			System.out.println("All finished recruiting, " + Thread.currentThread().getName()
					+ " gives offer letter to candidate");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


/**
 * cyclicBarrier.await() 
 * When this method is called the current thread which called this method will go into waiting state and
 * will wake up or come to runnable only when all parties in out case 3 parties have call the await() method.
 * 
 */

