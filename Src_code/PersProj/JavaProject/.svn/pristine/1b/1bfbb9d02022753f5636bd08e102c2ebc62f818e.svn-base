package CoreJava.J_Elementry.enumConcepts;

import java.util.ArrayList;

/**
 * Remember that enums are not Strings or ints!
 * Each of the enumerated CoffeeSize types are actually instances of CoffeeSize. 
 * In other words, BIG is of type CoffeeSize.
 *
 * conceptual example of how you can think about enums
 *   EnumSimulator === CoffeeSize
 */

public class EnumSimulator {
	
	public static final EnumSimulator BIG = new EnumSimulator("BIG", 0);
	public static final EnumSimulator HUGE = new EnumSimulator("HUGE", 1);
	public static final EnumSimulator OVERWHELMING = new EnumSimulator("OVERWHELMING", 2);
	
	ArrayList<EnumSimulator> enumList = new ArrayList<EnumSimulator>();
	public EnumSimulator(String enumName, int index) {
		//enumList.add(index, enumName);	
		// stuff here
	}
		
	public static void main(String[] args) {
			System.out.println(EnumSimulator.BIG);
	}
}


/**
 * Notice  : 
 * Each of the enumerated values, BIG, HUGE, and OVERWHELMING, are instances of type CoffeeSize. 
 * They're represented as static and final, which is thought of as a constant.
 * 
 * each enum value knows its index or position.
 * You can think of the CoffeeSize enums as existing in an array of type CoffeeSize, and 
 * you can iterate through the values of an enum by invoking the values() method on any enum type.
*/