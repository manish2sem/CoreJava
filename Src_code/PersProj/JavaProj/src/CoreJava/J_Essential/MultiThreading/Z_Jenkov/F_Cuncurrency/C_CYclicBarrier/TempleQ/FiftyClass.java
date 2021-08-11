package CoreJava.J_Essential.MultiThreading.Z_Jenkov.F_Cuncurrency.C_CYclicBarrier.TempleQ;

import java.util.concurrent.CyclicBarrier;

class FiftyClass extends Thread
{
	CyclicBarrier cb;
	public FiftyClass(CyclicBarrier cb)
	{
		// Know that FiftyCLass has to wait, so is the cyclic barrier
		// This object is used to call the await()
		this.cb=cb;

		// Start the thread and, let the 50/- queue move
		start();
	}

	public void run()
	{
		// They are just 2.5 km away from the  god
		System.out.println("2.5 Km to go");

		// An InterruptedException is raised.
		// In general, sometimes the situation goes uncontrollable due to heavy rush
		try
		{
			cb.await();
		}catch(Exception e){
			// Then, say, we can't wait
			System.out.println("We can't wait ");
		}

		// They completed their task!!
		System.out.println("Hurray! We saw our GOD! +50");
	}
}