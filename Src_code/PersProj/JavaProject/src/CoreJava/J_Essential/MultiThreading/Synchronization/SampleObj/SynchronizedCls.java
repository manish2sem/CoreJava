package CoreJava.J_Essential.MultiThreading.Synchronization.SampleObj;

/**
 * There are all together three kind of methods:
 *  - Synchronized
 *  - Static Synchronized
 *  - Non Synchronized
 *
 */

public class SynchronizedCls {

	synchronized static  public void synchMthd1() throws InterruptedException{		
		while(true){			
			Thread.sleep(100);			
			System.out.println("*********Inside static Synch method1***************");

		}
	}

	synchronized static public void synchMthd2() throws InterruptedException{
		while(true){
			Thread.sleep(100);	
			System.out.println("#################Inside static Synch method2------------");
		}
	}

	synchronized public void mthd3() throws InterruptedException{
		while(true){
			Thread.sleep(100);	
			System.out.println("<<<<<<<<<<<<Inside  synch method3.");
		}
	}

	synchronized public void mthd4() throws InterruptedException{
		while(true){
			Thread.sleep(100);	
			System.out.println(">>>>>>>>>>>>>>> Inside  synch method4.");
		}
	}
	
	 public void mthd5() throws InterruptedException{
		while(true){
			Thread.sleep(100);	
			System.out.println("---------------------Inside non synch method5.");
		}
	}

	 public void mthd6() throws InterruptedException{
		while(true){
			Thread.sleep(100);	
			System.out.println("+++++++++++++++++++Inside non synch method6.");
		}
	}

}
