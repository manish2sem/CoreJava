package CoreJava.J_Essential.MultiThreading.volatileEx;

/**
 * The volatile modifier tells the compiler that the variable modified by volatile can be changed unexpectedly by other parts of your program.
 *  One of these situations involves multithreaded programs.
 * @author sinhama
 * 
 * If you are working with the multi-threaded programming, the volatile keyword will be more useful. 
 * When multiple threads using the same variable, each thread will have its own copy of the local cache for that variable. 
 * So, when it’s updating the value, it is actually updated in the local cache not in the main variable memory.
 *  The other thread which is using the same variable doesn’t know anything about the values changed by the another thread. 
 *  To avoid this problem, if you declare a variable as volatile, then it will not be stored in the local cache.
 *   Whenever thread are updating the values, it is updated to the main memory. So, other threads can access the updated value.

Declaring a variable volatile means

There will be no cache maintained means all the changes made in main memory.
Access to this variable acts as synchronized block, even though it is in synchronized unit
 *
 */

public class VolatileConcept {

	public static void main(String args[]) throws InterruptedException{
	    Runnable r = new snippet1();
	    Thread t1 = new Thread(r);
	    t1.setName("Thread1");
	    t1.start();

	    Thread.sleep(1000);

	    Thread t2 = new Thread(r);
	    t2.setName("Thread2");
	    t2.start();
	    t1.join();
	    t2.join();
	}
}


class snippet1 implements Runnable
{
	volatile int num =0;
	// int num =0;

	public void run(){
	    Thread t = Thread.currentThread();
	    String name = t.getName();
	    if(name.equals("Thread1")){
	        num=10;
	        System.out.println(t.getName() + ": value of num is :" +num);
	    }
	    else{
	        System.out.println(t.getName() + ": value of num is :"+num);
	    }

	}
}
