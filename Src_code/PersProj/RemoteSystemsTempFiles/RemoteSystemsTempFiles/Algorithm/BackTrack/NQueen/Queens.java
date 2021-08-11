package Algorithm.BackTrack.NQueen;

/**
 *  Algo:
 *  - Try to form the logic for  canPlaceQueen();
 *  - if it can place go for next with recursion
 *  - If it can't, end the function which will trigger backtracking.
 *  - Stopping condition for the function.
 * 
 * Recursion takes care of back tracking automatically.
 * 	- Because it ends function when can't place queen. and
 *  - calls parent function which try function with different(increased) value postion. 
 */

public class Queens {

	   /***************************************************************************
	    * Return true if queen placement q[n] does not conflict with
	    * other queens q[0] through q[n-1]
	    ***************************************************************************/
	    public static boolean isConsistent(int[] q, int n) {
	        for (int i = 0; i < n; i++) {
	            if (q[i] == q[n])             return false;   // same column
	            if ((q[i] - q[n]) == (n - i)) return false;   // same major diagonal
	            if ((q[n] - q[i]) == (n - i)) return false;   // same minor diagonal
	        }
	        return true;
	    }

	   /***************************************************************************
	    * Print out N-by-N placement of queens from permutation q in ASCII.
	    ***************************************************************************/
	    public static void printQueens(int[] q) {
	        int N = q.length;
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                if (q[i] == j) System.out.print("Q ");
	                else           System.out.print("* ");
	            }
	            System.out.println();
	        }  
	        System.out.println();
	    }


	   /***************************************************************************
	    *  Try all permutations using backtracking
	    ***************************************************************************/
	    public static void enumerate(int N) {
	        int[] a = new int[N];
	        enumerate(a, 0);
	    }

	    public static void enumerate(int[] q, int n) {
	        int N = q.length;
	        if (n == N) printQueens(q);
	        else {
	            for (int i = 0; i < N; i++) {
	                q[n] = i;
	                if (isConsistent(q, n)) 
	                		enumerate(q, n+1);
	            }
	        }
	    }  


	    public static void main(String[] args) {
	        int N = Integer.parseInt(args[0]);
	        enumerate(N);
	    }

	}
