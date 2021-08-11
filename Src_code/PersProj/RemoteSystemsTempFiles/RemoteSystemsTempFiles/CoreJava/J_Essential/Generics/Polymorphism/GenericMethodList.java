package CoreJava.J_Essential.Generics.Polymorphism;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Manish
 *
 */
public class GenericMethodList {


	public void inDogList() {		
		ArrayList<Animal> dogs = new ArrayList<Animal>();  
		dogs.add(new Dog()); // no problem, send the Dog[] to the method
		addAnimal(dogs);
	}

	public void inCatList() {		
		ArrayList<Animal> cats = new ArrayList<Animal>();
		cats.add(new Cat()); // no problem, send the Dog[] to the method
		addAnimal(cats);
	}

	public void addAnimal(List<Animal> animals) {
		animals.add(new Dog()); // The code above WILL compile just fine.
		animals.add(new Cat());			//IF what you pass into the method is also an ArrayList<Animal>. Not ArrayList<Dog>
	}

	public static void main(String[] args) {
		GenericMethodList genericMethods = new GenericMethodList();
		// This will work fine
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Cat());
		animals.add(new Cat());
		animals.add(new Dog());
		genericMethods.addAnimal(animals); //this will work

		//Same is this
		genericMethods.inCatList();  //Trying to put cat in animal list

		//This logic will not work
		List<Cat> cat = new ArrayList<Cat>();
		cat.add(new Cat());
		animals.add(new Cat());
		//  genericMethods.addAnimal(cat);// THIS is where it breaks! Trying to put Dog in cat list. This implies below
		//	cat.add(new Dog());           //  This is similar to above.
		genericMethods.addAnimal(animals);// THIS is perfect



	}
}

/**
 * We ArrayList<Animal> dogs = new ArrayList<Cat>(); 
 * 
 * Simply to prevent adding Cat object into Dog object list. 
 */

