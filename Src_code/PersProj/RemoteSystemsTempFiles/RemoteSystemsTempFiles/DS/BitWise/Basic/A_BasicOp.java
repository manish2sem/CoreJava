package DS.BitWise.Basic;

/**
 * Bitwise and &; 
 * Bitwise or |; 
 * Bitwise not ~.
 * Xor (^):
 * 		0 ^ 0 = 0
 * 		1 ^ 0 = 1
 * 		0 ^ 1 = 1
 * 		1 ^ 1 = 0
 * 
 * Left Shift: x << y means x shifted y bits to the left.
 *  If you start shifting and you run out of space, the bits just “drop off”.
 *  For example:
 *  	00011001 << 2 = 01100100
 *  	00011001 << 4 = 10010000
 *  
 *  Right Shift: x >> y means x shifted y bits to the right. If you start shifting and you run out of space, the bits just “drop off” the end.
 *  Example:
 *  	00011001 >> 2 = 00000110
 *  	00011001 >> 4 = 00000001
 */


public class A_BasicOp {
	
	public static void main(String[] args) {
		int testVar = -20;
		
		System.out.println(~testVar);
		System.out.println(testVar<<2);
		System.out.println(testVar>>2);
		System.out.println(testVar>>>2);
		System.out.println(~testVar);
		
	}

}
