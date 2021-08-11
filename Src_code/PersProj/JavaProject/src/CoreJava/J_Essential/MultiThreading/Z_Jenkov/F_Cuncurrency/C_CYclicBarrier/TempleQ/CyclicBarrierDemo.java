package CoreJava.J_Essential.MultiThreading.Z_Jenkov.F_Cuncurrency.C_CYclicBarrier.TempleQ;

/**
 * http://java-demos.blogspot.in/2013/10/using-cyclicbarrier-in-java-with-example.html
 */

import java.util.concurrent.CyclicBarrier;


class CyclicBarrierDemo	{
	public static void main(String args[])	    {
		// No.of threads to wait
		// In general terms, no.of queues to wait, here 2
		CyclicBarrier cb = new CyclicBarrier(2, new GoVIP());
		
		final CyclicBarrier cb1 = new CyclicBarrier(3, new Runnable(){
            @Override
            public void run(){
                //This task will be executed once all thread reaches barrier
                System.out.println("All parties are arrived at barrier, lets play");
            }
        });

		// Create two threads,
		// a 50/- line and a 100/- line
		new FiftyClass(cb);
		new HundredClass(cb);
	}
}


