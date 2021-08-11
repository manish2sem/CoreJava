package CoreJava.J_Essential.MultiThreading.wtnnotify.Sum;

/**
 * A thread does the task for sum of 1000 nos.
 * Main thread need to wait till thread completes. 
 */

public class CalculateSum {
	public static void main(String args[]){
		ThreadSum sum = new ThreadSum();
		sum.start();
		
		dummyObj dummyObj = new dummyObj();
			
		synchronized(sum){ //code synchronizes itself with the object sum —this is because in order to call wait() on the object, CalculateSum must own a lock on b.
			try {
				System.out.println("Waiting for sum to complete...");
				/**
				 * CalculateSum will continue with the next line of code i.e. for "int total=sum.total;"; in its own class, 
				 * which means it could get to printing total before sum has finished the calculation. 
				 * To prevent this, we use the wait()
				 */
				
				sum.wait();											//Wait is called on object sum
				synchronized(dummyObj){
					System.out.println("Waiting for dummy to complete...");
					dummyObj.wait();
					System.out.println(" dummy to completed");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}	
		int total=sum.total;			
		System.out.println("Total : = " +total);
	}
}


class ThreadSum extends Thread{
	int total;
	public void run () {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		synchronized(this){
		for (int i=0; i<100; i++){
				total = total + i;
		}
			/**
			 * As soon as calculation completes we notify waiting thread.
			 */
			notify();									//notify is called on object sum as it is defined on class of object sum.
		}
	}	
} 

class dummyObj{
	
}

/**
 * The methods wait() and notify(), are instance methods of Object.
 * In the same way that every object has a lock, every object can have a list of threads that are waiting for a signal 
 * (a notification) from the object.
 * A thread gets on this waiting list by executing the wait() method of the target object.
 * From that moment, it doesn't execute any further instructions until the notify() method of the target object is called. 
 * If many threads are waiting on the same object, only one will be chosen (in no guaranteed order) to proceed with its execution. 
 * If there are no threads waiting, then no particular action is taken. * 
 * 
 * 	- wait(), notify(), and notifyAll() must be called from within a synchronized context! 
 * 	- A thread can't invoke a wait or notify method on an object unless it owns that object's lock.
 * 
 * When the thread waits, it temporarily releases the lock for other threads to use, but it will need it again to continue execution.
 */
