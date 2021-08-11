package DS.BitWise.CommonTricks;

/**
 * Trick1:
 * 		x&(x-1)	 Returns number x with the lowest bit set off.
 * 
 * This implies => If x & ( x – 1) == 0
 * 				  then the number is a power of 2.
 * There is only one bit if no. is power of x.  Ex- 32 = 100000
 * With Trick1, lowest bit will set off === x & ( x – 1) for 32 will give 000000 i.e 0.
 *
 */

public class A_LowestBitSet {
	
	public static void main(String[] args) {
		
		System.out.println(Trick1(29));
		System.out.println(Trick1(44));

		//These are power of 2. 
		System.out.println(Trick1(32));
		System.out.println(Trick1(128));
		
		
	}
	
	public static int Trick1(int x){
		
		return x & (x-1);
	}

}
