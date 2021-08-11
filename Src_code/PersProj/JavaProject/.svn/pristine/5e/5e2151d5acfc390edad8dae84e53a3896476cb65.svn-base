package CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock.C_ReentrantLock;


public class ReentrantLock {
	private boolean isLocked = false;
	Thread lockedBy = null;

	public void lock() throws InterruptedException{
		Thread callingTrd = Thread.currentThread();
		while(isLocked  && lockedBy!=callingTrd){
			synchronized(this){
				wait();
			}
		}
		isLocked = true;
		lockedBy = callingTrd;
	}

	public void unlock(){
		if(Thread.currentThread() == this.lockedBy){
			isLocked = false;
			synchronized(this){  //Because wait/notify are called inside synchronized method only.
				notify();
			}
		}
	}

}
