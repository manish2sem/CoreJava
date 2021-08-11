package CoreJava.J_Essential.MultiThreading.ExecutorFrmwork.A_CallableEx;

import java.util.concurrent.Callable;

public class MyCallable implements Callable{
	public Long call() throws Exception {
	    long sum = 0;
	    for (long i = 0; i <= 100; i++) {
	      sum += i;
	    }
	    return sum;
	  }
}
