package Interview.MorganStanley.SummingTenTasks.CntDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MainCls {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int NO_TASK = 10;
		ResultCollectorShared sharedObject = new ResultCollectorShared();
		List<Thread> ThreadPool = new ArrayList<Thread>();
		final CountDownLatch latch = new CountDownLatch(NO_TASK);
		
		System.out.println("Calculating Total ...  ");
		
		//Creating 10 tasks
		for(int i = 0; i < NO_TASK; i++) {
			int randomno = (int) (Math.random() * 10 + i); // 0.0 < Math.random() <1.0
			ThreadPool.add(new Thread(new MyRunnable(sharedObject, randomno, latch)));
		}
		
		//Starting 10 tasks
		for(int i = NO_TASK-1; i >= 0; i--) {
			ThreadPool.get(i).start();
		}
		
		//Waiting for the completion of 10 tasks
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int total = 0; 
		
		//Calculating the sum of 10 tasks.
		for (int i = 0; i < NO_TASK; i++ ) {
			total = total + sharedObject.getResult().get(i);
			System.out.println("Partial Total :  " + total);
		}

		System.out.println("Total is " + total);
	}

}

/**
 * 
 * Improvement:
 * 	Replace busy waiting with wait() notify().
 * 
 */
