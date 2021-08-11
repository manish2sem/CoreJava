package CoreJava.J_Basic.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;


/**
 * Phantom references are objects that can be collected whenever the collector likes. 
 * The object reference is appended to a ReferenceQueue and you can use this to clean up after a collection. 
 * This is an alternative to the finalize() method and is slightly safer because the finalize() method may ressurect the object by creating new strong references. 
 * The PhantomReference however cleans up the object and enqueues the reference object to a ReferenceQueue that a class can use for clean up.
 * @author sinhama
 *
 */

public class PhantomRefEx {
	
	public static class Referred {
        // Note that if there is a finalize() method PhantomReference's don't get appended to a ReferenceQueue
    }
 
    public static void collect() throws InterruptedException {
        System.out.println("Suggesting collection");
        System.gc();
        System.out.println("Sleeping");
        Thread.sleep(2000);
    }
 
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Creating phantom references");
 
        // The reference itself will be appended to the dead queue for clean up.
        ReferenceQueue dead = new ReferenceQueue(); 
 
        // This map is just a sample we might use to locate resources we need to clean up.
        Map<Reference,String> cleanUpMap = new HashMap<Reference,String>();
 
        // This is now a phantom reference.
        // The object will be collected only if no strong references.
        Referred strong = new Referred();
 
        PhantomReference<Referred> phantom = new PhantomReference(strong, dead);
        cleanUpMap.put(phantom, "You need to clean up some resources, such as me!");
 
        strong = null;
 
        // The object may now be collected
        PhantomRefEx.collect();
 
        // Check for 
        Reference reference = dead.poll();
        if (reference != null) {
            System.out.println(cleanUpMap.remove(reference));
        }
        System.out.println("Done");
    }

}
