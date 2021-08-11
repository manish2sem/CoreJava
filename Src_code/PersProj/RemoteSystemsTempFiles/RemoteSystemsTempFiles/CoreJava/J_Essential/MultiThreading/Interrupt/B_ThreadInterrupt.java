package CoreJava.J_Essential.MultiThreading.Interrupt;

/**
 * If the thread is not in the sleeping or waiting state, 
 * calling the interrupt() method performs normal behaviour and
 *  doesn't interrupt the thread but sets the interrupt flag to true. 
 * 
 * @author Manish
 *
 */

public class B_ThreadInterrupt {
	public static void main(String[] args) {
		Thread thread1 = new InterruptedThread1();
		thread1.start();
		thread1.interrupt();
	}
}


class InterruptedThread1 extends Thread{  
	public void run(){  
		while(true){
			System.out.println("runnning");
		}
	}  
}