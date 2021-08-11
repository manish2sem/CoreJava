package CoreJava.J_Essential.MultiThreading.Application.prodConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Producer implements Runnable{
	
	static Logger log = Logger.getLogger(Producer.class.getName());

	List sharedQ;
	int size;

	public Producer(List sharedQ, int size){
		this.sharedQ = sharedQ;
		this.size=size;
	}

	public void run(){
		
		while(true){
			System.out.println("Producing...: " );
			 try {
				produce(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void produce(int i) throws InterruptedException {

		synchronized(sharedQ)
		{
			while(sharedQ.size() == size)
			{
				sharedQ.wait();

			}
		}
		
		synchronized (sharedQ) {
			sharedQ.add(i);
			sharedQ.notifyAll();
        }
	}
}


