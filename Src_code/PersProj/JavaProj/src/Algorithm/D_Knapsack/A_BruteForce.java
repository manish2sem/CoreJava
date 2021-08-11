package Algorithm.D_Knapsack;


/**
 * This uses back tracking
 *
 */
public class A_BruteForce {

	public static void main(String[] args) {
		System.out.println("main Starting ... ");
		int wts[] = {2, 3, 3, 4 };
		int values[] = {1, 2, 5, 9};
		int capacity = 7;

		int max = ksBruteForce(wts, values, capacity, 0);
		System.out.println("MAX = " + max);

	}

	public  static int ksBruteForce(int[] wt, int val[], int remainingWt, int itemNo) {
		if(remainingWt == 0 || wt.length == itemNo){
			return 0; //because no value is getting added
		}

		if(wt[itemNo] > remainingWt){
			return ksBruteForce(wt, val, remainingWt, itemNo+1);
		}

		int skip = ksBruteForce(wt, val, remainingWt, itemNo+1);
		int pick = val[itemNo] + ksBruteForce(wt, val, remainingWt-wt[itemNo], itemNo+1);
		return Math.max(skip, pick);

	}

}
