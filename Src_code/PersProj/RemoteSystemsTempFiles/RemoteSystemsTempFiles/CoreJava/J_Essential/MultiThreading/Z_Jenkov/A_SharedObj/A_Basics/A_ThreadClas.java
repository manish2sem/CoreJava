package CoreJava.J_Essential.MultiThreading.Z_Jenkov.A_SharedObj.A_Basics;

/**
 * Notice the string "Cls Thread" passed as parameter to the Thread constructor.
 *  This string is the name of the thread.
 *  The name can be obtained by the Thread's getName() method.
 *  
 *  Currently executing THREAD'S name  can be obtained  by 
 *  Thread.currentThread().getName(); 
 * @author sinhama
 *
 */

public class A_ThreadClas  extends Thread {

	String name; 
	public A_ThreadClas (String thrdName){
		this.name = thrdName;
	}
	public void run(){
		System.out.println("MyThread running"); 
	}
	
	public static void main(String[] args) {
		A_ThreadClas myThread = new A_ThreadClas("Cls Thread");
		myThread.start();
		System.out.println(myThread.getName());
	}
}

