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

public class SequencePrint 
{	
	public static void main(String args[]) throws InterruptedException
	{
		Myrunnable myRunnable = new Myrunnable();	
		Thread thread1 = new Thread(myRunnable);
		Thread thread2 = new Thread(myRunnable);
	
		thread1.setName("Thread1");
		thread2.setName("Thread2");
	
		thread1.start();
		thread2.start();	
	}
}

/*class Myrunnable implements Runnable 
{ 	
	public synchronized void run() {
		
		Thread t = Thread.currentThread();
	    String name = t.getName();
	    int j =0;
	    int i =1;
	    while(true)  
	    { 
	    	if(name.equals("Thread1")){
	    	// System.out.println("Calling odd");	        
	    		System.out.println("Thread1 --> " +j);
	    		try {
					Thread.sleep(100);
					wait();
	    		} catch (InterruptedException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}			
	        	j=j+2;
	        	notify();
	    	}	    	
	    	else{
	    		//System.out.println("Calling Even");
	    		synchronized(this) {
	    			notify();
	    			System.out.println("Thread2 --> " +i);
	    			try {
	    				Thread.sleep(100);
	    				i=i+2;
	    				wait();
	    			} catch (InterruptedException e) {
	    				e.printStackTrace();
	    			}
	       
	    		}
	    	}
	    }// While
		
	 }//run
	
}
*/


class Myrunnable implements Runnable 
{ 	
	public synchronized void run() {
		
		Thread t = Thread.currentThread();
	    String name = t.getName();
	     
	    	if(name.equals("Thread1")){
	    		 printEven();
	    	}	    	
	    	else{
	    		printOdd();
	    	}		
	 }
	
	
	private void printEven()
	{
		int even = 0;
		
		while(true) {
			System.out.println("Thread1 --> " +even);
			notify();
    		try {
				Thread.sleep(100);
				wait();
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}			
    		even = even+2;
        	
		}
	}
	
	private void printOdd()
	{
		int odd = 1;
		
		while(true) {		
			notify();
    		try {
    			Thread.sleep(100);
    			wait();
    			System.out.println("Thread2 --> " +odd);
    							
				
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    		notify();
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
 */
