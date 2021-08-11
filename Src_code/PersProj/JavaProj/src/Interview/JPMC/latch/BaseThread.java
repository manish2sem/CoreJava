package Interview.JPMC.latch;

import java.util.concurrent.CountDownLatch;

public class BaseThread extends Thread{
	CountDownLatch cdl;
	public BaseThread(CountDownLatch cdl){
		this.cdl = cdl;		
	}
	
	public void run(){
		try {
			System.out.println("run method");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cdl.countDown();
	}

}
