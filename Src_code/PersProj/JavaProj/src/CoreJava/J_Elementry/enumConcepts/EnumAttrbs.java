package CoreJava.J_Elementry.enumConcepts;

/**
 * Enum lets you restrict a variable to having one of only a few pre-defined values.
 * 		Ex : enum CoffeeSize { BIG, HUGE, OVERWHELMING };
 * 
 *  - each enumerated values, BIG, HUGE, and OVERWHELMING, are instances of type CoffeeSize. 
 *   	They're represented as static and final, which is thought of as a constant. 
 * 	- The order in which enum values are declared matters. 
 * 		You can think of the CoffeeSize enums as existing in an array of type CoffeeSize.
 *
 * The basic components of an enum are its constants (i.e., BIG, HUGE, and OVERWHELMING)
 * Enums can be declared as 
 * 		- their own separate class, or 
 * 		- as a class member.
 *	But they must not be declared within a method!
 * 
 * enums can be declared as their own class, or enclosed in another class, 
 * and that the syntax for accessing an enum's members depends on where the enum was declared.
 * 
 * BURN IT: 
 * Every enum has a static method, values(), 
 * that returns an array of the enum's values in the order they're declared.
 */

 //Declaring an enum outside a class:
enum CoffeeSize { BIG, HUGE, OVERWHELMING } // this cannot be private or protected

public class EnumAttrbs {
	CoffeeSize size;
	
	public static void main(String[] args) {
		EnumAttrbs drink = new EnumAttrbs();
		drink.size = CoffeeSize.BIG; // enum outside class
		//CoffeeSize.values();
		drink.enumInsideClass();
		
		CoffeeSize values[] = CoffeeSize.values();
		for (CoffeeSize value : values) {
			System.out.println("Values are : "+value);
		}
	}
	
	void enumInsideClass(){
		Coffee2 drink = new Coffee2();
		drink.size = Coffee2.CoffeeSize.HUGE1;
		System.out.println("drink.size in " +drink.size);

	}
	
	void enumInsideMethod(){
		// enum CoffeeSize { BIG, HUGE, OVERWHELMING } // WRONG! Cannot declare enums in methods
	}

}


/**
 * enum inside a class:
 */
class Coffee2 {
	enum CoffeeSize {BIG1, HUGE1, OVERWHELMING1 }  //this can be private.
	CoffeeSize size;
}
