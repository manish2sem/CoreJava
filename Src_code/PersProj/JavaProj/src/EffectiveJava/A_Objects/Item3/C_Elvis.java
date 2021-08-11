package EffectiveJava.A_Objects.Item3;


/**
 * To make a singleton class serializable.
 * implements Serializable to its declaration. 
 * To maintain the singleton guarantee, 
 * 		Declare all instance fields transient and
 *  	Provide a readResolve method. 
 * Otherwise, each time a serialized instance is deserialized, a new instance will be created
 *
 */
public class C_Elvis {

	public static final C_Elvis INSTANCE = new C_Elvis();
	private C_Elvis() { 
		System.out.println("This is private constructor");
	}
	public static C_Elvis getInstance() { return INSTANCE; }
	public void leaveTheBuilding() { 

	}

	// readResolve method to preserve singleton property
	private Object readResolve() {
		// Return the one true Elvis and let the garbage collector
		// take care of the Elvis impersonator.
		return INSTANCE;
	}

}

