package Interview.MorganStanley.SummingTenTasks.CyclicBarer;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
/**
 * Currently Not used.
 * @author sinhama
 *
 */
public class MyCallable implements Callable{
	
	private final long countUntil;
	CyclicBarrier cb;

	MyCallable(long countUntil, CyclicBarrier cb) {
		this.countUntil = countUntil;
		this.cb = cb;
	}

	@Override
	public Long call() {
		long sum = 0;
		for (long i = 0; i <= countUntil; i++) {
			sum += i;
			System.out.println(Thread.currentThread().getName());			
		}
		return sum;
	}

}
