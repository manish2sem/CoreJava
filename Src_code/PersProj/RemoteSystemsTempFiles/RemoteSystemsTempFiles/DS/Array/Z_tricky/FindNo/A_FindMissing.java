package DS.Array.Z_tricky.FindNo;

/**
 * Given an array of 9 distinct integers ranging from 1 to 10 including. 
 * Find which number is missing. 
 * Restrictions: loop over the array only once, can't allocate an additional array.
 *
 */

public class A_FindMissing {
	
	public static void main(String[] args) {
		int myArray[] = {1,3,4,5,6,7,8,9,10};
		System.out.println("Missing is : "+xorMethod(myArray));
		
	}
	
	public static int sumMethod(int myArray[]){
		int sum = 0;
		int arrayLength = myArray.length;
		for(int i=0; i<arrayLength; i++) {
			sum = sum + myArray[i];
		}
		
		int expectedSum = (arrayLength+1)*(arrayLength+2)/2;
		return expectedSum-sum; 
	}
	
	public static int xorMethod(int myArray[]){
		int sumXor = 0;
		int arrayLength = myArray.length;
		for(int i=0; i<arrayLength; i++) {
			sumXor = sumXor ^ i ^ myArray[i];
		}
		
		
		return sumXor; 
	}

}
