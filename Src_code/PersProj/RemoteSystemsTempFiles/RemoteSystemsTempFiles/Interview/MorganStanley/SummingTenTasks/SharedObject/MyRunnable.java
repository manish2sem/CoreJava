package Interview.MorganStanley.SummingTenTasks.SharedObject;

public class MyRunnable implements Runnable{
	
	ResultCollectorShared shareResult;
	int count = 0;
	public MyRunnable(ResultCollectorShared sharedObj, int count){
		this.shareResult = sharedObj;
		this.count = count;
	}

	@Override
	public void run() {
		int sum = 0;
		for (int i=0; i < count; i++) {
			sum = sum + i;
		}
		shareResult.setResult(sum);
		System.out.println("Updating ... " + sum);
		ResultCollectorShared.incrX();
	}

}
