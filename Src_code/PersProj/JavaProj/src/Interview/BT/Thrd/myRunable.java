package Interview.BT.Thrd;

public class myRunable implements Runnable{
   int i =10;
	public myRunable(int i){
	 this.i = i;
	}
	
	@Override
	public void run() {
		System.out.println("Inside run method : " +i);	
	}

}
