package CoreJava.J_Essential.MultiThreading.volatileEx;

public class Singalton {
	
	static volatile Singalton singInstance= null;
	//static  Singalton singInstance= null;

	private Singalton(){
		
	}

	static Singalton getInstance() throws InterruptedException{
		System.out.println("Calling getInstance");

		if(singInstance==null){
			System.out.println("Just before synchronized block");
			synchronized(Singalton.class){
				if(singInstance==null){
					
					singInstance = new Singalton();
					System.out.println("Object Created");

					Thread.sleep(10000);
					System.out.println("Exiting");

				}
				
			}
		}
		return singInstance;
		
	}
}
