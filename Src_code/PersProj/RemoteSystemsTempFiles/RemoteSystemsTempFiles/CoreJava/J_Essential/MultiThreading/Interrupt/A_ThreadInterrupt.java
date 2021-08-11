  package CoreJava.J_Essential.MultiThreading.Interrupt;

/**
 *  interrupt() method is a non-static public method of java.lang.Thread class.
 * 		public void interrupt()
 *
 * Thread interruption is a mechanism in which 
 * a thread which is either sleeping or waiting
 *  can be made to stop sleeping or waiting. 
 *  
 *  InterruptedException is thrown 
 *  	when a thread is interrupted 
 *  	while it is sleeping or waiting. 
 * @author Manish
 *
 */
public class A_ThreadInterrupt {

	public static void main(String[] args) {
		Thread t = new Thread(){
			public void run(){
				System.out.println("Thread is going to sleep ...");
				try	{
					Thread.sleep(10000);        //Thread is sleeping for 10 seconds
					System.out.println("Wakeup thread ...");
				}

				catch (InterruptedException e){
					System.out.println("Thread is interrupted");
				}
				
				
				
				System.out.println("Bye bye thread ...");
			}
		};

		t.start();

		try	{
			Thread.sleep(3000);      //Main thread is sleeping for 3 seconds
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}

		t.interrupt();         //main thread is interrupting thread t
		System.out.println("Bye bye Main ...");

	}


}

/**
 *  main thread is creating and starting thread t. 
 *  Thread t is going to sleep for 10 seconds as soon as it started. 
 *  main thread, after starting thread t, is also going to sleep for 3 seconds.
 *  After sleeping for 3 seconds, main thread calls interrupt() method on thread t.
 *  It interrupts sleeping thread t. It causes the InterruptedException.
 *  And so thread t return to running status.
 * 
 * 
 */
