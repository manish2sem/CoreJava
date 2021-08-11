package CoreJava.J_Essential.MultiThreading.Z_Jenkov.A_SharedObj.B_SharedObj;

/**
 * 
 * Notice  the two MyRunnable instances share the same ObjectMember instance. 
 * Therefore, when they call the add() method on the NotThreadSafe instance it leads
 *  to race condition.
 * 
 * However, if two threads call the add() method simultaneously on 
 * different instances then it does not lead to race condition.
 *
 */
public class ThreadSafeNot {
	public static void main(String args[]) throws InterruptedException {
		
		ObjectMember sharedInstance = new ObjectMember();
		
		MyRunnable runObj1 = new MyRunnable(sharedInstance);
		MyRunnable runObj2 = new MyRunnable(sharedInstance);
		
		System.out.println("Before Thread : "+sharedInstance.getBuilder());
		Thread t1 = new Thread(runObj1);
		Thread t2 = new Thread(runObj2);
		t1.start();
		t2.start();
		Thread.sleep(1);
		System.out.println("After Thread : "+sharedInstance.getBuilder());
		
	}
	

}
