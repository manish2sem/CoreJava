package CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock.C_ReentrantLock;


public class ReentrantLockTest {

	public static void main(String[] args) {
		ReentrantLockUse reentrantCls = new ReentrantLockUse();
		MyThread myThread = new MyThread(reentrantCls);
		myThread.start();
	}
}

class MyThread extends Thread {
	ReentrantLockUse someObj;
	public MyThread(){

	}

	public MyThread(ReentrantLockUse someObj){
		this.someObj = someObj;
	}


	public void run() {
		try {
			someObj.outer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}


