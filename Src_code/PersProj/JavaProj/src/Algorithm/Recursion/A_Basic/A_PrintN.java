package Algorithm.Recursion.A_Basic;

/**
 * f(x) = f(x-1); x>0
 * @author Manish
 *
 */
public class A_PrintN {

	public static void main(String[] args) {
		System.out.println("Starting main ...");
		printN(5);

	}
	
	public static void printN(int x){
		//Stopping condition
		if (x<=0){
			return;
		}
		
		System.out.println(x);
		printN(x-1);
		System.out.println(x);

	} 

}

/**
 * Time Complexity:
 * 	f(x) = f(x-1); x>0
 * and f(0) = C.
 * Using mathematics induction:
 *  f(0) = C;
 *  f(1) = f(1-1) i.e f(0)
 *  f(2) = f(2-1) i.e f(1) = C
 * 	
 * 
 * 
 */
