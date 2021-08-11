package CoreJava.J_Basic.references;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
 

public class WeakRefEx {
	
	public static class Referred {
        protected void finalize() {
            System.out.println("Good bye cruel world");
        }
    }
 
    public static void collect() throws InterruptedException {
        System.out.println("Suggesting collection");
        System.gc();
        System.out.println("Sleeping");
        Thread.sleep(2000);
    }
 
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Creating weak references");
 
        // This is now a weak reference.
        // The object will be collected only if no strong references.
        Referred strong = new Referred();
        WeakReference<Referred> weak = new WeakReference<Referred>(strong);
 
        // Attempt to claim a suggested reference.
        WeakRefEx.collect();
 
        System.out.println("Removing reference");
        // The object may be collected.
        strong = null;
        WeakRefEx.collect();
 
        System.out.println("Done");
    }

}
