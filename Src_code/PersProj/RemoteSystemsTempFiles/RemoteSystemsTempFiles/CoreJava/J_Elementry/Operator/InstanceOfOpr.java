package CoreJava.J_Elementry.Operator;

/**
 * instanceof is for reference variables only, and checks for whether the object is of a particular type. 
 * The instanceof operator can be used only to test objects (or null) against class types that are in the same class hierarchy.
 * ie an object passes the instanceof test if any of its superclasses implement the interface on the right side of the instanceof operator.
 * 
 * You can't use the instanceof operator to test across two different class hierarchies.
 * This will compilation error.
 * @author Manish
 *
 */

public class InstanceOfOpr {
	public static void main(String[] args) {
		Animal animal = new Animal();
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		if (dog instanceof Dog){
			System.out.println("Dog is instance of Dog");
		}else {
			System.out.println("Dog is not an instance of Dog");
		}
		
		if (dog instanceof Animal){
			System.out.println("Dog is an instance of Animal");
		}else {
			System.out.println("Dog is not an instance of Animal");
		}
		
		if (cat instanceof Animal){
			System.out.println("cat is an instanceof Animal");			
		}else {
			System.out.println("cat is not an instanceof Animal");
		}
		
		if (animal instanceof Dog){
			System.out.println("animal is an instanceof Dog");			
		}else {
			System.out.println("animal is not an instanceof Dog");
		}
		
		/*if (cat instanceof Dog){  //complier error
			System.out.println("cat is an instanceof Dog");			
		}else {
			System.out.println("cat is not an instanceof Dog");
		}*/
		
		Animal anim = new Dog();
		if (anim instanceof Dog){
				anim.eat();
		//		anim.bark();
				((Dog) anim).bark();
				((Dog)anim).eat();
		}
		
	}

}

class Animal {
	void eat() {
		System.out.println("Animal eats");
	}
}

class Dog extends Animal {
	void eat() {
		System.out.println("Dog eats");
	}
	void bark() {
		System.out.println("Dog barks");
	}
}

class Cat extends Animal {
	void eat() {
		System.out.println("Cat eats");
	}
}
