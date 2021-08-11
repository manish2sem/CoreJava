package DS.BitWise.CommonTricks;

/**
 * Trick2
 * x ^ ( x & (x-1 )	 Returns the lowest bit of a number x.
 * 
 * From TRICK_1 we have   x & (x-1) sets lower bit off. Note, just lower bit all other bit will remain same.
 * So when we XOR[x & (x-1)] this to x all bit will set 0 other than lower bit(being unequal).
 * So it returns just lowerbit.
 * 
 * Ex - x = 44 i.e 101100
 * 		x ^ ( x & (x-1 ) will return 100 i.e. 4.
 *
 */
public class B_LowestBit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(lowestBit(29));
		System.out.println(lowestBit(44));

		//These are power of 2. 
		System.out.println(lowestBit(32));
		System.out.println(lowestBit(128));

	}
	
	public static int lowestBit(int x){
		
		return x ^ ( x & (x-1 ));
	}

}
