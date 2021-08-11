package CoreJava.J_Essential.MultiThreading.Z_Jenkov.F_Cuncurrency.C_CYclicBarrier.TempleQ;

import java.util.concurrent.CyclicBarrier;

class HundredClass extends Thread {
CyclicBarrier cb;

    public HundredClass(CyclicBarrier cb) {
        // Take the CyclicBarrier object
        this.cb=cb;
        
        // Let the 100/- queue move
        start();
    }
    
    public void run() {
        // They are just 2 km to go, because they paid a double amount!
        System.out.println("2 Km to go");
        try
        {
            // Slow down, guys! Let the VIP go!
            cb.await();
        }catch(Exception e){
            System.out.println("We can't wait");
        }
        
        // Great, you got it for 100!
        System.out.println("Hurray! We saw our GOD! +100");
    }
    
}