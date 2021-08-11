package CoreJava.J_Essential.MultiThreading.topics.SleepLock;

public class Myrunnable2 implements Runnable{
	SharedObj sharedObj;
	public Myrunnable2(SharedObj sharedObj){
		this.sharedObj = sharedObj;
	}
	@Override
	public void run() {
		try {
			sharedObj.synchLoop(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
