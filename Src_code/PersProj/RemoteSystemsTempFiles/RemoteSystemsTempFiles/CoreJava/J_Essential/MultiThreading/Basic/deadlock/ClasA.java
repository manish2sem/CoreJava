package CoreJava.J_Essential.MultiThreading.Basic.deadlock;

public class ClasA {

	synchronized void fst(ClasB clasb){
		//clasb.last(); //not thread because on object clasb the sync method last() is completed before sync method fst() gets chance to execute 
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ex){
			System.out.println("Exception -> fst -> clsA");
			
		}
		clasb.last();
		System.out.println("Inside A Last");
	}
	
	
	synchronized void last(){
		System.out.println("Inside A Last");
	}
}
