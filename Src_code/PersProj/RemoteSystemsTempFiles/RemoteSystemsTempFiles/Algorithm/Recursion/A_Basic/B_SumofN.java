package Algorithm.Recursion.A_Basic;

/**
 * Sum of N :
 * 
 * 	F(x) = x + F(x-1);
 *  Stopping cond :
 *  	x == 1; 
 * @author Manish
 *
 */
public class B_SumofN {

	public static void main(String[] args) {
		System.out.println("Starting main ...");
		int sum = SumN(5);
		
		System.out.println("Sum = " +sum);


	}
	
	public static int SumN(int x){
		//Stopping condition
		if (x<=1){
			return 1;
		}
		
		return x + SumN(x-1);
	} 

}

/**
 * Time Complexity:
 * 	f(x) = x + f(x-1);
 * and f(1) = 1.
 * Using mathematics induction:
 *  f(1) = 1;
 *  f(2) = 2 + f(1) = 3
 *  f(3) = 3 + f(3-1) = 3 +  f(2) = C
 *  f(n) = n + f(n-1)
 *  	 = n + (n-1) + f(n-2)
 *  	 = n + (n-1) + (n-2) + ...... + 2 + 1.
 *  	 = nA + C
 *  	 = O(n) 
 *  
 *  Using Recurrence
 *  	f(x) = x + f(x-1);
 *  	X = X + C.
 * 	
 * 
 * 
 */

