package Interview.MorganStanley.SummingTenTasks.CyclicBarer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainCls {
		
	public static void main(String[] args) {
		
		int NO_TASK = 10;
		ResultCollectorShared sharedObject = new ResultCollectorShared();
		List<Thread> ThreadPool = new ArrayList<Thread>();
		CyclicBarrier cb = new CyclicBarrier(NO_TASK, new BarrierClass(sharedObject));
	//	final CountDownLatch latch = new CountDownLatch(NO_TASK);
		
		System.out.println("Calculating Total ...  ");
		
		//Creating 10 tasks
		for(int i = 0; i < NO_TASK; i++) {
			int randomno = (int) (Math.random() * 10 + i); // 0.0 < Math.random() <1.0
			ThreadPool.add(new Thread(new MyRunnable(sharedObject, randomno, cb)));
		}
		
		//Starting 10 tasks
		for(int i = NO_TASK-1; i >= 0; i--) {
			ThreadPool.get(i).start();
		}
		
		/*//Waiting for the completion of 10 tasks
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int total = 0; 
		
		//Calculating the sum of 10 tasks.
		for (int i = 0; i < NO_TASK; i++ ) {
			total = total + sharedObject.getResult().get(i);
			System.out.println("Partial Total :  " + total);
		}

		System.out.println("Total is " + total);*/
	}

}

/**
 * CyclicBarrier understanding :
 *  commented parts are code of countDownLatch.
 *  
 *  Step1: Instance of CyclicBarrier is created.
 *  		CyclicBarrier cb = new CyclicBarrier(NO_TASK, new BarrierClass(sharedObject));
 *  	- BarrierClass is a runnable object which run(automatically) when all the await() methods are called. i.e. all the dependent tasks are done.
 *      - The instance of this BarrierClass is shared among every tasks.
 *      - In this particular BarrierClass constructor sharedObject is passed, because
 *      	I have to get the value of each task and I am using runnable(in case of callable sharedObject teachnique) can be avoided.
 *      
 *  Step2: Creating Sub-tasks
 *  	- Each Sub-tasks are runnable object which accepts CyclicBarrier in their constructor.
 *  	- in run method of subtasks, await() method of CyclicBarrier is called.
 *      - at this point (when await) is called each subtasks wait for other tasks to finish.
 *      Say we have 3 tasks- T1, T2, T3. T1 reaches first to its await() method so it will wait for others(T2, T3's) await() to finish.
 *      Once all await is done, CyclicBarrier Run method is called.
 *      Once CyclicBarrier Run method completes then All the tasks will resume from the point of await().
 * 
 * 
 */
