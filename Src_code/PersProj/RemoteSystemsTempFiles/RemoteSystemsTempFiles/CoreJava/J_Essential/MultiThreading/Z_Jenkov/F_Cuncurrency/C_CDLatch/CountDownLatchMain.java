package CoreJava.J_Essential.MultiThreading.Z_Jenkov.F_Cuncurrency.C_CDLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchMain {

	public static void main(String args[]) {
		final CountDownLatch latch = new CountDownLatch(3); //#1
		Thread cacheService = new Thread(new Service("CacheService", 1000, latch));
		Thread alertService = new Thread(new Service("AlertService", 1000, latch));
		Thread validationService = new Thread(new Service("ValidationService", 1000, latch));

		cacheService.start(); //separate thread will initialize CacheService
		alertService.start(); //another thread for AlertService initialization
		validationService.start();

		

		try{
			latch.await();  //#2: main thread is waiting on CountDownLatch to finish
			System.out.println("All services are up, Application is starting now");
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}


/** 
 * Requirement : application should not start processing any thread until all service is up and ready to do there job.
 * Countdown latch is idle choice here, main thread will start with count 3 // and wait until count reaches zero.
 * each thread once up and read will do a count down. 
 * this will ensure that main thread is not started processing  until all services is up.
 * count is 3 since we have 3 Threads (Services)
 */