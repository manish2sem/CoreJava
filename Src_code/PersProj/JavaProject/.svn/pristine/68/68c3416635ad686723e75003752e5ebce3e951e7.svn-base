 package DS.Sorting.nSquare;

/**
 * Imagine given data is already paritialy sorted. 
 *  - If not imagine left most element, is of list with size 1, is partially sorted.
 *  then select leftmost data from unsorted list and insert it into partially sorted list.
 *  Do it for every element of unsorted list.
 *  
 *  5 : 7 : 3 : 2 : 1 : 8 : 4 
 *  							 ==> j->7  5 7  nochange
 *  5 : 7 : 3 : 2 : 1 : 8 : 4    ==> j->3  5 7 3 -> 3 5 7
 *  3 : 5 : 7 : 2 : 1 : 8 : 4 	 ==> j->2  3 5 7 2 -> 2 3 5 7
 *  2 : 3 : 5 : 7 : 1 : 8 : 4 	 ==> j->1  2 3 5 7 1 -> 1 2 3 5 7	
 *  1 : 2 : 3 : 5 : 7 : 8 : 4 	 ==> j->8  1 2 3 5 7 8 -> no change
 *  1 : 2 : 3 : 5 : 7 : 8 : 4 	 ==> j->4  1 2 3 5 7 8 4-> 1 2 3 4 5 7 8 
 *  1 : 2 : 3 : 4 : 5 : 7 : 8 
 *   
 * @author Manish
 * 
 * Logic:
 * 	record element and it's index to be inserted.
 *  compare the element to the sorted list from last till 
 *  	either first element(index=0) or
 *      element which is lesser
 *  While comparing if any bigger element is encountered then it is shifted to right.
 *  
 *  At the end of loop just copy the element to be sorted to the index found (in loop).
 *      
 *  
 *
 */

public class InsertionSort {
	
	public static void main(String[] args){
		InsertionSort insertionSort = new InsertionSort();
		int[] unSortedData = {5,7,3,2,1,8,4};
		insertionSort.display(unSortedData);
		insertionSort.sort(unSortedData);
		System.out.println();
		insertionSort.display(unSortedData);
	}
	
	private void sort(int[] unsortedList){
		/*
		int min =1000;
		int indexOfMin=0;
		for (int i=0; i< unsortedList.length; i++){
			if(unsortedList[i]<min){
				min = unsortedList[i];
				indexOfMin = i;
			}
		}
		if (indexOfMin>0){
			unsortedList[indexOfMin] =  unsortedList[0];
			unsortedList[0] = min;
		}*/
		
		for (int j=1; j < unsortedList.length; j++){
			int toBeInserted = unsortedList[j];	
			int indexOfToBeInserted = j;
			while(indexOfToBeInserted > 0 && unsortedList[indexOfToBeInserted-1] > toBeInserted){
				unsortedList[indexOfToBeInserted]=unsortedList[indexOfToBeInserted-1];
				indexOfToBeInserted--;
			}
			unsortedList[indexOfToBeInserted] = toBeInserted;
			display(unsortedList);
			System.out.println();
			/*for (int i=0; i < j; i++){
				if (toBeInserted<unsortedList[i]){
					
				}
			}*/
		}
		
	}
	
	private void display(int[] data){
		for (int i=0; i< data.length; i++){
			System.out.print(data[i] + " : ");
		}
	}

}
