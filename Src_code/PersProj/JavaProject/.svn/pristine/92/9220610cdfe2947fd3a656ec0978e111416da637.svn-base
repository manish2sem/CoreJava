package CoreJava.J_Essential.MultiThreading.Basic.deadlock;

public class Thrd1 implements Runnable{
	ClasA a;
	ClasB b;
	Thrd1(ClasA a, ClasB b){
		this.a = a;
		this.b = b;
	}
	
	public void run(){
		//ClasA a= new ClasA();
		//ClasB b= new ClasB();
		System.out.println("Inside thrd1 start");
		a.fst(b);
		System.out.println("Inside thread1 End ");
		
	}
	
	
}
