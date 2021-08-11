package CoreJava.J_Essential.xceptionHandling.Z_ThreadException.A_Basics;

public class CatchThreadException {
	
	


	public static void main(String[] args) {
		
		Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
		    public void uncaughtException(Thread th, Throwable ex) {
		        System.out.println("Uncaught exception: " + ex);
		    }
		};
		
		
		Thread mythread = new Thread(new MyThread());
		
		mythread.setUncaughtExceptionHandler(h);
		mythread.start();
		System.out.println("Exiting main!!");
		
		System.out.println(h.toString());
	}

}
