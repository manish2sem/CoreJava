package CoreJava.J_Essential.MultiThreading.topics.SleepLock;

public class mainz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedObj sharedObj = new SharedObj();
		Myrunnable1 myrunnable1 = new Myrunnable1(sharedObj);
		Myrunnable2 myrunnable2 = new Myrunnable2(sharedObj);
		
		Thread trd1 = new Thread(myrunnable1);
		trd1.setName("Thread1");
		Thread trd2 = new Thread(myrunnable1);
		trd2.setName("Thread2");
		
		Thread trd3 = new Thread(myrunnable1);
		trd3.setName("Thread3");
		
		Thread trd4 = new Thread(myrunnable2);
		trd4.setName("Thread4");
		Thread trd5 = new Thread(myrunnable2);
		trd5.setName("Thread5");
		
		Thread trd6 = new Thread(myrunnable2);
		trd6.setName("Thread6");
		
		//trd1.start();
		//trd2.start();

		//trd3.start();

		trd4.start();
		trd5.start();
		trd6.start();



	}

}
