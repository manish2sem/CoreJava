package CoreJava.J_Essential.Generics.Basics;


import java.util.ArrayList;
import java.util.List;
import CoreJava.J_Essential.Generics.ExampleClass.*;

public class GenericConcept {
	public static void main(String args[]) { 
		
		List<Animal> animalList = new ArrayList<Animal>();
		animalList.add(new Animal("No Name"));
		animalList.add(new Dog("Jimmy A Dog"));
		animalList.add(new Cat("Pussy A Cat"));
		
		for (Animal animal : animalList) {
			System.out.println(animal.getName());
			
		}
	}
}

/**
 * We can put an Animal and its subtype to List of generic type Animal. 
 * List<Animal> animalList = new ArrayList<Animal>();
 */
