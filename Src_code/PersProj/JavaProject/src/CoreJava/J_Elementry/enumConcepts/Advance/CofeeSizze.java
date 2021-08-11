package CoreJava.J_Elementry.enumConcepts.Advance;


/**
 * An enum that looks like an anonymous inner class.
 * It's known as a constant specific class body, 
 * and you use it when you need a particular constant to override a method defined in the enum.
 * 
 * Program statement : 
 *   you want enums to have two methods—one for ounces and one for lid code (a String). 
 *   Now imagine that most coffee sizes use the same lid code, "B", 
 *   but the OVERWHELMING size uses type "A". 
 * Alternate approach : 
 * 	 You can do some if/then code in the getLidCode() method.
 *   But that would be hard to maintain and lead to poor design.
 * Solution :
 *   You can define a getLidCode() method in the CoffeeSize enum that returns "B", 
 *   but then you need a way to override it for OVERWHELMING. 
 *   And for that you need to somehow have the OVERWHELMING constant override the getLidCode() method.
 *   Here comes "constant specific class body".
 *
 */

public enum CofeeSizze {
	BIG(8),
	HUGE(10),
	OVERWHELMING(16) { // start a code block that defines the "body" for this constant
		public String getLidCode() { // override the method defined in CoffeeSize
			return "A";
		}
	}; // the semicolon is REQUIRED when more code follows


	CofeeSizze(int ounces) {
		this.ounces = ounces;
	}
	
	private int ounces;
	
	public int getOunces() {
		return ounces;
	}

	public String getLidCode() { // this method is overridden by the OVERWHELMING constant
		return "B"; // the default value we want to return for CoffeeSize constants
	}

}
