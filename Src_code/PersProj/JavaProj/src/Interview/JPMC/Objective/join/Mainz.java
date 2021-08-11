package Interview.JPMC.Objective.join;
/**
 * Correct
 * @author Manish
 *
 */
public class Mainz {

	public static void main(String[] args) {
		MyRunnable runnable = new MyRunnable(5000);
		Thread t1 = new Thread(runnable);
		
		MyRunnable runnable1 = new MyRunnable(8000);
		Thread t2 = new Thread(runnable1);
		
		t2.start();
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done with main");
	}

}
