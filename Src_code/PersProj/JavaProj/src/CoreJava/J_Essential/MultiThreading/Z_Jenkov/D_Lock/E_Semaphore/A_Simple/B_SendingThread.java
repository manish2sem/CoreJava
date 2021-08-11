package CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock.E_Semaphore.A_Simple;

public class B_SendingThread implements Runnable{
	A_MyBasicSemaphore semaphore = null;

	public B_SendingThread(A_MyBasicSemaphore semaphore){
		this.semaphore = semaphore;
	}

	public void run(){
		while(true){
			System.out.println("//do something, then signal");
			this.semaphore.take();
		}
	}
}
