package CoreJava.J_Essential.InnerClasses.Anonymous;

/**
 * It creates an anonymous implementer of the specified interface type.
 * 
 * this new just-in-time class is an implementer of the Cookable interface.
 * 
 * new Cookable()
 * you can't instantiate an interface, yet that's what the code looks like it's doing. 
 * But of course it's not instantiating a Cookable object,
 * it's creating an instance of a new, anonymous, implementer of Cookable.
 * 
 * anonymous interface implementers can implement only one interface.
 * In fact, an anonymous inner class can't even extend a class and implement an interface at the same time.
 * The inner class has to choose either to be a subclass of a named class (previous Eg) or 
 * to implement a single interface.
 *
 */

public class AnonymousFlavoutTwoIf {
	public static void main(String[] args) {	
		Cookable c = new Cookable() {
										public void cook() {
											System.out.println("anonymous cook implementer");
										}
										
										public void clean() {
											System.out.println("anonymous clean implementer");
										}
									
									};
		c.clean();
	}// main closed

}

interface Cookable {
	public void clean();
	public void cook();
}

/**
 * Declare a reference variable of type Cookable that, obviously, will refer to an object from a class 
 * that implements the Cookable interface. But, we don't yet have a class that implements Cookable, 
 * so we're going to make one right here, right now. 
 * We don't need a name for the class, but it will be a class that implements Cookable,
 * and this curly brace starts the definition of the new implementing class.
 * 
 */
