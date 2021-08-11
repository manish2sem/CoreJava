package Algorithm.C_LongestCommonSubsequence;

/**
 * Given two strings find a longest subsequence common to both.
 * 
 * A substring is a continuous sequence of characters from a string 
 * where as a subsequence is not necessarily a continuous sequence but maintains an order or characters.
 * String 1: A L P H A N U M E R I C
 * Substrings : N U M E R I C
 * Subsequences : N M E R C
 * 
 * BURN IN MIND :  longest common subsequence of the prefix strings, is a prefix of the longest common subsequence of the original strings.
 * 
 * Forming subProblem:
 * Let L[i-1, j-1] is LCS of X[i-1] and Y[j-1], Now
 * Now we compare the next characters X[i] and Y[j],
 * 	- If both of them match then Li,j would be L[i-1, j-1]+1
 *  - If both of them don’t match then Li,j would be maximum of L[i-1, j] and L[i, j-1].
 * 
 * This gives the idea of recursive solution.
 * @author Manish
 *
 */
public class C_DP_LongestCS {

	public static void main(String[] args) {

	}

}
