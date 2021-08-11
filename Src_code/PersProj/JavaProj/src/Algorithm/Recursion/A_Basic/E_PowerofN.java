package Algorithm.Recursion.A_Basic;

/**
 * Power of N :
 * 
 * 	F(x) = x * F(x-1);
 *  Stopping cond :
 *  	F(x) == 1; when x=0;
 *  	F(x) == a; when x =1;
 * @author Manish
 *
 */

public class E_PowerofN {

	public static void main(String[] args) {
		System.out.println("Starting main ...");
		int power = powerN(6,3);
		
		System.out.println("power = " +power);
	}
	
	public static int powerN( int base, int pow){
		//Stopping condition
		if (pow<=0){
			return 1;
		}
		
		if (pow==0){
			return base;
		}
		
		return base * powerN(base, pow-1);
	} 

}
