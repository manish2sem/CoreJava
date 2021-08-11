package DS.Array.Basic.FindMax;

/**
 * Given an unsorted array. Find out the maximum number.  
 * Minimum number of comparisons. 
 * Then how to find out the second largest number.
 * how to find out the nth largest number.
 * @author sinhama
 *
 */

public class A_FindMax {
	public static void main(String[] args) {
		
		int myArray[] = {1, 2, 4, 7, 8, 4, 3, 9, 10, 2, 32, 6, 2, 8, 5, 41};
		System.out.println("Max of array is : "+findMax(myArray));
		
	}
	
	/**
	 * O(n).
	 * 
	 */
	public static int findMax(int myArray[]) {		
		int max = myArray[0];
		int count = 0;
		
		for(int i =1; i< myArray.length; i++) {			
			if(max < myArray[i]) {
				max = myArray[i];
				count++;
			}			
		}
		
		System.out.println("No. Of time max altered = "+count);
		return max;
	}

}
