package CoreJava.J_Essential.MultiThreading.Interrupt;

/**
 * If the thread is not in the sleeping or waiting state, 
 * calling the interrupt() method performs normal behaviour and
 *  doesn't interrupt the thread but sets the interrupt flag to true. 
 *  
 *  calling the interrupt() method sets the interrupted flag to true 
 *  that can be used to stop the thread by the java programmer later.
 * 
 *  methods provided by the Thread class for thread interruption.
 *  	- public void interrupt()
		- public static boolean interrupted()
		- public boolean isInterrupted()
 * @author Manish
 *
 */

public class C_ThreadInterrupt {
	public static void main(String[] args) {
		Thread thread1 = new InterruptedThread2();
		thread1.start();
		thread1.interrupt();
	}
}


class InterruptedThread2 extends Thread{  
	int count=0;
	public void run(){  
		while(true){
			count++;
			System.out.println("runnning");
			if(isInterrupted()){  
				break;  
			} 
			/*if(Thread.interrupted()){  
				break;  
			} */ 
		}
		System.out.println("Thread completed - " +count);
	}  
}