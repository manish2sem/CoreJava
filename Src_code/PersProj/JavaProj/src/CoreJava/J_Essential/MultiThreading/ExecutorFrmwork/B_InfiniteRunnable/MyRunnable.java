package CoreJava.J_Essential.MultiThreading.ExecutorFrmwork.B_InfiniteRunnable;


public class MyRunnable  implements Runnable{
	public void run() {
		int count = 0;
	    while(true){
	    	System.out.println("count = " +Thread.currentThread().getName() +" " + count++);
	    	if(count>100){
	    		break;
	    	}
	    }
	    
	  }
}
