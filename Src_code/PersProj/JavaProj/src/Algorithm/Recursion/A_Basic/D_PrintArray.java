package Algorithm.Recursion.A_Basic;

public class D_PrintArray {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6};

		System.out.println( "Using recursion, we get: " );
		printArray(array, 0);
		//recursivePrint(array, 0);
	}

	public static void recursivePrint(int[] array, int index) {
		if (index != array.length) {
			// Recursively call this method with an index argument that is 
			// greater than the current index by 1.
			recursivePrint(array, index + 1);

			// Print the array element at index.
			System.out.println( array[index] );
		}
	}

	public static void printArray(int[] array, int index) {
		if (index != array.length) {		
			System.out.println( array[index] );
			printArray(array, index + 1);
		}
	}

}
