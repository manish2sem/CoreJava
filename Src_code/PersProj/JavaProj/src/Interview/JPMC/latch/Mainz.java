package Interview.JPMC.latch;

import java.util.concurrent.CountDownLatch;

public class Mainz {
	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(5);
		
		Thread thrd1 = new Thread(new BaseThread(cdl));
		
		cdl.countDown();
		cdl.countDown();
		cdl.countDown();
		cdl.countDown();
		thrd1.start();
	//	thrd1.start();
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Done");
	}

}
