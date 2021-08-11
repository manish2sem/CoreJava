package CoreJava.J_Essential.MultiThreading.Z_Jenkov.F_Cuncurrency.C_CDLatch;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import org.apache.log4j.Level;

/**
 * http://javarevisited.blogspot.in/2012/07/countdownlatch-example-in-java.html
 * @author sinhama
 *
 */

class Service implements Runnable{
	private final String name;
	private final int timeToStart;
	private final CountDownLatch latch;

	public Service(String name, int timeToStart, CountDownLatch latch){
		this.name = name;
		this.timeToStart = timeToStart;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeToStart);
		} catch (InterruptedException ex) {
			//  Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println( name + " is Up");
		latch.countDown(); //reduce count of CountDownLatch by 1
	}

}


