package CoreJava.J_Essential.MultiThreading.ExecutorFrmwork.D_CallableExecute;

import java.util.concurrent.Callable;

/**
 * The Callable object allows to return values after completion.
 * 
 *
 */

public class MyCallable implements Callable<Long> {
	@Override
	public Long call() {
		long sum = 0;
		for (long i = 0; i <= 100; i++) {
			sum += i;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sum;
	}

} 


