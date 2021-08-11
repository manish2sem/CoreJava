package CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock.E_Semaphore.A_Simple;

public class Main_UsingSemaphore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A_MyBasicSemaphore semaphore = new A_MyBasicSemaphore();

		B_SendingThread sender = new B_SendingThread(semaphore);

		C_RecevingThread receiver = new C_RecevingThread(semaphore);
		
		Thread senderThread = new Thread(sender);
		Thread receiverThread = new Thread(receiver);

		senderThread.start();
		receiverThread.start();
	}

}
