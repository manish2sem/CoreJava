package CoreJava.J_Essential.Generics.CreatingOwnGenericClass;

/**
 * Generic class declaration : 
 * 	 	class TestGenerics <T> { }
 * 	- The <T> is a placeholder for the type you pass in.
 * 	- T stands for "type", but any valid Java identifier would work here.
 * 
 */

import CoreJava.J_Essential.Generics.ExampleClass.*;

public class A_templateClass {
	
	public static void main (String[] args) {

		TestGenerics<String> myString = new TestGenerics<String>("SAMRAT");
		TestGenerics<Integer> myInt = new TestGenerics<Integer>(20);
		TestGenerics<Dog> myDog = new TestGenerics<Dog>(new Dog("Zimmy"));
	
		System.out.println(" String : " +myString.getInstance());
		System.out.println(" myInt : " +myInt.getInstance());
		System.out.println(" myDog : " +myDog.getInstance());
		
		Zoo<Dog> animalHolder = new Zoo<Dog> (new Dog(""));
		Zoo<Cat> animalHolder1 = new Zoo<Cat> (new Cat(""));
		//Zoo<Integer> animalHolder2 = new Zoo<Integer> (new Integer(28)));
	}
}

class TestGenerics <T> {
	
	T anInstance;
	T[] listofT;
	
	TestGenerics(T anIns){		
		anInstance = anIns;
	}
	
	T getInstance(){
		return anInstance;
	}	
}


class Zoo<ANML extends Animal> { // use "T" instead  of "?"
	ANML animal;
	Zoo(ANML animal){		
		this.animal = animal;
	}
	
	ANML getInstance(){
		return animal;
	}
}