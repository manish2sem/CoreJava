package CoreJava.J_Essential.MultiThreading.topics.SleepLock;

public class SharedObj {
	synchronized public void synchLoop(String name) throws InterruptedException{
		while(true){
			System.out.println("Synch Loop : "+name);
			
			if(name.equalsIgnoreCase("Thread4")){
				Thread.sleep(2000);
				wait();
			}else{
				wait();
			}
		//	Thread.yield();
			notifyAll();
		}
	}
	
	public void nonSynchLoop(String name){
		while(true){
			System.out.println("Non-Synch Loop : "+name);
		}
	}
}
