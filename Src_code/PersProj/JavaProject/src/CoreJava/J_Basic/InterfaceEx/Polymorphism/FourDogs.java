package CoreJava.J_Basic.InterfaceEx.Polymorphism;

/**
 * If a class implements an interface, objects of the class can take on the form of the interface data type. 
 * The capability of an object to take on the form of an interface is an example of polymorphism.
 *  
 */

public class FourDogs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Instantiating four dogs of different types");
		Dog fido = new Dog();
		Mammal rover = new Dog();
		Play spot = new Dog();
		Object pooch = new Dog();
		
		System.out.println("Invoking Dog methods");
		fido.sleep();
		fido.playFetch();
		fido.breathe();		
		System.out.println("fido is " + fido.toString());
		
		System.out.println("\nInvoking Mammal methods");
		rover.breathe();
		
		System.out.println("\nInvoking Play methods");
		spot.playCatch();
		spot.playFetch();
		
		System.out.println("\nInvoking Object methods");
		System.out.println("pooch is " + pooch.toString());
		((Dog) pooch).sleep();
	}

}

class Dog extends Mammal implements Play{
	public void playFetch(){
		System.out.println("Dog is fetching");
	}
	public void playCatch(){
		System.out.println("Dog is catching");
	}
	public void sleep(){
		System.out.println("Dog is sleeping");
	}
}

class Mammal{
	public void breathe(){
		System.out.println("Mammal is breathing");
	}
}

interface Play{
	public void playFetch();
	public void playCatch();
}

/**
 * Through polymorphism, a Dog can take on the following forms:
 * Dog. Certainly a Dog object can take the form of a Dog.
 * Mammal. A Dog object is a Mammal object because Dog extends the Mammal class.
 * Play. A Dog object is a Play object because Dog implements Play. 
 * Object. A Dog object is an Object because Dog extends Mammal and Mammal extends Object.
 * 
 * Therefore, the following four statements are all valid:
 * Dog fido = new Dog();
 * Mammal rover = new Dog();
 * Play spot = new Dog();
 * Object pooch = new Dog();
 * 
 * Each of these four Dog objects looks the same in memory;
 *  However, each is being viewed in a different form, depending on its reference.
 *  
 *  to invoke any of the methods in Mammal, Play, or Dog requires the pooch reference to be cast.
*/