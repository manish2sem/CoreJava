package CoreJava.J_Essential.Generics.Polymorphism;

/**
 * base type VS Generic Type
 * Rule is : 
 * List<Parent> myList = new ArrayList<Parent>();  -> Correct  
 * 	- and myList will contain object type parant and all its subtypes.
 * 
 * List<Parent> myList = new ArrayList<Child>();	-> Wrong
 * 
 * and same will not work when passed as argument type.
 * 
 * addAnimal(new ArrayList<Cat>()); -> this will fail in compilation.    
 * addAnimal(ArrayList<Animal> animals){ }
 * 	- For invoking function, generic type of argument should equal to the generic type of parameter.
 *  - Other work around : 
 *  
 */

import java.util.ArrayList;
import java.util.List;
import CoreJava.J_Essential.Generics.ExampleClass.*;


public class PolymorphicAdd {
	
	public static void main(String[] args) {
		PolymorphicAdd polymorphicAdd = new PolymorphicAdd();
	
		//This logic will not work
		List<Cat> catList = new ArrayList<Cat>();
		catList.add(new Cat());
		catList.add(new Cat());
		polymorphicAdd.addAnimal(catList);// THIS is where it breaks! Trying to put Dog in cat list
	}
	
	public void inDogList() {		
		ArrayList<Animal> dogs = new ArrayList<Animal>();  //we cant declare new ArrayList<Dog>();
		dogs.add(new Dog()); // no problem, send the Dog[] to the method
		addAnimal(dogs);
	}
	
	public void inCatList() {		
		ArrayList<Animal> cats = new ArrayList<Animal>();
		cats.add(new Cat()); // no problem, send the Dog[] to the method
		addAnimal(cats);
	}
	
	public void addAnimal(ArrayList<Object> animals) {
		animals.add(new Dog()); // The code above WILL 	compile just fine IF what you pass into the method is 
								//also an ArrayList<Animal>. Not ArrayList<Dog>
	}

}
