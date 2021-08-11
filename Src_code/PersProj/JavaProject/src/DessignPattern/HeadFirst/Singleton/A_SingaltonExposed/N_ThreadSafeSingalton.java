package DessignPattern.HeadFirst.Singleton.A_SingaltonExposed;

public class N_ThreadSafeSingalton {
		
	private static N_ThreadSafeSingalton uniqueInstance = null;
	
	private N_ThreadSafeSingalton(){
		
	}
	
	/**
	 * Notice the static declaration of getInstance
	 * It is because this method can be called from outside without creating this instance.
	 *  Like - MySingalton.getInstance()
	 *  And this is the only place where we create the instance of MySingalton despite of private constructor..
	 * @return
	 * @throws InterruptedException 
	 */
	public static synchronized N_ThreadSafeSingalton getInstance() throws InterruptedException{
		
		if (uniqueInstance == null){
			Thread.sleep(1000);// just to show multithreading issue.
			uniqueInstance=new N_ThreadSafeSingalton();
		}		
		
		return uniqueInstance;
	}
	
}

/**
 * Synchronization is a costly operation.
 * Once we have set the uniqueInstance to an instance of N_ThreadSafeSingalton, 
 * We have no further need to synchronize this method.
 * 
 * Solution of above overhead is - double check locking.
 * 
 * 
 * 
 */