package CoreJava.J_Essential.Generics.Advance;

import java.util.ArrayList;
import java.util.List;

import CoreJava.J_Essential.Generics.ExampleClass.*;



/**
 * We cnt do like : 
 * ArrayList<Animal> dogs = new ArrayList<Dog>();  ===
 * 
 * animals = {new Cat(), new Cat()};
 * addAnimal(ArrayList<Dog> animals)
  public void addAnimal(ArrayList<Animal> animals) {
		animals.add(new Dog()); // sometimes allowed...
	}
 * 
 * The reason the compiler won't let you pass an ArrayList<Dog> into a method that takes an ArrayList<Animal>, is because 
 * within the method, that parameter is of type ArrayList<Animal>, and that means you could put any kind of Animal into it.
 * There would be no way for the compiler to stop you from putting a Dog into a List that was originally declared as <Cat>, 
 * but is now referenced from the <Animal> parameter.
 *how do you get around it??
 *
 *As long as the only thing you pass to the addAnimals(List<Animal>) is an ArrayList<Animal>,
 *the compiler is pleased—knowing that any Animal subtype you add will be valid 
 *you can always add a Dog to an Animal collection.
 *ArrayList<Animal> animal = new ArrayList<Animal>(); 
 *animals.add(new Dog());
 *animals.add(new Cat());
 *They are always valid.
 *
 *problem comes when you do 
 *ArrayList<Cat> cat = new ArrayList<Cat>(); 
 *cat.add(new Dog());
 *
 *It's the add() method that is the problem.
 *the problem is related only to the danger of adding the wrong thing to the collection (Eg dof in cat list.)
 *
 *So if we promise compiler the collection passed in just to invoke methods on the elements—and 
 *not to ADD anything into the collection." And we have wildcard <?> mechanism.
 *
 *The method signature would change from 
 *			public void addAnimal(List<Animal> animals)	
 *		to
 *			public void addAnimal(List<? extends Animal> animals)
 *
 *	1. List<? extends Animal> animals  
 *	- argument can be of subtype of List and generic type can be anything that extends Animal.And 
 *  - Most important, nothing can be added into the collection animals.
 * 
 * 2. List<? super Animal> animals
 * 	- Method can accept the argument as type of *Animal* or any of its supertypes.
 * 	- List<? super Cat> animals ===  argument can be of cat type, Animal type or object type. 
 * 		ie anything of super type of Cat().
 * 	- Most important, compiler will not stop you to add anything into the collection animals.
 * This is perfectly fine. because adding super type of in a list is never a problem.
 * 
 * 3. public void foo(List<?> list) : here List<?> means
 * 	- wildcard <?> without the keywords extends or super, simply means "any type."
 * 		that means any type of List can be assigned to the argument.
 * 	- Most important, without the keyword super means you cannot ADD anything to the list.
 * 
 *
 */

public class WildCardGen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Animal> animals = new ArrayList<Animal>();
		List<Cat> cats = new ArrayList<Cat>();
		animals.add(new Dog());
		animals.add(new Dog("zimmy"));
		WildCardGen WildCardGen = new WildCardGen();
		WildCardGen.addAnimal(animals);
		WildCardGen.addDog(animals);

		List<Integer> myList = new ArrayList<Integer>();
		Bar bar = new Bar();
		//	bar.doInsert(myList);

	}

	public void addAnimal(List<? extends Animal> animals) {
		//animals.add(new Dog()); // NO! Can't add if we use "<? extends Animal>"
		for (Animal animal : animals) {
			System.out.println(animal.getName());			
		}
	}

	public void addDog(List<? super Cat> animals) {
		animals.add(new Cat()); // adding is sometimes OK with super
	}

}

class Bar {
	void doInsert(List<Object> list) {
		list.add(new Dog());
	}
}
