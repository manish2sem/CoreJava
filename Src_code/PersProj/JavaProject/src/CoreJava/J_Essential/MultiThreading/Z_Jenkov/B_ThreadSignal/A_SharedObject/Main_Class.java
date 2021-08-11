package CoreJava.J_Essential.MultiThreading.Z_Jenkov.B_ThreadSignal.A_SharedObject;


/**
 * A simple way for threads to send signals to each other is by setting the signal values in some shared object(MySignal) variable. 
 * threadA may set the boolean member variable hasDataToProcess to true from inside a synchronized block, and thread B(main thread) may read the hasDataToProcess member variable,  also inside a synchronized block. 
 *  
 *  Thread A and B must have a reference to a shared MySignal instance for the signaling to work. 
 *  If thread A and B has references to different MySignal instance, they will not detect each others signals. 
 * @author sinhama
 * 
 * main thread need to wait for a signal from threadA which causes hasDataToProcess() to return true.
 * main thread checks for the signal by running a loop. 
 * Loop keeps executing until hasDataToProcess() returns true. 
 * This is called busy waiting. The thread is busy while waiting.
 *
 */
public class Main_Class {
	public static void main(String[] args) {
		MySignal signal = new MySignal();

		MyRunnable runnableCls = new MyRunnable(signal);

		Thread threadA = new Thread(runnableCls);

		threadA.start();
        
		int count =0;
		//Busy Wait
		while(!signal.hasDataToProcess()){
			//do nothing... busy waiting
			//System.out.println("busy waiting ... " + count);
			count++;

		}
		System.out.println("Got the result in main " + count);
	}
}


/**
 * 
 * Busy waiting is not a very efficient utilization of the CPU in the computer running the waiting thread, except if the average waiting time is very small. 
 * Else, it would be smarter if the waiting thread could somehow sleep or become inactive until it receives the signal it is waiting for.
 *
 * Java has a built-in wait mechanism that enable threads to become inactive while waiting for signals.
 * The class java.lang.Object defines three methods, wait(), notify(), and notifyAll(), to facilitate this.
*/