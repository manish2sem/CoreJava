package CoreJava.J_Basic.overloadingriding.ReferenceCasting;

/**
 * 
 * @author Manish
 * There are two types of reference variable casting: upcasting and downcasting.
 * 
 * Upcasting: You can assign a reference variable to a supertype reference variable
 * 			explicitly or implicitly. This is an inherently safe operation because the 
 * 			assignment restricts the access capabilities of the new variable.
 * 
 * Downcasting: If you have a reference variable that refers to a subtype object,
 * 				you can assign it to a reference variable of the subtype. You must make an
 * 				explicit cast to do this, and the result is that you can access the subtype's
 * 				members with this new reference variable.
 *
 */

public class ReferenceCastingLegal {
	public static void main(String [] args) {
		AnimalLegal [] a = {new AnimalLegal(), new DogLegal(), new AnimalLegal() };
		for(AnimalLegal animal : a) {
			animal.makeNoise();
			//String s = (String) animal; //Comile time error
		//	the compiler knows with certainty that the cast could not possibly work
			if(animal instanceof DogLegal) {
				//animal.playDead(); // compiler error ? because playDeed is not defined at Animal class.
				DogLegal d = (DogLegal) animal; // down casting the ref. var.
				d.playDead();  // Legal
			}/*else {
				Cat c = (Cat) animal; // down casting the ref. var to wrong boject.
				c.catchMouse(); // run time error
			}*/
		}	
	}

}

class AnimalLegal {
	void makeNoise() {System.out.println("generic noise"); }
}

class DogLegal extends AnimalLegal {
	void makeNoise() {System.out.println("bark"); }
	void playDead() { System.out.println(" roll over"); }
}

class Cat extends AnimalLegal {
	void makeNoise() {System.out.println("mew"); }
	void catchMouse() { System.out.println(" Mouse Catched"); }
}
	