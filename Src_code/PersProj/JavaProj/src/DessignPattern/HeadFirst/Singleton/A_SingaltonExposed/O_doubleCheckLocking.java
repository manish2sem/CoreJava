package DessignPattern.HeadFirst.Singleton.A_SingaltonExposed;
/**
 * With doubled check locking, first checked if instance is created
 * If not then we synchronize.
 * In this way we only synchronize the first time through.
 * @author Manish
 *
 */

public class O_doubleCheckLocking {

	// the volatile ensures that multiple threads handle the uniqueInstance correctly.
	private volatile static O_doubleCheckLocking uniqueInstance = null;


	private O_doubleCheckLocking(){

	}

	/**
	 * Check for an instance and if there is not one enter a synchronized block.
	 * Once in the synchronized block check again for the null. if it is null create the instance.
	 * @throws InterruptedException 
	 */
	public static O_doubleCheckLocking getInstance() throws InterruptedException{

		if (uniqueInstance == null){
			synchronized(O_doubleCheckLocking.class){
				Thread.sleep(1000);// just to show multithreading issue.
				if (uniqueInstance == null){
					uniqueInstance = new O_doubleCheckLocking();
				}
			}
		}
		return uniqueInstance;
	}


}
