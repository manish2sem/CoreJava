package CoreJava.J_Elementry.Literals;

/**
 * double --> 64 bits
 * float --> 32 bits
 * 
 * BURN IN UR HEAD
 * $RULE1-> Floating-point literals are defined as double by default.
 * Ex : 11301874.9881024 is of type double.
 * 
 * literal integer (such as 7) is always implicitly an int.
 * $RULE2-> The result of an expression involving anything int-sized or smaller is always an int.
 * In other words, add two bytes together and you'll get an int.
 * 
 * 
 * Casting : Implicit; Explicit
 * An implicit cast means you don't have to write code for the cast; the conversion happens automatically. 
 * Typically, an implicit cast happens when you're doing a widening conversion. 
 * In other words, putting a smaller thing (say, a byte) into a bigger container (like an int).
 * 
 * The large-value-into-small-container conversion is referred to as narrowing and requires an explicit cast, 
 * where you tell the compiler that you're aware of the danger and accept full responsibility.
 * 
 * NOTE : one Exception :
 *  When int literal is assigned to sort/byte variable no explicit cast is required.
 *  If it is within var range. TODO
 *  
 *  $RULE4-> Compound assignments (+=. *= etc) does an automatic cast.
 *
 */

public class BasicConcepts {
	public static void main(String[] args) {
		BasicConcepts basics = new BasicConcepts();
		basics.explicitCast();
	}

	/**
	 * $RULE1
	 * If you want to assign a floating-point literal to a variable of type float (32 bits), 
	 * you must attach the suffix F or f to the number.
	 * If you don't, the compiler will complain about a possible loss of precision
	 */ 	
	public void floatingPoint(){		 
		float flt = 234.67F;// Remove the F and u get compiler error.
		double dbl = 234.67D; // D is optional here, because default type of Floating-point literals are Double (D)
		double dbl2 = 234.67;		
	}

	public void explicitCast(){		 

		int y = 10;
		//	byte x = y;  //This requires explicit casting. byte<-int		
		byte byt = 10;	//Exception Rule
		//	byte byt2 = 400; //This reqd. explicit casting. because 400>127(range of byte)
		byte byt3 = (byte)600;
		System.out.println("The byte is " + byt3);	

	}

	public void byteExpr(){		 
		byte byt1 = 4;
		byte byt2 = 3;
		//	byte result = byt1 + byt2; // Compiler Error : RULE2.
		byte result = (byte) (byt1 + byt2); //because of byte<-int 

		//	result = result + byt1; // Error $RULE2 and $RULE3.
		result += byt1;			// No Error $RULE4. 		

	}

}
