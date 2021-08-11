package CoreJava.J_Basic.overloadingriding.ReferenceCasting;
/**
 * Downcast is only done when actual down casted object is of type reference var.
 * This can be checked with operator instanceof.
 * Dog d1 = (Dog) animal;
 * 
 * Upcasting is optional.
 * 		Animal animal = (Animal) dog; 
 * This  is equivalent to 
 * 		Animal animal = dog;
 * 
 *
 */
public class ReferenceCastingIllegal {
	public static void main(String [] args) {
		AnimalRef animal = new AnimalRef();
		Dog d;
	//	Dog d = animal;// compilation error, down casting is required
	//	Dog d1 = (Dog) animal; // compiles but fails later; even if it is not used.
		//To avoid run time error instanceof operatore is used
		if(animal instanceof Dog){
			System.out.println("It is of type dog");
			 d = (Dog) animal;
		}else{
			System.out.println("Not of compatiable type");
		}
		
		animal = new Dog();
//		Dog d1 = (Dog) animal; This is fine.
		if(animal instanceof Dog){
			 d = (Dog) animal;
			 System.out.println("It is of type dog");
		}else{
			System.out.println("Not of compatiable type");
		}
	}

}

class AnimalRef { }

class Dog extends AnimalRef { }

//class Cat extends AnimalRef { }
