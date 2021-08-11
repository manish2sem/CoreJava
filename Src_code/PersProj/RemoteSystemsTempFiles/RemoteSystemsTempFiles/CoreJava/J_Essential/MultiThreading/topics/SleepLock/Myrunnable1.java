package CoreJava.J_Essential.MultiThreading.topics.SleepLock;

public class Myrunnable1 implements Runnable{
	SharedObj sharedObj;
	public Myrunnable1(SharedObj sharedObj){
		this.sharedObj = sharedObj;
	}
	@Override
	public void run() {
		
		sharedObj.nonSynchLoop(Thread.currentThread().getName());
	}

}
