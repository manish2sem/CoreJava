package DS.String.Z_Algo;

/**
 * The key point here is that from the mid of any palindrome, if we go to right and left by 1 place, it’s always same character.
 *  For example 12321, here mid is 3 and if we keep moving one position in both sides, we get 2 and then 1.
 *  We will use the same logic in our java program to find out the longest palindrome.
 *  However if the palindrome length is even, the mid size is also even, so we need to make sure in our program that 
 *  this is also checked, for example 12333321, here mid is 33 and if we keep moving one position in both sides, we get 3, 2 and 1.

In our java program, we will iterate over the input string with mid as 1st place and checking the right and left character.
 We will have two global variables to save the start and end position for palindrome. We also need to check if there is already a longer palindome found since there can we multiple palindome in the given string.
 * @author sinhama
 *
 */

public class LongestPalindrome {
	
	public static void main(String[] args) {
        System.out.println(longestPalindromeString("1234"));
        System.out.println(longestPalindromeString("12321"));
        System.out.println(longestPalindromeString("9912321456"));
        System.out.println(longestPalindromeString("9912333321456"));
        System.out.println(longestPalindromeString("77812145445499"));
    }
 
    /**
     * This method returns the longest palindrome in the input String
     * 
     * @param in
     * @return
     */
    public static String longestPalindromeString(String in) {
        char[] input = in.toCharArray();
        int longestPalindromeStart = 0;
        int longestPalindromeEnd = 0;
 
        for (int mid = 0; mid < input.length; mid++) {
            // for odd palindrom case like 12321, 3 will be the mid
            int left = mid-1;
            int right = mid+1;
            // we need to move in the left and right side by 1 place till they reach the end
            while (left >= 0 && right < input.length) {
                // below check to find out if its a palindrome
                if (input[left] == input[right]) {
                    // update global indexes only if this is the longest one till now
                    if (right - left > longestPalindromeEnd
                            - longestPalindromeStart) {
                        longestPalindromeStart = left;
                        longestPalindromeEnd = right;
                    }
                }
                left--;
                right++;
            }
            // for even palindrome, we need to have similar logic with mid size 2
            // for that we will start right from one extra place
            left = mid-1;
            right = mid + 2;// for example 12333321 when we choose 33 as mid
            while (left >= 0 && right < input.length)
            {
                if (input[left] == input[right]) {
                    if (right - left > longestPalindromeEnd
                            - longestPalindromeStart) {
                        longestPalindromeStart = left;
                        longestPalindromeEnd = right;
                    }
                }
                left--;
                right++;
            }
        }
        // we have the start and end indexes for longest palindrome now
        return in.substring(longestPalindromeStart, longestPalindromeEnd + 1);
    }

}
