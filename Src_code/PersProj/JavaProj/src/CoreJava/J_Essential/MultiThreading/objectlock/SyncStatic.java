package CoreJava.J_Essential.MultiThreading.objectlock;

/**
 * 
 * @author Manish
 * static methods can be synchronized.
 * There is such a lock; every class loaded in Java has a corresponding instance of java.lang.Class representing that class.
 * It's that java.lang.Class instance whose lock is used to protect the static methods of the class
 *
 */

public class SyncStatic {

	public static void main(String args[]){
		
		StaticSyncObj syncobj1 = new StaticSyncObj();
		
		ThrdStatic1 thrd1 =new ThrdStatic1(syncobj1);
		ThrdStatic2 thrd2 =new ThrdStatic2(syncobj1);
		ThrdStatic3 thrd3 =new ThrdStatic3(syncobj1);
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


class StaticSyncObj {
	
	int n;
	static synchronized void  mthd1(){
		while(true){
			System.out.println("*********Inside Synch method1***************");
		}
	}
	
	/**
	 * what's that StaticSyncObj.class thing? That's called a class literal. 
	 * It's a special feature in the Java language that tells the compiler (who tells the JVM): 
	 * go and find me the instance of Class that represents the class called StaticSyncObj.
	 */
	
	static void mthd2(){
		synchronized(StaticSyncObj.class){
			while(true){
				System.out.println("-------------Inside Synch method2------------");
			}
		}
	}

	synchronized void mthd3(){
		while(true){
			System.out.println("<<<<<<<<<<<<Inside non synch method3>>>>>>>>>.");
		}
	}

}


class ThrdStatic1 implements Runnable {
	
	StaticSyncObj syncobj1 = new StaticSyncObj();
	
	ThrdStatic1(StaticSyncObj obj){
		syncobj1=obj;
	}
	
	public void run(){
		syncobj1.mthd1();
	}
}

class ThrdStatic2 implements Runnable {
	
	StaticSyncObj syncobj1 = new StaticSyncObj();
	
	ThrdStatic2(StaticSyncObj obj){
		syncobj1=obj;
	}
	
	public void run(){
		syncobj1.mthd2();
	}
}

class ThrdStatic3 implements Runnable {
	
	StaticSyncObj syncobj1 = new StaticSyncObj();
	
	ThrdStatic3(StaticSyncObj obj){
		syncobj1=obj;
	}
	
	public void run(){
		syncobj1.mthd3();
	}
}

