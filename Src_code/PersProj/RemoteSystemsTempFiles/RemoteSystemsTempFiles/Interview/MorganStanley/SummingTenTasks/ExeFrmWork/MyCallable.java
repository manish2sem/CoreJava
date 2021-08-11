package Interview.MorganStanley.SummingTenTasks.ExeFrmWork;

import java.util.concurrent.Callable;

public class MyCallable implements Callable{
	
	private final long countUntil;

	MyCallable(long countUntil) {
		this.countUntil = countUntil;
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
