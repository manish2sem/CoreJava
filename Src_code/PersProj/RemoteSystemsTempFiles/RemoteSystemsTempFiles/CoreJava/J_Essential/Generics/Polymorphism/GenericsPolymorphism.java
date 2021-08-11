package CoreJava.J_Essential.Generics.Polymorphism;

import java.util.*;

/**
 * polymorphism applies to the "base" type of the collection, not in Generic type.
 * Ex:  List<Integer> myList = new ArrayList<Integer>();
 * 		BaseType is List and ArrayList.
 * 		Generic type is the object inside <>, here Integer.
 * 
 * polymorphism applies to only the "base" type not on generic type.
 * 		List<JButton> myList = new ArrayList<JButton>(); //Correct. List -> ArrayList
 * 		List<Object> myList = new ArrayList<JButton>(); // Wrong!  Object -> JButton
 * JButton is the generic type
 * 
 * this is NOT how it works with arrays :  
 * 		Object[] myArray = new JButton[3]; // Correct
 * 		List<Object> list = new ArrayList<JButton>(); // Wrong!
 */
public class GenericsPolymorphism {
	public static void main(String[] args) {
		// test it
		Dog[] dogs = {new Dog(), new Dog()};
		Cat[] cats = {new Cat(), new Cat(), new Cat()};
		Bird[] birds = {new Bird()};
		AnimalDoctor doc = new AnimalDoctor();
		doc.checkAnimals(dogs); // pass the Dog[]
		doc.checkAnimals(cats); // pass the Cat[]
		doc.checkAnimals(birds); // pass the Bird[]


		//		Same will not work in case of ArrayList
		//		this approach does NOT work the same way with type safe collections!

		List<Dog> dogList = new ArrayList<Dog>();
		dogList.add(new Dog());
		dogList.add(new Dog());
		AnimalDoctorList docCol = new AnimalDoctorList();
		//	docCol.checkAnimals(dogList);  //Compilation error
	}
}

abstract class Animal {
	public abstract void checkup();
}

class Dog extends Animal {
	public void checkup() { // implement Dog-specific code
		System.out.println("Dog checkup");
	}
}
class Cat extends Animal {
	public void checkup() { // implement Cat-specific code
		System.out.println("Cat checkup");
	}
}

class Bird extends Animal {
	public void checkup() { // implement Bird-specific code
		System.out.println("Bird checkup");
	}
}

class AnimalDoctor {
	// method takes an array of any animal subtype
	public void checkAnimals(Animal[] animals) {
		for(Animal a : animals) {
			a.checkup();			// based of animal type checkup will be called.
			// instanceof is not reqd as it is used to call extramethod defined in child class than parent.
			// then instanceof -> downcast to child -> thn call reqd method.
		}
	}
}

class AnimalDoctorList {
	// method takes an array of any animal subtype
	public void checkAnimals(ArrayList<Animal> animals) {
		for(Animal a : animals) {
			a.checkup();
		}
	}
}
/**
 * this approach does NOT work the same way with type safe collections!

 * Same will not work in case of ArrayList. Why doesn't this work?
 * And why is it bad for ArrayList but not arrays? 
 * Why can't you pass an ArrayList<Dog> to an argument of ArrayList<Animal>? 
 * Actually, the problem IS just as dangerous whether you're using arrays or a generic collection.
 *  It's just that the compiler and JVM behave differently for arrays vs. generic collections.
 *  
 *  The reason it is dangerous to pass a collection (array or ArrayList) of a subtype 
 *  into a method that takes a collection of a supertype, is because you might add something. 
 *  And that means you might add the WRONG thing! 
 *  
 *  The reason you can get away with compiling this for arrays is because there is a 
 *  runtime exception (ArrayStoreException) that will prevent you from putting the 
 *  wrong type of object into an array.
 *  if you DO try to add a Cat to the object that is actually a Dog array, you'll get the exception.
 *  But there IS no equivalent exception for generics, because of type erasure! 
 *  In other words, at runtime the JVM KNOWS the type of arrays, but does NOT know the type of a collection.
 *  
 *  How do you get around it?
 **
 */
