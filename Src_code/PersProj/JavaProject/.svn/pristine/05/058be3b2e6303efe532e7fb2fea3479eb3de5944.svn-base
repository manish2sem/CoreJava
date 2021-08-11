package CoreJava.J_Essential.MultiThreading.Z_Jenkov.A_SharedObj.A_Basics;

public class B_ThreadRunnable {
	public static void main(String[] args) {

		MyRunnable runnable = new MyRunnable();
		Thread thread = new Thread(runnable, "New Thread");  

		thread.start();
		System.out.println(thread.getName());
		System.out.println(Thread.currentThread().getName());

	}
}

class MyRunnable implements Runnable {

	public void run(){
		
		System.out.println("MyRunnable running");
	}
}
