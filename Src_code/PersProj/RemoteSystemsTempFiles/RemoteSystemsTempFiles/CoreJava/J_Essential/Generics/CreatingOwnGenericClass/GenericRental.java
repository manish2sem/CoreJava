package CoreJava.J_Essential.Generics.CreatingOwnGenericClass;

import java.util.ArrayList;
import java.util.List;
import CoreJava.J_Essential.Generics.ExampleClass.*;


public class GenericRental {

	/**
	 * Consider the API declaration for the java.util.List interface:
	 * 				public interface List<E>						E stands for element and could be any valid Java identifier. 
	 * 
	 * 	The <E> is a place holder for the type you pass in. 
	 * 	The List interface is behaving as a generic "template" (like C++ templates),
	 * 	and when you write your code, you change it 
	 * 	from a generic List to a List<Dog> or List<Integer>, and so on.
	 * 
	 * 	Consider the add() method of List<E>
	 * 				boolean add(E o)
	 * 	Implies, whatever E is when you declare the List, that's what you can add to it.
	 * 
	 * Making Your Own Generic Class - See the footage
	 */
	public static void main (String[] args) {
		//make some Cars for the pool
		List<Car> carList = new ArrayList<Car>();
		carList.add(new Car());
		carList.add(new Car());
		RentalGeneric<Car> carRental = new RentalGeneric<Car>(2, carList);
		// now get a car out, and it won't need a cast
		Car carToRent = carRental.getRental();
		carRental.returnRental(carToRent);
		// can we stick something else in the original carList?
		//carList.add(new Cat("Fluffy"));
		
		List<String> stringList = new ArrayList<String>();
		stringList.add("Manish");
		stringList.add("Samrat");
		stringList.add("Virat");
		
		RentalGeneric<String> strList= new RentalGeneric(3, stringList);
		
	}
}

/**
 * The following RentalGeneric class can be used for any type of objects. Car, bus, String, Integer.
 * Rental class can be typed to whatever the programmer chooses, and the compiler will enforce it. 
 */
 class RentalGeneric<T> { // "T" is for the type parameter
		private List<T> rentalPool; // Use the class type for the List type
		private int maxNum;
		public RentalGeneric(
				int maxNum, List<T> rentalPool) { // constructor takes a  List of the class type
			this.maxNum = maxNum;
			this.rentalPool = rentalPool;
		}
		public T getRental() { // we rent out a T blocks until there's something available
			return rentalPool.get(0);
		}
		
		public void returnRental(T returnedThing) { // and the renter  returns a T
			rentalPool.add(returnedThing);
		}
	}	
/**
 * 
 */

