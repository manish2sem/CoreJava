package CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock.E_Semaphore.A_Simple;

public class C_RecevingThread implements Runnable{
	
	A_MyBasicSemaphore semaphore = null;

	  public C_RecevingThread(A_MyBasicSemaphore semaphore){
	    this.semaphore = semaphore;
	  }

	  public void run() {
	    while(true){
	      try {
			this.semaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      //receive signal, then do something...
	    }
	  }

}
