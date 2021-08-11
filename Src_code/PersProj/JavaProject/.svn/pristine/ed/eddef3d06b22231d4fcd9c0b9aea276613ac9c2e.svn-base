package CoreJava.J_Essential.MultiThreading.Z_Jenkov.B_Synch.A_Synchronization;

public class A_SynchEx {

	public synchronized void method1(){
		while (true) {
			System.out.println("Inside method1");
		}
	}

	public static synchronized  void method2(){
		while (true) {
			System.out.println("Inside method1");
		}
	}
	
	//This is similar to method 1
	public void method3(){
		synchronized (this){
			while (true) {
				System.out.println("Inside method1");
			}
		}
	}
	
	//This is similar to method 2
	public static void method4(){
		synchronized (A_SynchEx.class){
			while (true) {
				System.out.println("Inside method1");
			}
		}
	}
	
	// What about this?? no statis method but synchronized on class object.
	public void method5(){
		synchronized (A_SynchEx.class){
			while (true) {
				System.out.println("Inside method1");
			}
		}
	}
	
	/**
	 * The synchronized mechanism was Java's first mechanism for synchronizing access to objects shared by multiple threads. 
	 * The synchronized mechanism isn't very advanced though. 
	 * That is why Java 5 got a whole set of concurrency utility classes to help developers implement more fine grained concurrency control than what you get with synchronized. 
	 */

}
