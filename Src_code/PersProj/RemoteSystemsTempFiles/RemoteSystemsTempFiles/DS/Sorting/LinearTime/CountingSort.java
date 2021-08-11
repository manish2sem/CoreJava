package DS.Sorting.LinearTime;

/**
 * The basic idea of counting sort is to determine, for each input element x, the number of
elements less than x. This information can be used to place element x directly into its position
in the output array. For example, if there are 17 elements less than x, then x belongs in output
position 18. This scheme must be modified slightly to handle the situation in which several
elements have the same value, since we don't want to put them all in the same position.
 * @author sinhama
 * 
 * In the code for counting sort, we assume that the input is an array A[1  n], and thus
length[A] = n. We require two other arrays: the array B[1 n] holds the sorted output, and the
array C[0  k] provides temporary working storage.
 *
 */

public class CountingSort {
	
    public static void main(String[] args) {
    	
    	int input[] = {4,5,3,7,9,1,6};
    	int output[] = new int[input.length];
    	
    	int temp[] = new int[20];
    	
    	for (int i = 0; i < temp.length; i++ ) {
    		temp[i] = 0;
    	}
    	
    	for (int j = 0; j < input.length; j++ ) {
    		temp[input[j]] = temp[input[j]]+1;
    	}
    	//C[i] now contains the number of elements equal to i.
    	for (int i = 0; i < temp.length; i++ ) {
    		System.out.print(" " + temp[i]);
    	}

    		System.out.println(" " );
    	

    	for (int i = 1; i < temp.length; i++ ) {
    		temp[i] = temp[i] + temp[i-1];
    	}
    	
    	for (int i = 0; i < temp.length; i++ ) {
    		System.out.print(" " + temp[i]);
    	}
    	
    	for (int k = input.length; k >0 ; k-- ) {
    		
    		output[temp[input[k]]] = input[k];
    		temp[input[k]] = temp[input[k]]-1;
    	}
    	
    	for (int i = 0; i < output.length; i++ ) {
    		System.out.print(" " + output[i]);
    	}

    }

}
