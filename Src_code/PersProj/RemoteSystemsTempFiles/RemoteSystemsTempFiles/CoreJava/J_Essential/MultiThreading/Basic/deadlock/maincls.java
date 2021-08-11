package CoreJava.J_Essential.MultiThreading.Basic.deadlock;


public class maincls {
	
	public static void main(String args[]){
	
		ClasA a = new ClasA();
		ClasB b = new ClasB();
	
		Thrd1 t1 = new Thrd1(a,b);
		Thrd2 t2 = new Thrd2(a,b);
		
		Thread trd1 = new Thread(t1);	
		Thread trd2 = new Thread(t2);
		
		trd1.start();
		trd2.start();		
		
	}
}
