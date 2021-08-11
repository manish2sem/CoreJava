package CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock.C_ReentrantLock;

public class ReentrantLockUse {
	
	ReentrantLock myLock = new ReentrantLock();
	
	public void outer() throws InterruptedException{
		System.out.println("Inside Outer before getting Lock");
		myLock.lock();
		inner();
		System.out.println("Processing Outer");
		myLock.unlock();
		System.out.println("Leaving Outer");
	}

	public void inner() throws InterruptedException{
		System.out.println("Inside Inner before getting Lock");
		myLock.lock();
		System.out.println("Processing Inner");
		myLock.unlock();
		System.out.println("Leaving Inner");
	}

}
