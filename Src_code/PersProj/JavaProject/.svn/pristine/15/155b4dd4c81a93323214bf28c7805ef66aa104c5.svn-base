package CoreJava.J_Essential.MultiThreading.objectlock;

/**
 * 
 * @author Manish
 *Every object in Java has a built-in lock that only comes into play when the object has synchronized method code.
 *When we enter a synchronized non-static method, we automatically acquire the lock associated with the current instance of the class
 *Since there is only one lock per object, if one thread has picked up the lock, 
 *		no other thread can pick up the lock until the first thread releases the lock.
 *This means no other thread can enter the synchronized code (which means it can't enter any synchronized method of that object) until
 *	 the lock has been released
 *
 *	-Only methods (or blocks) can be synchronized, not variables or classes. 
 *	-Each object has just one lock.
 *	-Not all methods in a class need to be synchronized.
 *	-A thread can acquire more than one lock.
 *
 *
 *notify() join() sleep() and yield() Keep Locks
 *wait() Give Up Locks
 */
public class ObjLock {
	public static void main(String args[]){
		
		SyncObj syncobj1 = new SyncObj();
		Thrd1 myRunnable1 =new Thrd1(syncobj1);
		Thrd2 myRunnable2 =new Thrd2(syncobj1);
		Thrd3 myRunnable3 =new Thrd3(syncobj1);
		//SyncObj syncobj2 = new SyncObj();

		//Thrd2 thrd2 =new Thrd2(syncobj2);
		//SyncObj syncobj3 = new SyncObj();

		//Thrd3 thrd3 =new Thrd3(syncobj3);
		Thread t1=new Thread(myRunnable1);
		
		
		t1.start();
		Thread t3=new Thread(myRunnable2);
		t3.start();
		
		Thread t2=new Thread(myRunnable3);
		t2.start();	
		
	}
}


class SyncObj {
	
	int n;
	/*
	synchronized void mthd1(){
		while(true){
			System.out.println("*********Inside Synch method1***************");
		}
	}
	*/
	
	synchronized void mthd1(){		
			while(true){
				try{
					Thread.sleep(10);
				}catch (Exception e){
					System.out.println("Exxxxxxxxxxx");
				}
				System.out.println("*********Inside Synch method1***************");
			
		}
	}
	
	synchronized void mthd2(){
		while(true){
			System.out.println("-------------Inside Synch method2------------");
		}
	}

	 void mthd3(){
		while(true){
			System.out.println("<<<<<<<<<<<<Inside non synch method3.");
		}
	}

}


class Thrd1 implements Runnable {
	
	//SyncObj syncobj1 = new SyncObj();
	
	SyncObj syncobj1;
	
	Thrd1(SyncObj obj){
		syncobj1=obj;
	}
	
	public void run(){
		syncobj1.mthd1();

		try{
			Thread.sleep(5000);
		}catch (Exception e){
			System.out.println("Exxxxxxxxxxx");
		}
		//syncobj1.mthd1();
	}
}

class Thrd2 implements Runnable {
	
	SyncObj syncobj1 = new SyncObj();
	
	Thrd2(SyncObj obj){
		syncobj1=obj;
	}
	
	public void run(){
		syncobj1.mthd2();
	}
}

class Thrd3 implements Runnable {
	
	SyncObj syncobj1 = new SyncObj();
	
	Thrd3(SyncObj obj){
		syncobj1=obj;
	}
	
	public void run(){
		syncobj1.mthd3();
	}
}

