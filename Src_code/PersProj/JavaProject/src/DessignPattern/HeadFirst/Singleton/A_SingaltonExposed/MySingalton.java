package DessignPattern.HeadFirst.Singleton.A_SingaltonExposed;

/**
 * Singalton Pattern ensures a class has only one instance and
 * provide a global point of access to it.
 *
 */

public class MySingalton {
	
	/**
	 * here uniqueInstance is declared as static because 
	 * it is used inside static method getInstance(). 
	 */
	private static MySingalton uniqueInstance = null;
	
	
	/*
	public ClassicSingalton ClassicSingalton(){
		if (count==null){
			count=new ClassicSingalton();
		}	
		return count;	//invalid
	}
	*/
	/**
	 * Interesting try but constructor can not have return type
	 *  so object or null can not be returned.
	 * 
	 */
	
	
	private MySingalton(){
		/**
		 * Constructor is private so MySingalton cannot be instantiated.
		 * But this(MySingalton) class still access the private constructor.
		 * And this is the only class who can call this constructor.
		 */
		 
	}
	
	/**
	 * Notice the static declaration of getInstance
	 * It is because this method can be called from outside without creating this instance.
	 *  Like - MySingalton.getInstance()
	 *  And this is the only place where we create the instance of MySingalton despite of private constructor..
	 * @return
	 * @throws InterruptedException 
	 */
	public static MySingalton getInstance() throws InterruptedException{
		
		if (uniqueInstance == null){
			Thread.sleep(1000);// just to show multithreading issue.
			uniqueInstance=new MySingalton();
		}		
		
		return uniqueInstance;
	}
	
	/**
	 * This method is as easy as accessing global variable. - MySingalton.getInstance()
	 */
	
	
	public void outpt(){
		System.out.println("inside output : ");
		System.out.println("count : "+ uniqueInstance);
	}


}

/**
 * This is also known as lazy instantiation.
 * Lazy, because first time instance is created when it is used. or 
 * called MySingalton.getInstance() in some part of your application.
 * 
 * Against this we have eagerly instantiation.
 * 
 */
