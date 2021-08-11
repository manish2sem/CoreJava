package EffectiveJava.A_Objects.Item3;


/**
 * First way to implement singletons
 * 	- the member is a final field.
 *  - The private constructor is called only once.
 *  	 to initialize the Elvis.INSTANCE.
 *  - The lack of a public/protected constructor guarantees 
 *  	That exactly one Elvis instance will exist once the Elvis class is initialized
 * @author Manish
 *
 */
public class A_Elvis {

	public static final A_Elvis INSTANCE = new A_Elvis();
	private A_Elvis() { 
		System.out.println("This is private constructor");
	}
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