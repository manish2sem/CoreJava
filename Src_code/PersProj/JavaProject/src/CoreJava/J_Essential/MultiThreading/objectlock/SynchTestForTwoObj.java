package CoreJava.J_Essential.MultiThreading.objectlock;
/*
 * 
 * Here two threads are called on two objects so ...
 * 
 */

public class SynchTestForTwoObj {
	
	public static void main(String args[]){
	
	SynObj syncobj1 = new SynObj();
	SynObj syncobj2 = new SynObj();
	Thred4 thrd4 =new Thred4(syncobj1);
	Thred5 thrd5 =new Thred5(syncobj2);
	
	Thread t1=new Thread(thrd4);		
	t1.start();

	Thread t2=new Thread(thrd5);		
	t2.start();	
	}
}

class Thred4 implements Runnable {
	
	SynObj syncobj1;
	
	Thred4(SynObj obj){
		syncobj1=obj;
	}
	
	public void run(){
		synchronized (syncobj1){
			syncobj1.mthd1();
		}
	}
}


class Thred5 implements Runnable {
	
	SynObj syncobj1;
	
	Thred5(SynObj obj){
		syncobj1=obj;
	}
	
	public void run(){
		synchronized (syncobj1){
			syncobj1.mthd3();
		}
	}
	
}
