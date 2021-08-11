package CoreJava.J_Essential.MultiThreading.objectlock;

public class HerbertStyleSync {
	
	public static void main(String args[]){
		
		SynObj syncobj1 = new SynObj();
		SynObj syncobj2 = new SynObj();
		new ThredHerb1(syncobj1);
		new ThredHerb2(syncobj2);
		
		
	}

}


class ThredHerb1 implements Runnable {
	
	SynObj syncobj1;
	Thread t;

	
	ThredHerb1(SynObj obj){
		syncobj1=obj;	
		 t = new Thread(this, "Thread1");
		 System.out.println("Child thread: " + t);
		 t.start(); 
	}
	
	public void run(){
		synchronized (syncobj1){
			syncobj1.mthd1();
		}
	}
}

class ThredHerb2 implements Runnable {
	
	SynObj syncobj1;
	Thread t;
	
	ThredHerb2(SynObj obj){		
		syncobj1=obj;	
		 t = new Thread(this, "Thread1");
		 System.out.println("Child thread: " + t);
		 t.start(); 
	}
	
	public void run(){
		synchronized (syncobj1){
			syncobj1.mthd2();
		}
	}
}

class ThredHerb3 implements Runnable {
	
	SynObj syncobj1;
	Thread t;
	ThredHerb3(SynObj obj){
		syncobj1=obj;	
		 t = new Thread(this, "Thread1");
		 System.out.println("Child thread: " + t);
		 t.start(); 
	}
	
	public void run(){
		synchronized (syncobj1){
			syncobj1.mthd3();
		}
	}
}

