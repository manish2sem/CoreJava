package CoreJava.J_Importent.CallBack;

public class Test {
	public static void main(String[] args) 
	{ 
		Boss b = new Boss(); 
		b.directMethod(); 
	} 

}

interface Callable { 
	public void callBackMethod(); 
}

class Worker  { 
	// Worker gets a handle to the boss object via the Callable interface. 
	// There's no way this worker class can call any other method other than 
	// the one in Callable. 
	public void doSomeWork(Callable myBoss)  { 
		myBoss.callBackMethod(); 
		// ERROR! 
		//myBoss.directMethod(); 
	} 
} 

class Boss implements Callable 
{ 
	public Boss() 
	{ 
		// Boss creates a worker object, and tells it to do some work. 
		Worker w1 = new Worker(); 
		// Notice, we're passing a reference of the boss to the worker. 
		//w1.doSomeWork(this);
		this.callBackMethod();
	} 
	public void callBackMethod() 
	{ 
		System.out.println("What do you want?"); 
	} 
	public void directMethod() 
	{ 
		System.out.println("I'm out for coffee."); 
	} 
} 
/*public class CallBack 
{ 
	// Main driver. 
	
}*/
