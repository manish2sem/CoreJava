package Interview.MorganStanley.SynchronizationTest;

public class MyRunnabl implements Runnable{
	SynchCls synchCls;
	int count = 0;
	public MyRunnabl(SynchCls synchCls, int i){
		if(i>3 || i<0){
			System.out.println("Wrong arguments. Exiting...");
			System.exit(0);
		}

		count = i;
		this.synchCls = synchCls;
	}

	@Override
	public void run() {
		try {
			if (count == 1) {
				synchCls.synchMthd1();
			}

			if (count == 2) {
				synchCls.staticSynchMthd2();
			}

			if (count == 3) {
				synchCls.mthd3();
			}
		}catch(InterruptedException ex){
				System.out.println("Exception in Run");
		}
	}

}
