package Interview.BT.Thrd;

public class Mainz {

	public static void main(String[] args) {
		myRunable myRunable = new myRunable(1);
		myRunable myRunable2 = new myRunable(2);

		Thread t1 = new Thread(myRunable);
		Thread t2 = new Thread(myRunable2);
		
		t1.run();
		t2.start();
		System.out.println("Main ends");

	}

}
