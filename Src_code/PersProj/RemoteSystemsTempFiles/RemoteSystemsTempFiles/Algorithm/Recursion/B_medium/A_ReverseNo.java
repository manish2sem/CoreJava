package Algorithm.Recursion.B_medium;

/**
 * 
 * Subproblem:
 * 	x%10 = last digit
 *  x/10 = All digit except last i.e. remaining
 *  
 *  Stopping condition
 *  	when remaining >0
 * @author Manish
 *
 */

public class A_ReverseNo {

	public static void main(String[] args) {
		printreverse(12345);
	}

	public static void printreverse(int  no) {

		System.out.print(no%10);

		if(no/10 <= 0) {
			return;
		}

		printreverse(no/10);

	} 

}
