package CoreJava.J_Essential.MultiThreading.Z_Jenkov.D_Lock.A_LockConcept.A_synch;

/**
 * This block makes sure that only one thread can execute the return ++count at a time.
 * 
 * See B_UsingLock.java 
 * 			for using  Lock mechanism to achieve similar behavior.
 *
 */

public class A_UsingSynchBlock {	
	private int count = 0;

	  public int incremtnt(){
	    synchronized(this){
	      return ++count;
	    }
	  }

}
