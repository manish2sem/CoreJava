package CoreJava.J_Essential.MultiThreading.ExecutorFrmwork.E_invoke;

import java.util.concurrent.Callable;

/**
 * The Callable object allows to return values after completion.
 * 
 *
 */

public class MyCallableInvoke implements Callable {
	
	private final long countUntil;

	MyCallableInvoke(long countUntil) {
		this.countUntil = countUntil;
	}

	@Override
	public Long call() {
		long sum = 0;
		for (long i = 0; i <= countUntil; i++) {
			sum += i;
			System.out.println(Thread.currentThread().getName());
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		return sum;
	}

} 


