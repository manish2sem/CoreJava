package Interview.MorganStanley.SummingTenTasks.CyclicBarer;

//import java.util.concurrent.CountDownLatch;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyRunnable implements Runnable{

	ResultCollectorShared shareResult;
	int count = 0;
	//private final CountDownLatch latch;
	CyclicBarrier cb;

	public MyRunnable(ResultCollectorShared sharedObj, int count, CyclicBarrier cb){
		this.shareResult = sharedObj;
		this.count = count;
		this.cb = cb;
		//this.latch = latch;
		
	}

	@Override
	public void run() {
		int sum = 0;
		for (int i=0; i < count; i++) {
			sum = sum + i;
		}
		shareResult.setResult(sum);
		System.out.println("Updating ... " + sum);
		try {
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" I am doneg ... " + Thread.currentThread());
	//	latch.countDown();
	}

}
