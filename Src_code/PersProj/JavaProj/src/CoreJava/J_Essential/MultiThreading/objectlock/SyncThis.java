package CoreJava.J_Essential.MultiThreading.objectlock;

public class SyncThis {

	public static void main(String args[]){
		
		SynchObj syncobj1 = new SynchObj();
		Trd1 thrd1 =new Trd1(syncobj1);
		Trd2 thrd2 =new Trd2(syncobj1);
		Trd3 thrd3 =new Trd3(syncobj1);
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


class SynchObj {
	
	int n;
	 void mthd1(){
		// synchronized(this){
			 while(true){
				 System.out.println("*********Inside Synch method1***************");
			 }
		// }
	}
	
	synchronized void mthd2(){
		synchronized(this){
			while(true){
				System.out.println("-------------Inside Synch method2------------");
			}
		}
	}

	void mthd3(){
		synchronized(this){
			while(true){
				System.out.println("<<<<<<<<<<<<Inside non synch method3>>>>>>>>>.");
			}
		}
	}

}


class Trd1 implements Runnable {
	
	SynchObj syncobj1 = new SynchObj();
	
	Trd1(SynchObj obj){
		syncobj1=obj;
	}
	
	public void run(){
		syncobj1.mthd1();
	}
}

class Trd2 implements Runnable {
	
	SynchObj syncobj1 = new SynchObj();
	
	Trd2(SynchObj obj){
		syncobj1=obj;
	}
	
	public void run(){
		syncobj1.mthd2();
	}
}

class Trd3 implements Runnable {
	
	SynchObj syncobj1 = new SynchObj();
	
	Trd3(SynchObj obj){
		syncobj1=obj;
	}
	
	public void run(){
		syncobj1.mthd3();
	}
}

