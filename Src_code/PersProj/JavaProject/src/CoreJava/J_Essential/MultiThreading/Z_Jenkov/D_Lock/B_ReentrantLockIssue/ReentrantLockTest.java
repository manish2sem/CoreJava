package CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock.B_ReentrantLockIssue;


public class ReentrantLockTest {

	public static void main(String[] args) {
		ReentrantLockIssue reentrantCls = new ReentrantLockIssue();
		MyThread myThread = new MyThread(reentrantCls);
		myThread.start();
	}
}

class MyThread extends Thread {
	ReentrantLockIssue someObj;
	public MyThread(){

	}

	public MyThread(ReentrantLockIssue someObj){
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


