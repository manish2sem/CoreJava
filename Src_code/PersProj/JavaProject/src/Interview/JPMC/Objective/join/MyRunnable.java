package Interview.JPMC.Objective.join;

public class MyRunnable implements Runnable{
    int sleepTime;
    
    public MyRunnable(int sleepTime){
    	this.sleepTime = sleepTime;
    }
	@Override
	public void run() {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread done");
	}	

}
