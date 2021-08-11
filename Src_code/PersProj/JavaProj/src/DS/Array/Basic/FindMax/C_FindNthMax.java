package DS.Array.Basic.FindMax;

/**
 *  To find out the nth largest number.
 *  
 *  Core Logic-> Insertion sort.
 *
 */

public class C_FindNthMax {

	public static void main(String[] args) {

		int myArray[] = {21, 2, 6, 3, 8, 4, 3, 9, 10, 2, 32, 6, 2, 8, 5, 41};

		int n = 5;

		int resultArray[] = findNthMax(myArray, n);
		
		for(int i =0; i<n; i++){
			System.out.println("Max of array is : "+resultArray[i]);
		}



	}

	public static int[] findNthMax(int myArray[], int n) {	
		int maxN[] = new int[n];

		//Building initial sorted array with first 5 element. in descending order. Logic in insertion-Sort. 
		maxN[0] =  myArray[0];
		for(int i =1; i<n; i++){
			int position = i;
			while(position > 0 && myArray[i] > maxN[position-1]){
				maxN[position] = maxN[position-1];
				position--;
			}
			maxN[position] = myArray[i];			
		}
		for(int i =0; i< n; i++){
			System.out.println("Max of array is : "+maxN[i]);
		}

		int count = 0;



		for(int i = n; i< myArray.length; i++) {			
			if(  myArray[i] > maxN[n-1]) {
				int position = n-1;
				while(position > 0 && myArray[i] > maxN[position-1]){
					maxN[position] = maxN[position-1];
					position--;
				}
				maxN[position] = myArray[i];	
			}			
		}

		System.out.println("No. Of time max altered = "+count);
		return maxN;

	}
}
