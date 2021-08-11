package Algorithm.D_Knapsack;

public class B_DP_Knapsack {

	public static void main(String[] args) {
		System.out.println("main Starting ... ");
		int wts[] = {2, 3, 3, 4, 6 };
		int values[] = {1, 2, 5, 9, 4};
		int capacity = 10;

		int maxVal = knapsack(wts, values, capacity);
		System.out.println("Maximum value : " +maxVal);
	}

	private static int knapsack(int[] w, int[] v, int W) {
		int[][] dp = new int[w.length][W + 1];
		dp[0][0] = 0;

		initializeMatrix(dp, w, v);
		displayMatrix(dp);

		for (int i = 1; i < dp.length; i++) {
		    for (int j = 1; j < dp[i].length; j++) {
		      // if a weight is more than the allowed weight, that weight cannot be picked.
		        if(w[i] > j){
		          dp[i][j] = dp[i-1][j];
		        }else{
		          dp[i][j] = Math.max(dp[i-1][j], v[i] + dp[i-1][j-w[i]]);
		        }
		      }
		    }
		    return dp[dp.length-1][W];		
	}
	
	/**
	 * Initialization of matrix.
	 * This initializes first row.
	 */
	private static void initializeMatrix(int[][] dp, int w[], int v[]) {
		for(int i = 1 ; i < dp[0].length; i++){
			if(w[0] <= i){
				dp[0][i] = v[0];
			}else{
				dp[0][i] = 0;
			}
		}
	}

	private static void displayMatrix(int[][] dp) {

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();

		}

	}



}
