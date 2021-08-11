package CoreJava.J_Essential.MultiThreading.Basic;

/**
 * Because synchronization does hurt concurrency, you don't want to synchronize any more code than is necessary to protect your data. 
 * So if the scope of a method is more than needed,
 *  	you can reduce the scope of the synchronized part to something less than a full method—to just a block.
 * 
 * When a thread is executing code from within a synchronized block, including any method code invoked from that synchronized block, 
 * the code is said to be executing in a synchronized context. 
 * The real question is, synchronized on what? Or, synchronized on which object's lock? 
 * 
 * When you synchronize a method, the object used to invoke the method is the object whose lock must be acquired. 
 * But when you synchronize a block of code, you specify which object's lock you want to use as the lock, 
 * so you could, for example, use some third-party object as the lock for this piece of code.
 * That gives you the ability to have more than one lock for code synchronization within a single object.
 */

public class SynchronizeBlock {
	 public static void main(String args[]) {
		    Callme target = new Callme();
		    Caller ob1 = new Caller(target, "Hello");
		    Caller ob2 = new Caller(target, "Synchronized");
		    Caller ob3 = new Caller(target, "World");

		    // wait for threads to end
		    try {
		      ob1.t.join();
		      ob2.t.join();
		      ob3.t.join();
		    } catch(InterruptedException e) {
		      System.out.println("Interrupted");
		    }
		  }
}



//This program uses a synchronized block.
class Callme {
  void call(String msg) {
    System.out.print("[" + msg);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
    System.out.println("]");
  }
}

class Caller implements Runnable {
  String msg;
  Callme target;
  Thread t;

  public Caller(Callme targ, String s) {
    target = targ;
    msg = s;
    t = new Thread(this);
    t.start();
  }

  // synchronize calls to call()
  public void run() {
    synchronized(target) { // synchronized block
      target.call(msg);
   }
  }
}
