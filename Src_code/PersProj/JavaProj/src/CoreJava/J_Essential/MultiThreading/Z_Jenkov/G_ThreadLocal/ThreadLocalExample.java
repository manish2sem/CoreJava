package CoreJava.J_Essential.MultiThreading.Z_Jenkov.G_ThreadLocal;

public class ThreadLocalExample {
	public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

       /* try {
			thread1.join();
	        thread2.join(); //wait for thread 2 to terminate
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} *///wait for thread 1 to terminate
        
        System.out.println("Exiting Main");
    }
}
