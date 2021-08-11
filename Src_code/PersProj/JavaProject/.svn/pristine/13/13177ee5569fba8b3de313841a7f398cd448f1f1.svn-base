package CoreJava.J_Basic.references;

/**
 * http://neverfear.org/blog/view/150/Strong_Soft_Weak_and_Phantom_References_Java
 * 
 * finalize() is Called by the garbage collector on an object when garbage collection determines that there are no more references to the object.
 * 
 * It is defined in object class. * 
 * 		protected void finalize() throws Throwable.
 * 
 * The finalize method in Object does nothing.
 */

public class StrongReferences {
	
	 public static class Referred {
	        protected void finalize() {
	            System.out.println("Good bye cruel world");
	           // super.finalize();
	        }
	    }
	 
	    public static void collect() throws InterruptedException {
	        System.out.println("Suggesting collection");
	        System.gc();
	        System.out.println("Sleeping");
	        Thread.sleep(2000);
	    }
	 
	    public static void main(String args[]) throws InterruptedException {
	        System.out.println("Creating strong references");
	 
	        // This is now a strong reference.
	        // The object will only be collected if all references to it disappear.
	        Referred strong = new Referred();
	 
	        // Attempt to claim a suggested reference.
	        StrongReferences.collect();
	 
	        System.out.println("Removing reference");
	        // The object may now be collected.
	        strong = null;
	        StrongReferences.collect();
	 
	        System.out.println("Done");
	    }

}
