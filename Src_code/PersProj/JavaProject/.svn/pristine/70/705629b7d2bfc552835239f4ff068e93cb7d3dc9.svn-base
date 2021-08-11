package Interview.MorganStanley.SummingTenTasks.CntDownLatch;

import java.util.concurrent.CountDownLatch;

public class MyRunnable implements Runnable{

	ResultCollectorShared shareResult;
	int count = 0;
	private final CountDownLatch latch;

	public MyRunnable(ResultCollectorShared sharedObj, int count, CountDownLatch latch){
		this.shareResult = sharedObj;
		this.count = count;
		this.latch = latch;
	}

	@Override
	public void run() {
		int sum = 0;
		for (int i=0; i < count; i++) {
			sum = sum + i;
		}
		shareResult.setResult(sum);
		System.out.println("Updating ... " + sum);
		latch.countDown();
	}

}
