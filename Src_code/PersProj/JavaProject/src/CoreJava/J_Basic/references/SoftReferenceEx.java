package CoreJava.J_Basic.references;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceEx {
	
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
        System.out.println("Creating soft references");
 
        // This is now a soft reference.
        // The object will be collected only if no strong references exist and the JVM really needs the memory.
        Referred strong = new Referred();
        SoftReference<Referred> soft = new SoftReference<Referred>(strong);
 
        // Attempt to claim a suggested reference.
        SoftReferenceEx.collect();
 
        System.out.println("Removing reference");
        // The object may but highly likely wont be collected.
        strong = null;
        SoftReferenceEx.collect();
 
        System.out.println("Consuming heap");
        try
        {
            // Create lots of objects on the heap
            List<SoftReferenceEx> heap = new ArrayList<SoftReferenceEx>(1000000);
            while(true) {
                heap.add(new SoftReferenceEx());
            }
        }
        catch (OutOfMemoryError e) {
            // The soft object should have been collected before this
            System.out.println("Out of memory error raised");
        }
 
        System.out.println("Done");
    }

}
