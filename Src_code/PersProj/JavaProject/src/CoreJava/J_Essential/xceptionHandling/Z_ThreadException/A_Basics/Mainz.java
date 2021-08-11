package CoreJava.J_Essential.xceptionHandling.Z_ThreadException.A_Basics;

public class Mainz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread mythread = new Thread(new MyThread());
		mythread.start();
		System.out.println("Exiting main!!");

	}

}
