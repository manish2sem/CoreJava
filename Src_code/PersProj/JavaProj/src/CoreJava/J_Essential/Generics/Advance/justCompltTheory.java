package CoreJava.J_Essential.Generics.Advance;

/**
 * 
 * We can put an Animal and its subtype to List of generic type Animal. 
 * 		List<Animal> animalList = new ArrayList<Animal>();
 *
 * Polymorphism applies to only the "base" type not on generic type.
 * 		List<Animal> myList = new ArrayList<Animal>(); //Correct. List -> ArrayList
 * 		List<Animal> myList = new ArrayList<Dog>(); // Wrong
 * Here, generic type -> Animal
 * 		 Base Type -> myList
 * 
 * List<? extends Animal> animalList; declaration implies : 
 * 		- animalList accept any object of type  <Animal> or anything that extends Animal. And 
 *  	- animalList will not #ADD# anything into the it.
 *  List<? extends Animal> aList = new ArrayList<Dog>();
 *  Use Case :
 *  	-mostly passed as function parameter.
 *  Zoo(List<? extends Animal> animalList){	}
 *  	This can be called as 
 *  		Zoo(dogList); //where List<Dog> dogList = new ArrayList<Dog>();
 *  		Zoo(catList); //where List<Cat> catList = new ArrayList<Cat>();
 *  
 *  List<? super Dog> animalsList; declaration implies :
 *  	- animalsList can accept the type on the right-hand side of super or  * any of its supertypes, 
 *  	- Nothing lower in the inheritance tree can come in.
 *  List<? super Dog> aList = new ArrayList<Animal>();
 *  Use Case :
 *  	-mostly passed as function parameter, as above.
 *  Zoo(List<? Super Animal> animalList){	}
 *  	This can be called as 
 *  		Zoo(objList); //where List<Object> objList = new ArrayList<Object>();
 *  		Zoo(AnimalList); //where List<Animal> AnimalList = new ArrayList<Animal>();
 */

public class justCompltTheory {

}
