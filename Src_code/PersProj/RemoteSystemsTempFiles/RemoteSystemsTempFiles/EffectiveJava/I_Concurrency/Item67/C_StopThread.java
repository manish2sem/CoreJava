package EffectiveJava.I_Concurrency.Item67;

import java.util.concurrent.TimeUnit;

public class C_StopThread {
	private static volatile boolean stopRequested;
	public static void main(String[] args)
			throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (!stopRequested){
					i++;
					System.out.println("Thread is running.. "+i);
				}
			}
		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
}
