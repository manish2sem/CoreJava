package CoreJava.J_Essential.MultiThreading.topics.join;


/**
 * join makes the current thread wait for the completion of specified thread.
 * For example inside main if you call A.join(), the main thread will wait until thread A finishes.
 *
 */

public class TrickyJoin {
	
	public static void main(String [] args) {
		
		Thread t1 = new MyTrickyThread();		
		Thread t2 = new MyTrickyThread(t1);
		Thread t3 = new MyTrickyThread(t2);
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}

}


class MyTrickyThread extends Thread {
	
	Thread mustFinishFirst;
	
	MyTrickyThread(Thread t){
		mustFinishFirst = t;
	}
	
	MyTrickyThread(){
		
	}
	
	public void run() {
		
		if(mustFinishFirst != null) {
			try {
				mustFinishFirst.join();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		
		for (int i=1000; i>0; i--){
			System.out.println(Thread.currentThread().getName() + "  count : " + i );	
			
		}
	}
}

/**
 * Explanation:
 *  t1.start() -> execute the run() method.
 *  t2.start() -> execute the run() method(After setting mustFinishFirst=t1). 
 *  				Consequently t1.join is called.
 *  			So with the definition of join the current thread(t2) will wait for t1 to finish.
 *  
 *  t3.start() -> execute the run() method(After setting mustFinishFirst=t2). 
 *  				Consequently t2.join is called.
 *  			So with the definition of join the current thread(t3) will wait for t2 to finish.
 *  
 *  And this ensure the order. T1<--T2<--T3. 
 *  
 */


