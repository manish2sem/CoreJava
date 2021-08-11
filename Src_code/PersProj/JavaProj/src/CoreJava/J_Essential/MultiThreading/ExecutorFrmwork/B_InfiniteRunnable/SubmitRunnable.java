package CoreJava.J_Essential.MultiThreading.ExecutorFrmwork.B_InfiniteRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * submit() method takes a Runnable or Callable implementation, and returns a Future object. 
 * Callable's result can be obtained via future.get().
 * In case of Runnable future.get() returns null if the task has finished correctly. 
 */
public class SubmitRunnable {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		List<Future> list = new ArrayList<Future>();
	    for (int i = 0; i < 12; i++) {
	      Future submit = executor.submit(new MyRunnable());
	      list.add(submit);
	    }
	    
	    for (Future future : list) {
	        try {
	           if(future.get()!=null){
	        	   continue;
	           }
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        } catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	      }
	    
	    System.out.println("Last Statement in Main");
				
	}

}
