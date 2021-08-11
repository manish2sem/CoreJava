package Interview.MorganStanley.SynchronizationTest;

public class MainCls {
	public static void main(String[] args) {
		SynchCls object1 = new SynchCls();
		SynchCls object2 = new SynchCls();
		
		Thread T1 = new Thread(new MyRunnabl(object1, 1));
		Thread T2 = new Thread(new MyRunnabl(object2, 1));
		Thread T3 = new Thread(new MyRunnabl(object1, 2));
		Thread T4 = new Thread(new MyRunnabl(object2, 2));
		Thread T5 = new Thread(new MyRunnabl(object1, 3));
		Thread T6 = new Thread(new MyRunnabl(object2, 3));
		
		T1.start();
		T2.start();
		T3.start();
		T4.start();
		T5.start();
		T6.start();
	}

}
