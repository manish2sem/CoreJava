package CoreJava.J_Elementry.enumConcepts.Advance;

/**
 * enum really is a special kind of class :
 *  - You can add constructors, instance variables, methods, and 
 *  - something really strange known as a constant specific class body.(see another program)
 *  
 *  - You can NEVER invoke an enum constructor directly. 
 *  	The enum constructor are always called automatically when an enum is initialized.
 *  	For example, BIG(8)
 *    
 *  - You can define more than one argument to the constructor, and 
 *  	you can overload the enum constructors, just as you can overload a normal class constructor.
 * @author Manish
 * 
 * Program statement : 
 * 	You want to know the actual size, in ounces, that map to each of the three CoffeeSize constants. 	
 * 	For example, you want to know that BIG is 8 ounces, HUGE is 10 ounces, and OVERWHELMING is a whopping 16 ounces.
 * Alternate approach : 
 * 	You could make some kind of a lookup table, using some other data structure.
 * 	but that would be a poor design and hard to maintain. 
 * Solution :
 * The simplest way is to treat your enum values (BIG, HUGE, and OVERWHELMING), 
 * as objects that can each have their own instance variables. 
 * Then you can assign those values at the time the enums are initialized, 
 * by passing a value to the enum constructor.
 * 
 *
 *Note: 
 *	Every enum has a static method, values(), that returns an array of the enum's 
 *	values in the order they're declared.
 */
public class EnumAsClass {
	BeerSize size; // each instance of Coffee has an enum
	public static void main(String[] args) {
		System.out.println("Starting EnumAsClass...");
		EnumAsClass drink1 = new EnumAsClass();
		drink1.size = BeerSize.BIG;
		EnumAsClass drink2 = new EnumAsClass();
		drink2.size = BeerSize.OVERWHELMING;
		System.out.println(drink1.size.getOunces()); // prints 8
		for(BeerSize bs: BeerSize.values())
			System.out.println(bs + " " + bs.getOunces());
	}

}

/**
 * This can be defined 
 * 	as a separate class in different file
 *  As a Separate class in same file. This ex.
 *  Within a class.
 * @author Manish
 *
 */
enum BeerSize {
	BIG(4), LARGE(6), OVERWHELMING(10);// instance of BeerSize enum(as class).	
	
	private int ounce;	//instance var;
	
	BeerSize(int ounce){ 	// Constructor;
		this.ounce = ounce;		
	}	
	
	int getOunces(){ 	//method
		return ounce;
	}
	
}


