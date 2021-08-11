package CoreJava.J_Essential.MultiThreading.ThreadIntrection;

/**
 * Impeutas :
 * 
 * Problem :
 * 		Create two threads, one will print odd no.[1,3,5,7..], and other should print Even[2,4,6,8].
 * 		But two treads run sequentially.
 * 		So output -> [1,2,3,4,5,6,7,8].
 * @author sinhama
 *
 */

public class SequencePrintVer3 
{	
	public static void main(String args[]) throws InterruptedException
	{
		MyrunnableVer3 myRunnable = new MyrunnableVer3();	
		Thread thread1 = new Thread(myRunnable);
		Thread thread2 = new Thread(myRunnable);

		thread1.setName("Thread1");
		thread2.setName("Thread2");

		thread1.start();
		thread2.start();	
	}
}


class MyrunnableVer3 implements Runnable 
{ 	
	volatile boolean semaphore = false;
	public void run() {

		Thread t = Thread.currentThread();
		String name = t.getName();

		if(name.equals("Thread1"))
		{
			printEven();
		}	    	
		else{
			printOdd();
		}		
	}


	private void printEven()
	{
		int even = 0;
		System.out.println("Inside PrintEven " );

		//System.out.println("Thread1 --> " +even);

		if (!semaphore){
			synchronized(this)
			{			
				System.out.println("Thread1 --> " +even);
				notify();
				semaphore=true;
				even = even+2;
			}
		}

		while(true) {
			synchronized(this)
			{
				System.out.println("Thread1 --> " +even);
				try {
					notify();
					Thread.sleep(100);
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
				even = even+2;
			}

		}
	}

	private void printOdd()
	{
		int odd = 1;
		System.out.println("Inside PrintOdd " );
		if (!semaphore){
			synchronized(this){

				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		while(true) {	

			System.out.println("Thread2 --> " +odd);
			synchronized(this){
				notify();

				try {
					Thread.sleep(100);    			
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			odd = odd + 2;

		}

	}
}


/**
 * Solution Logic : A very tricky Question. 
 *  	Best for concept of wait() and notify(). 
 * run logic -> based on thread [running] printEven and printOdd is called.
 * 		run is synchronized because it calls method which uses wait() and notify(). and they must be called from synchronized block.
 * 
 * Inside PrintOdd 
Inside PrintEven 
Thread1 --> 0
Thread2 --> 1
Thread1 --> 2
Thread2 --> 3
Thread1 --> 4
Thread2 --> 5


 *  
 */
