package EffectiveJava.A_Objects.Item3;


/**
 * Second way to implement singletons : factory-method approach
 * 	-  Public member is a static factory method
 *  - All calls to Elvis.getInstance return the same object reference
 *  	
 *   @author Manish
 *
 */
public class B_Elvis {

	public static final B_Elvis INSTANCE = new B_Elvis();
	private B_Elvis() { 
		System.out.println("This is private constructor");
	}
	public static B_Elvis getInstance() { return INSTANCE; }
	public void leaveTheBuilding() { 
		
	}

}

/**
* A privileged client can invoke the private constructor reflectively.
* (Item 53) with the aid of the AccessibleObject.setAccessible method.
* You can defend against this attack
* 	modify the constructor to make it throw an 
* 	exception if it’s asked to create a second instance.
*/