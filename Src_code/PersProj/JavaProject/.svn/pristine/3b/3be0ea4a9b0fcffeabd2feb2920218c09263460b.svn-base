package DS.BitWise.CommonTricks;

/**
 * TRICK_3:
 * 1<<n	sets only nth bit. 
 * 		Ex 1<<4 === 10000 
 * 
 * So Using 1<<n in various cases
 * 	- If the n-th bit is set in x -> x & 1<<n returns 1<<n else 0. 
 * 	- Set the n-th bit of x -> x | 1<<n 
 * 	- Toggles the state of the n-th bit of x -> x ^ 1<<n
 *
 */
public class C_OprOnNthBit {
	public static void main(String[] args) {
		isBitSet(37, 5);
		System.out.println(setNth(4));
	}
	
	public static int setNth(int n){
		return 1<<n;
	}
	
	public static int checkBitSet(int x, int n){
		return x & 1<<n;
	}
	
	public static int setNthBit(int x, int n){
		return x | 1<<n;
	}
	
	public static int toggleNthBit(int x, int n){
		return x ^ 1<<n;
	}
	
	public static void isBitSet(int x, int n){
		int result = checkBitSet(x, n);
		if(result == 0) {
			System.out.println(n+"th bit in " + x + " is not set" );
		}else{
			System.out.println(n+"th bit in " + x + " is set");
		}
	}
	
	

}
