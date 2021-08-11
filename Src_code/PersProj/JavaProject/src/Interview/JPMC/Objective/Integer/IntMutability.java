package Interview.JPMC.Objective.Integer;

import Interview.JPMC.Objective.IfStatic.mainz;

/**
 * Wrong
 * @author Manish
 *
 */
public class IntMutability {
	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 1;
		Integer c = new Integer(2);
		Integer d = new Integer(2);
		Integer a1 = 200;
		Integer b1 = 200;

				
		System.out.println("a==b : " + (a==b));
		System.out.println("c==d : "+ (c==d));
		System.out.println("a1==b1 : "+ (a1==b1));

	}

}
/**
 * Give the special Attention on a==b and a1==b1.
 * Reason : 
 * 	In order to save memory, two instances of the following wrapper objects (created through boxing),
 *  will always be == when their primitive values are the same:
	¦ Boolean
	¦ Byte
	¦ Character from \u0000 to \u007f (7f is 127 in decimal)
	¦ Short and Integer from -128 to 127
	
 *	When == is used to compare a primitive to a wrapper,
 *  the wrapper will be unwrapped and the comparison will be primitive to primitive.
 * - Kathy Siera;  PAGE : 284.
 * 
 */

