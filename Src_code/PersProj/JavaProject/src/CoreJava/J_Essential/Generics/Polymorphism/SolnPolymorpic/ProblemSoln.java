package CoreJava.J_Essential.Generics.Polymorphism.SolnPolymorpic;

import java.util.ArrayList;
import java.util.List;
import CoreJava.J_Essential.Generics.ExampleClass.*;

/**
 *  polymorphism applies to the "base" type of the collection, not in Generic type.
 *  
 *  
 *  By saying <? extends Animal>, we're saying, 
 *  	- I can be assigned a collection that is a *subtype* of List and typed for <Animal> or anything that extends Animal. And 
 *  	- I will not ADD anything into the collection.
 *  that *subtype* can be EITHER a subclass of a class (abstract or concrete) OR 
 *  a type that implements the interface after the word extends.
 *
 *	void foo(List<? extends Serializable> list) // odd, but correct to use "extends"
 *	Note Serializable in an interface.
 *
 *	
 *	However, there is another scenario where you can use a wildcard AND 
 *  still add to the collection, but in a safe way—the keyword super.
 * 	 	public void addAnimal(List<? super Dog> animals)
 * you are telling the compiler that you can accept the type on the right-hand side of super or 
 * any of its supertypes, Nothing lower in the inheritance tree can come in.
 * The addition works because If you pass in a list of type Animal, then it's perfectly fine to add a Dog to it.
 *  
 */

public class ProblemSoln {
	
	public static void main (String args[]) {
		
	}
	
	public void problem(){
		List<Dog> dogList = new ArrayList<Dog>();
		addToList(dogList); // We can't add dog list to the animal list
		displayList(dogList);
	}
	
	public void addToList(List<Animal> animalList){
		animalList.add(new Cat());
	}

	
	public void displayList(List<Animal> animalList){
		for (Animal s : animalList) {
	    	System.out.println(s.getName()+ " " ); 
		}
	}
	
	public void Solution(){
		List<Dog> dogList = new ArrayList<Dog>();
		addToListSoln(dogList);
		displayListSoln(dogList);
		addToListSuper(dogList);
		
		List<Object> objList = new ArrayList<Object>();
		addToListSoln(objList);
		addToListSuper(objList);
	}
	
	public void addToListSoln(List<? extends Animal> animalList){
		animalList.add(new Dog());
	}

	
	public void displayListSoln(List<? extends Animal> animalList){
		for (Animal s : animalList) {
	    	System.out.println(s.getName()+ " " ); 
		}
	}

	public void addToListSuper(List<? super Dog> animalList){
		//animalList.add(new Cat());    // we can't add anything which is not a child class of dog 
		//animalList.add(new Animal()); // Animal is parent class of Dog so cant be added.
		animalList.add(new Dog());
		animalList.add(new BullDog());
		
		
	}

}

class BullDog extends Dog{
	
}
