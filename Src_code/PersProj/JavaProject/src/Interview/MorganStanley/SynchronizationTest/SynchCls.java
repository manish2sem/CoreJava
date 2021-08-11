package Interview.MorganStanley.SynchronizationTest;

public class SynchCls {
	synchronized public void synchMthd1() throws InterruptedException{		
		while(true){			
			Thread.sleep(100);			
			System.out.println("*********Inside Synch method1*******************" + Thread.currentThread());

		}
	}

	synchronized static public void staticSynchMthd2() throws InterruptedException{
		while(true){
			Thread.sleep(100);	
			System.out.println("#################Inside static Synch method2------------"  + Thread.currentThread());
		}
	}

	public void mthd3() throws InterruptedException{
		while(true){
			Thread.sleep(100);	
			System.out.println("+++++++++++++++++++Inside non synch method3." + Thread.currentThread());
		}
	}

}
