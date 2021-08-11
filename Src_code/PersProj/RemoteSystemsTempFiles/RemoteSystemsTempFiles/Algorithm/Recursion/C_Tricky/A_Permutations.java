package Algorithm.Recursion.C_Tricky;

/**
 * Given an array of characters and the length of the array, print out 
           all the permutations of the array. Hint: you might need a helper method.

 * @author Manish
 * Our solution fixes the last element of the array instead of the first. You could 
  also fix the first letter.

 *
 */

public class A_Permutations {

	public static void main(String[] args) {
		char[] array = {'a', 'b', 'c', 'd', 'e'};

		System.out.println( "Using recursion, we get: " );
		permute(array, array.length);
	}
	
	public static void permute(char[] a, int length) {
	     if (length == 1) {
	        System.out.println(a);
	        return;
	     }
	     for (int i = 0; i < length; i++) {
	        swap(a, i, length-1);
	        permute(a, length-1);
	        swap(a, i, length-1);
	    }
	 }  
	 
	 public static void swap(char[] a, int i, int j) {
	    char c;
	    c = a[i]; 
	    a[i] = a[j]; 
	    a[j] = c;
	 }


}
