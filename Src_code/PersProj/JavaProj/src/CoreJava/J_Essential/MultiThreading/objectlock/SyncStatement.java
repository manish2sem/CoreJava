package CoreJava.J_Essential.MultiThreading.objectlock;

public class SyncStatement {

	public static void main(String args[]){
		
		SynObj syncobj1 = new SynObj();
		Thred1 thrd1 =new Thred1(syncobj1);
		Thred2 thrd2 =new Thred2(syncobj1);
		Thred3 thrd3 =new Thred3(syncobj1);
		//SyncObj syncobj2 = new SyncObj();

		//Thrd2 thrd2 =new Thrd2(syncobj2);
		//SyncObj syncobj3 = new SyncObj();

		//Thrd3 thrd3 =new Thrd3(syncobj3);
		Thread t3=new Thread(thrd3);		
			t3.start();
		
		Thread t1=new Thread(thrd1);		
			t1.start();
		
		Thread t2=new Thread(thrd2);		
			t2.start();	
		
		
	}
}


class SynObj {
	
	int n;
	void mthd1(){
		while(true){
			System.out.println("*********Inside Synch method1***************");
		}
	}
	
	void mthd2(){
		while(true){
			System.out.println("-------------Inside Synch method2------------");
		}
	}

	void mthd3(){
		while(true){
			System.out.println("<<<<<<<<<<<<Inside non synch method3>>>>>>>>>.");
		}
	}

}


class Thred1 implements Runnable {
	
	SynObj syncobj1 = new SynObj();
	
	Thred1(SynObj obj){
		syncobj1=obj;
	}
	
	public void run(){
		synchronized (syncobj1){
			syncobj1.mthd1();
		}
	}
}

class Thred2 implements Runnable {
	
	SynObj syncobj1 = new SynObj();
	
	Thred2(SynObj obj){		
		syncobj1=obj;		
	}
	
	public void run(){
	//	synchronized (syncobj1){
			syncobj1.mthd2();
		}
	//}
}

class Thred3 implements Runnable {
	
	SynObj syncobj1 = new SynObj();
	
	Thred3(SynObj obj){
		syncobj1=obj;
	}
	
	public void run(){
		synchronized (syncobj1){
			syncobj1.mthd3();
		}
	}
}

