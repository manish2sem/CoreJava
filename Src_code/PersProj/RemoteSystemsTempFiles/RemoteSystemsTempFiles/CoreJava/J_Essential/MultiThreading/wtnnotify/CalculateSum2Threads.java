package CoreJava.J_Essential.MultiThreading.wtnnotify;

public class CalculateSum2Threads {
	
	public static void main(String args[]){
		ThreadSumTwo sum1 = new ThreadSumTwo(10);
		ThreadSumTwo sum2 = new ThreadSumTwo(5);
		sum1.start();
		sum2.start();
		
		/*synchronized(sum2){ //code synchronizes itself with the object sum—this is because in order to call wait() on the object, CalculateSum must own a lock on b.
			try {
				System.out.println("Waiting for sum to complete...");
				*//**
				 * CalculateSum will continue with the next line of code i.e. for "int total=sum.total;"; in its own class, 
				 * which means it could get to printing total before sum has finished the calculation. 
				 * To prevent this, we use the wait()
				 *//*
				//sum1.wait();				//Wait is called on object sum
				sum2.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}	*/
		/*try {
			Thread.sleep(0);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		int totalSum1=sum1.total;	
		int totalSum2=sum2.total;
		System.out.println("Total : = " +totalSum1);
		System.out.println("Total : = " +totalSum2);
	}

}


class ThreadSumTwo extends Thread{
	int total;
	int max;
	ThreadSumTwo(int max){
		this.max=max;
	}
	
	synchronized public void run () {
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
			for (int i=1; i<=max; i++){
				total = total + i;
			}
			
			//* As soon as calculation completes we notify waiting thread.			 
			//notifyAll();		//notify is called on object sum as it is defined on class of object sum.		
	}	
} 
