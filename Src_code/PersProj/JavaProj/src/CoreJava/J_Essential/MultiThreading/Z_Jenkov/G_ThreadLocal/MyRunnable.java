package CoreJava.J_Essential.MultiThreading.Z_Jenkov.G_ThreadLocal;

public class MyRunnable implements Runnable{
	private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

	int globalStored;

	@Override
	public void run() {

		int stored = (int) (Math.random() * 100D);
		threadLocal.set(stored);
		globalStored = stored;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}

		System.out.println("threadLocal" +threadLocal.get());
		System.out.println("globalStored " +globalStored);

	}

}
