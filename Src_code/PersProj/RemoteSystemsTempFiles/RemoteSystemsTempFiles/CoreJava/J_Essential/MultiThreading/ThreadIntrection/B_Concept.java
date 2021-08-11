package CoreJava.J_Essential.MultiThreading.ThreadIntrection;

public class B_Concept {
	public static void main(String [] args) {
		ThreadB threadObj = new ThreadB();
		threadObj.start();
		
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		 
		 synchronized(threadObj) {
			try {
				while(true){
					System.out.println("***********Waiting for A to complete********* :  " +Thread.currentThread().getName());				
					threadObj.wait();
					Thread.sleep(1000);
				}

			  } catch (InterruptedException e) {}
			  	System.out.println("############Main Terminating ############# " );
			 }
	}

}


class ThreadB extends Thread { 
	
	public synchronized void run() {
		int count = 0;
		while (true) {
			count++;
			System.out.println("Inside class  ThreadA : " + count);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				 notify();
				 if (count>10 )
					 break;
		}
		 
	 }
}