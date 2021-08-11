package DS.Sorting.LinearTime;

/**
 * 
 * Find the MAX from given input_array.
 * Create new_array of MAX : new int[MAX]
 * Iterate input_array and 
 * 		increase the value of new array for index of 
 * 		new_array[i]++;
 * 
 * 
 * @author MAKUM
 *
 */

public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] intData = new int[]{1,4,7,6,10,23,5}; 
		display(intData);
		//System.out.println(5/2);
		radixSort(intData);
		display(intData);

	}


	public static void radixSort(int[] intData){

		int max = intData[0];
		for(int i=1; i<intData.length; i++  ){
			if (max < intData[i]){
				max = intData[i];
			}
						
		}
		System.out.println("max  is : " + max);

		int[] newArray = new int[max+1]; 

		for (int i=0; i < intData.length; i++ ){

			int element = intData[i];
			newArray[element]++;
		}

		for (int i=0; i < newArray.length; i++ ){

			if(newArray[i] > 0){
				
				System.out.print(i + ", ");
			}
		}


	}

	public static void display(int[] intData){
		for(int i=0; i<intData.length; i++  ){
			System.out.print(intData[i]+" ");			
		}
		System.out.println();
	}

}
