package DessignPattern.HeadFirst.Singleton.A_SingaltonExposed;

/**
 * When the class is loaded first time by JVM,
 * MySingaltonEagerly is created and assigned to uniqueInstance.
 * 
 * Once created you can get this one and only one instance using - MySingaltonEagerly.getInstance().
 * 
 * Again this is thread safe since same instance is shared across all thread.
 */

public class MySingaltonEagerly {


	private static MySingaltonEagerly uniqueInstance = new MySingaltonEagerly();


	private MySingaltonEagerly(){
		/**
		 * Constructor is private so MySingalton cannot be instantiated.
		 * But this(MySingalton) class still access the private constructor.
		 * And this is the only class who can call this constructor.
		 */

	}

	/**
	 * Same instance is returned which is created at the time of class-loading.
	 * 
	 */
	public static MySingaltonEagerly getInstance() throws InterruptedException{		

		Thread.sleep(1000);// just to show multithreading issue.		
		return uniqueInstance;
	}

}

/**
 * Unlike Lazy Instantiation this instance will created at the time of class loading.
 * Even though the instance is never used once in application.
 * 
 * In lazy instantiation the instance is created when it come across the 
 * MySingaltonEagerly.getInstance(). So basically when required.
 */
