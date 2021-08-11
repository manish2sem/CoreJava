package Interview.MorganStanley.SummingTenTasks.SharedObject;

import java.util.ArrayList;
import java.util.List;

public class MainCls {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		ResultCollectorShared sharedObject = new ResultCollectorShared();
		List<Thread> ThreadPool = new ArrayList<Thread>();
		
		System.out.println("Calculating Total ...  ");
		
		//Creating 10 tasks
		for(int i = 0; i < 10; i++) {
			int randomno = (int) (Math.random() * 100 + i); // 0.0 < Math.random() <1.0
			ThreadPool.add(new Thread(new MyRunnable(sharedObject, randomno)));
		}
		
		//Starting 10 tasks
		for(int i = 9; i >= 0; i--) {
			ThreadPool.get(i).start();
		}
		
		//Waiting for the completion of 10 tasks
		while (ResultCollectorShared.getX() < 10) {
			// busy waiting
		}
		int total = 0; 
		
		//Calculating the sum of 10 tasks.
		for (int i = 0; i < ResultCollectorShared.getX(); i++ ) {
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
