package DS.BitWise;

/**
 * Bitwise and &; Bitwise or |; Bitwise not ~.
 * Xor (^):
 * 		0 ^ 0 = 0
 * 		1 ^ 0 = 1
 * 		0 ^ 1 = 1
 * 		1 ^ 1 = 0
 * 
 * Left Shift: x << y means x shifted y bits to the left. If you start shifting and you run out of space, the bits just “drop off”.
 *  For example:
 *  	00011001 << 2 = 01100100
 *  	00011001 << 4 = 10010000
 *  
 *  Right Shift: x >> y means x shifted y bits to the right. If you start shifting and you run out of space, the bits just “drop off” the end.
 *  Example:
 *  	00011001 >> 2 = 00000110
 *  	00011001 >> 4 = 00000001
 */

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to set all bits between i and j in N equal to M (e.g., M becomes a substring of N located at i and starting at j).
 * 		EXAMPLE: 
 * 			Input: N = 10000000000, M = 10101, i = 2, j = 6
 * 			Output: N = 10001010100
 * @author sinhama
 *
 */
public class Problem1 {
	public static void main(String[] args) {
		System.out.println(setNbit(300, 40, 2, 5));
	}

	
	public static int setNbit(int n, int m, int i, int j) {
		int max = ~0; /* All 1’s */
		int left = max - ((1 << j) - 1);
		int right = ((1 << i) - 1);
		int mask = left | right;

		return (n & mask) | (m << i);
	}

}
