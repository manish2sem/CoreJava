package CoreJava.J_Essential.MultiThreading.Application.prodConsumer;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable{

	List sharedQ;
	int size; 
	
	public Consumer(List sharedQ)
	{
		this.sharedQ = sharedQ;
		this.size=size;
	}
	
	public void run(){
		while(true){
			try {
				System.out.println("Consumed: " + consume());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int consume() throws InterruptedException
	{
		synchronized(sharedQ)
		{
			while(sharedQ.isEmpty())
			{
				sharedQ.wait();

			}
		}
		
		synchronized(sharedQ){
			sharedQ.notifyAll();
			return (Integer)sharedQ.get(0);
			
		}
		
	}
}
