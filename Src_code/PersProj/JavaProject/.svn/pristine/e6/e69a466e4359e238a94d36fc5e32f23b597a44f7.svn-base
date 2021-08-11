package CoreJava.J_Basic.overloadingriding.ReferenceCasting;

/**
 * Upcasting : Downcasting : Compiler Error on RunTime error : Valid scenario :
 * 
 * @author Manish
 * 
 */
public class ReferenceCastingExceptRule {
	public static void main(String[] args) {
		AnimalRef animal = new AnimalRef();
		AnimalRef animalref = new Dog();
		Dog dog = new Dog();

		// dog = animal; // This is compiler error; for downcasting, explicit casting is reqd;
		dog = (Dog) animal; // This is runtime error; Because animal is not an object of dog.
		
		dog = (Dog) animalref; // this is fine, because animalref is an object  of dog.
		animal = dog; // This is up casting and Explicit casting not reqd. This  wont throw any error
	}
}
