package CoreJava.J_Basic.staticEx;

/**
 * static methods can't be overridden, but they can be redefined.
 * @author Manish
 *
 */

public class StaticOverriding {
	
	public static void main(String [] args) 
	{
		Animal [] a = {new Animal(), new Dog(), new Animal()};
		for(int x = 0; x < a.length; x++)
		a[x].doStuff(); // invoke the static method
		
		Dog dog1 = new Dog();
		dog1.doStuff(); // this means Dog.doStuff()
		
		Animal dog2 = new Dog();
		dog2.doStuff();  // this means Animal.doStuff()
		
	}

}

class Animal {
	static void  doStuff() {
		System.out.println("Inside Animal ");
	}
}
class Dog extends Animal {
	static void doStuff() { 
		// it's a redefinition, not an override
		System.out.println("Inside Dog ");
	}	
}