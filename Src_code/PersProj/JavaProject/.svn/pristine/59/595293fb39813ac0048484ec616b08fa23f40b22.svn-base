package CoreJava.J_Essential.MultiThreading.volatileEx;

public class VolatileTest {
	public static void main(String[] args) throws InterruptedException {
		Myrunnable myrunnable = new Myrunnable();
		Thread t1 = new Thread(myrunnable);
		Thread t2 = new Thread(myrunnable);
		Thread t3 = new Thread(myrunnable);
		Thread t4 = new Thread(myrunnable);
		Thread t5 = new Thread(myrunnable);
		Thread t6 = new Thread(myrunnable);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();

	}

}

class Myrunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Singalton singalton1 = Singalton.getInstance();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
