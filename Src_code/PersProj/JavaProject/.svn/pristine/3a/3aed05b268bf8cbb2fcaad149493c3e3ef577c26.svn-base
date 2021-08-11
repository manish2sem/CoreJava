package CoreJava.J_Essential.MultiThreading.Basic.deadlock;

public class ClasB {

	synchronized void fst1(ClasA clasa){
		clasa.last();
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ex){
			System.out.println("Exception -> fst -> clsA");

		}

		System.out.println("Inside B Last");
	}

	synchronized void last(){
		System.out.println("Inside B Last");
	}
}
