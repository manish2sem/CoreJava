package DS.Sorting.nLogn.QuickSort;
/**
 * the quicksort algorithm operates by partitioning an array into two subarrays and then calling itself recursively to quicksort each of these subarrays.
 * basic steps: 
 * 	- Partition the array or subarray into left (smaller keys) and right (larger keys) groups.
 * 	- Call ourselves to sort the left group.
 * 	- Call ourselves to sort the right group.
 * 
 * After a partition, all the items in the left subarray are smaller than all those on the right. 
 * If we then sort the left subarray and sort the right subarray, the entire array will be sorted.
 * 
 * Key-Point - recQuickSort(int left, int right)
 * The arguments to the recQuickSort() method determine the left and right ends of the array (or subarray) it’s supposed to sort. 
 * The method first checks if this array consists of only one element. If so, the array is by definition already sorted, and the method returns immediately.
 * 
 * partitionIt
 * If the array has two or more cells, the algorithm calls the partitionIt() method to partition it.
 * This method returns the index number of the partition: the left element in the right (larger keys) subarray. 
 * The partition marks the boundary between the subarrays.
 * See the comments of partitionIt for detail explanation.
 * After the partition, if the pivot is inserted at the boundary between the left and right subarrays, it will be in its final sorted position.
 **/
public class A_QuickSort {
	private long[] theArray; // ref to array theArray
	private int nElems;

	public A_QuickSort(int max)	{
		theArray = new long[max]; 
		nElems = 0; // no items yet
	}

	public void insert(long value) {
		theArray[nElems] = value; 
		nElems++; // increment size to pint next empty cell
	}


	public void display() {
		System.out.print("A= ");
		for(int j=0; j<nElems; j++) 
			System.out.print(theArray[j] + " "); 
		System.out.println(" ");
	}

	public void quickSort()	{
		recQuickSort(0, nElems-1);
	}


	public void recQuickSort(int left, int right){
		if(right-left <= 0) // if size <= 1,
			return; // already sorted
		//else {// size is 2 or larger

			long pivot = theArray[right]; // rightmost item
			// partition range
			int partition = partitionIt(left, right, pivot);
			System.out.println("partition = "+partition);
			recQuickSort(left, partition-1); // sort left side
			recQuickSort(partition+1, right); // sort right side
		//}
	}


	/**
	 * Ex Input Array : theArray -  42 89 63 12 94 27 78 3 50 36
	 * left -> 0; right->7; pivot=theArray[right]=36.
	 * 
	 * First iteration - 
	 * 	Step1 	(42) 89 63 12 94 27 78 3 50 36.  find bigger item than pivot starting from left;
	 *  Step2 	(42) 89 63 12 94 27 78 (3) 50 36.  find smaller item than pivot starting from right;
	 *  step3   (3) 89 63 12 94 27 78 (42) 50 36. swap 42 1nd 3. and go for 2md iteration. since still leftPtr < rightPtr
	 *  
	 *  Second iteration -
	 *  	Step1+2- 3 (89) 63 12 94 (27) 78 42 50 36.
	 *  	Step3- 3 (27) 63 12 94 (89) 78 42 50 36.
	 *  
	 *  Third iteration - 
	 *  	3 27 (63) (12) 94 89 78 42 50 36.
	 *  	3 27 (12) (63) 94 89 78 42 50 36.
	 *  Now the loop will break. with left pointer pointing on 63.
	 *  After this swap left pointer(63) to right(36).
	 *  
	 *  3 27 12 (36) 94 89 78 42 50 63.
	 *  
	 *  In this list every element left of 36 is smaller than every element on right 0f 36.
	 *  so 36 is in it's actual position.
	 *  
	 *  This same logic will be applied for every subArray lef  t of 36 and then right of 36.
	 */
	public int partitionIt(int left, int right, long pivot)	{
		//int leftPtr = left-1; // left (after ++)
		int leftPtr = left; // left (after ++)

		int rightPtr = right; // right-1 (after --)
		while(true)
		{ // find bigger item
		//	while( theArray[++leftPtr] < pivot )
		//		; // (nop)
			// find smaller item
			while( theArray[leftPtr] < pivot ){
				//if(leftPtr<right){
				    leftPtr++;
				//}
			}
			while(rightPtr > 0 && theArray[--rightPtr] > pivot)
				; // (nop)
			if(leftPtr >= rightPtr) // if pointers cross,
				break; // partition done
			else // not crossed, so
				swap(leftPtr, rightPtr); // swap elements
		} // end while(true)
		swap(leftPtr, right); // restore pivot
		return leftPtr; // return pivot location
	}

	public void swap(int dex1, int dex2) {		
		long temp = theArray[dex1]; 
		theArray[dex1] = theArray[dex2]; 
		theArray[dex2] = temp; 
	}
	
	public void createRandomArray(int maxSize, A_QuickSort arr){
		for(int j=0; j<maxSize; j++) {
			long n = (int)(java.lang.Math.random()*99);
			arr.insert(n);
		}
	}
	
	public void createSortedArray(int maxSize, A_QuickSort arr){
		for(int j=0; j<maxSize; j++) {
			arr.insert(j);
		}
	}


	public static void main(String[] args){
		int maxSize = 16; // array size
		A_QuickSort arr;
		arr = new A_QuickSort(maxSize); // create array
		arr.createRandomArray(maxSize, arr);
	//	arr.createSortedArray(maxSize, arr);
		arr.display(); // display items
		arr.quickSort(); // quicksort them
		arr.display(); // display them again
	}

}


/**
 * Analysis :
 * The partition algorithm runs in O(N) time: The two pointers start at opposite ends of the array and move toward each other at a more or less constant rate, 
 * stopping and swapping as they go.
 * 
 * In Partition logic The number of swaps depend on how the data is arranged.
 * 	Worst case - If it’s inversely ordered, and the pivot value divides the items in half, then every pair of values must be swapped.
 *  Best case - If it’s  ordered, and the pivot value divides the items in half, then there will be no swapping.
 * 
 */