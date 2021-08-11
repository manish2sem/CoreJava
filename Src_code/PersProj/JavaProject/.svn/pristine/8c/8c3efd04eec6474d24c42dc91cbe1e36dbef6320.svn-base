package CoreJava.J_Essential.MultiThreading.wtnnotify;

/**
 * Threads communicate about their locking status using the Object class three methods, wait(), notify(), and notifyAll().
 * @author Manish
 *
 */

class PizzaChef extends Thread{
		private Buffet buffet;
		public PizzaChef(Buffet b){
			buffet = b;
		}
		public void run(){
			int cookingTime = 0;
			while(true)	{
				synchronized(buffet){
					while(!buffet.isEmpty()){
						try	{
							System.out.println("Chef is waiting...");
							buffet.wait();
						}catch(InterruptedException e){}
					}
				}// end of synchronized
				//Bake some pizzas
				try	{
					System.out.println("Chef is cooking...");
					cookingTime = (int) (Math.random()*3000);
					Thread.sleep(cookingTime);
				}catch(InterruptedException e)	{}
				if(cookingTime < 1500)	{
					buffet.setEmpty(true);
				}else{
					buffet.setEmpty(false);					
					synchronized(buffet)	{
						buffet.notify();
					}
				}
			}// Outer While
		}
	}
	
	
	
	class Buffet{
		boolean empty;
		public synchronized boolean isEmpty(){
			return empty;
		}
		public synchronized void setEmpty(boolean b){
			empty = b;
		}
	}
	
	
	
 class LunchCrowd extends Thread{
	private Buffet buffet;
	public LunchCrowd(Buffet b){
		buffet = b;
	}
	
	public void run(){
		int eatingTime = 0;
		while(true){
			synchronized(buffet){
				while(buffet.isEmpty())	{
					try{
						System.out.println("Lunch crowd is waiting...");
						buffet.wait();
					}catch(InterruptedException e)
					{}
				}
			}
	//Eat some pizzas.
			try	{
				System.out.println("Lunch crowd is eating...");
				eatingTime = (int) (Math.random()*3000);
				Thread.sleep(eatingTime);
			}catch(InterruptedException e)
			{}
			if(eatingTime < 1500){
				buffet.setEmpty(false);
			}else{
				buffet.setEmpty(true);
				synchronized(buffet){
	
					buffet.notify();
				}
			}
		}
	}
}
 
 
 public class ProduceConsumeDemo{
	 public static void main(String [] args){
		 Buffet buffet = new Buffet();
		 PizzaChef producer = new PizzaChef(buffet);
		 LunchCrowd consumer = new LunchCrowd(buffet);
		 producer.start();
		 consumer.start();
	 }
 }