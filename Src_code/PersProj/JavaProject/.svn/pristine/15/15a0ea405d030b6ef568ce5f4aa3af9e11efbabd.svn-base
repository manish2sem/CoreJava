package CoreJava.J_Essential.MultiThreading.wtnnotify.Sum;

/**
 * A thread does the task for sum of 1000 nos.
 * Main thread need to wait till thread completes. 
 */

public class CalculateSumJoin {
	public static void main(String args[]){
		ThreadSum2 sum = new ThreadSum2();
		sum.start();
	/*		
		synchronized(sum){ //code synchronizes itself with the object sum—this is because in order to call wait() on the object, CalculateSum must own a lock on b.
			try {
				System.out.println("Waiting for sum to complete...");
				
				sum.wait();											//Wait is called on object sum
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}	
		*/
		try {
			//System.out.println("Waiting for sum to complete...");

			sum.join(1990);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		int total=sum.total;			
		System.out.println("Total : = " +total);
	}
}


class ThreadSum2 extends Thread{
	int total;
	public void run () {
		try {
			Thread.sleep(2000);
		//	notify();
		//	Thread.sleep(2000);

		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
	//	synchronized(this){
		for (int i=0; i<100; i++){
				total = total + i;
		}
			/**
			 * As soon as calculation completes we notify waiting thread.
			 */
		//	notify();									//notify is called on object sum as it is defined on class of object sum.
		//}
	}	
} 

/**
 * How join replaces wait()/notify().
 * 
 * 
 * 
 */
