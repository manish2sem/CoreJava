package CoreJava.J_Essential.MultiThreading.Basic.deadlock;

public class Thrd2 implements Runnable{
	ClasA a;
	ClasB b;
	Thrd2(ClasA a, ClasB b){
		this.a = a;
		this.b = b;
	}
	
	
	public void run(){
		//ClasA a= new ClasA(); not a deadlock, because clasA will have two instances at Thrd2 and Thrd1. Note = object lock happens at the same instance of the object.
		//ClasB b= new ClasB();
		System.out.println("Inside thrd2 start");
		b.fst1(a);
		System.out.println("Inside thread2 End ");
		
	}

}
