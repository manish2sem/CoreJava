package CoreJava.J_Basic.overloadingriding;

/**
 * 
 * @author Manish
 * 
 * The reference variable's type (not the object's type), determines scope of the methods !
 * Object type (not the reference variable's type), determines which overridden method is used at runtime !!
 * 
 * The overriding method
 * 		Must have the same argument list.
 *  	Must have the same return type, 
 *  		- except that as of Java 5 : the return type can be a subclass — this is known as a covariant return.
 *  	Must not have a more restrictive access modifier.
 *  	May throw fewer or narrower checked exceptions[subclassed exception of parent] or any unchecked exception.
 *  	
 *  	final methods cannot be overridden.
 *  	Only inherited methods may be overridden, and remember that private methods are not inherited.
 *  	Static methods can not be overridden but they can be redefined.
 *
 */

public class SimpleOverriding {
	public static void main (String [] args) {
		Animal a = new Animal();
		Animal b = new Horse(); //Animal ref, but a Horse object
		a.eat(); // Runs the Animal version of eat()
		b.eat(); // Runs the Horse version of eat()
	//  b.buck(); // Compiler error beacuse b's type is animal.
		
	//	Horse horse = new Animal(); //down casting is required otherwise compile time error.
		Horse horse =(Horse) new Animal(); //compiled but exception at run time : ClassCastException.
	}

}


class Animal {
	public void eat() {
		System.out.println("Generic Animal Eating Generically");
	}
	
	/*private Animal clone() throws CloneNotSupportedException   // Can not declare this as private. Compiler Error : Can not reduce the visibility of inherited method
	{	
			return (Animal)super.clone();		
	}*/
}

class Horse extends Animal {
	public void eat() {
		System.out.println("Horse eating hay, oats, and horse treats");
	}
	
	public void buck() { }
}