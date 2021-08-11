package DS.BitWise.CommonTricks;


/**
 * Given an integer x, return a number y with only the most significant bit in x set. 
 * It is same as the largest power of 2 that is no greater than x ( less than or equal to x ) Here we show, how to do this trick on a 32 bit integer. 
 * Look what happens in following.
 * 		y = x;
 * 		y = y | ( y >>1 ) ; 
 *      y = y  | ( y >>2 ); 
 *      y = y  | ( y >>4 );           
 *      y = y  | ( y >>8 );           
 *      y = y  |  ( y >>16 ) ;
 *      
 *Above right-shifting by powers of 2 and ORing at each step, sets all the bits starting from most significant bit set in x to the extreme right to 1. 
 * Now its simple to see 
 * 		y =  ( y + 1 ) >> 1;   
 * has the required answer.
 *
 */

public class D_MostSignificantBit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
