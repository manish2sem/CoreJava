package CoreJava.J_Essential.MultiThreading.Z_Jenkov.B_ThreadSignal.A_SharedObject;

public class MyRunnable implements Runnable{
	
	MySignal signal = null;
	
	public MyRunnable(MySignal signalRef) {
		this.signal = signalRef;
	}

	@Override
	public void run() {
		
		System.out.println("Processing data using " + Thread.currentThread().getName() + "...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		signal.setHasDataToProcess(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("I am done");
	}
	

}
