package CoreJava.J_Essential.MultiThreading.Z_Jenkov.F_Cuncurrency.C_CYclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable{
	private CyclicBarrier barrier;

    public Task(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
        } catch (InterruptedException ex) {
            //Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            //Logger.getLogger(CyclicBarrierExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
