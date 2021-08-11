package CoreJava.J_Essential.Generics.CreatingOwnGenericClass;

import java.util.List;
import CoreJava.J_Essential.Generics.ExampleClass.*;

/**
 * 
 * You can use more than one parameterized type in a single class definition.
 */

public class B_PlaceHolders <T, X, Y>{

	T one;
	X two;
	Y three;
	
	B_PlaceHolders(T one, X two, Y three) {
		this.one = one;
		this.two = two;
		this.three = three;
	}
	T getT() { return one; }
	X getX() { return two; }
	Y getY() { return three; }
	
	// test it by creating it with <String, Integer>
	public static void main (String[] args) {
		B_PlaceHolders<String, Integer, Double> threes = 	new B_PlaceHolders<String, Integer, Double>("foo", 42, 45.6);
		String theT = threes.getT(); // returns a String
		int theX = threes.getX(); // returns Integer, unboxes to int
		double no = threes.getY();
		
		System.out.println(theT + " " + theX + " "+ no);
		
		AnimalHolder<Dog> dogHolder = new AnimalHolder<Dog>();
	}
}


class AnimalHolder<T extends Animal> { // use "T" instead
	// of "?"
	T animal;
}
