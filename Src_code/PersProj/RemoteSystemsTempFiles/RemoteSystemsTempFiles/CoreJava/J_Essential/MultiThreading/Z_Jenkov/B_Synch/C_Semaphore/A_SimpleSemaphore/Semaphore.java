package CoreJava.J_Essential.MultiThreading.Z_Jenkov.B_Synch.C_Semaphore.A_SimpleSemaphore;

public class Semaphore {
	private boolean signal = false;

	public synchronized void take() {
		this.signal = true;
		this.notify();
	}

	public synchronized void release() throws InterruptedException{
		while(!this.signal) {
			wait();
		}
		this.signal = false;
	}
}
