   package DS.Sorting.nSquare;
/**
 * select the minimum no from the list of data and swap it to the leftmost position. 
 * Now the leftmost data is sorted and won’t need to be moved again.
 * Notice that in this algorithm the sorted data accumulate on the left (lower indices), 
 * whereas in the bubble sort they accumulated on the right.
 * 
 * 	5 : 7 : 3 : 2 : 1 : 8 : 4 
 * 								min -> 1 swap (5,1)
 * 	1 : 7 : 3 : 2 : 5 : 8 : 4   min -> 2 swap (7,2)
 * 	1 : 2 : 3 : 7 : 5 : 8 : 4 	min -> 3 swap (3,3)
 * 	1 : 2 : 3 : 7 : 5 : 8 : 4 	min -> 4 swap (7,4)
 * 	1 : 2 : 3 : 4 : 5 : 8 : 7 	min -> 5 swap (5,5)
 * 	1 : 2 : 3 : 4 : 5 : 8 : 7 	min -> 7 swap (8,7)
 * 	1 : 2 : 3 : 4 : 5 : 7 : 8 	min -> 8 swap (8,8)
 * 	1 : 2 : 3 : 4 : 5 : 7 : 8 	---> Output
 * 
 * 
 * 1 : 2 : 3 : 4 : 5 : 7 : 8 
 * @author Manish
 *
 */
public class SelectionSort {
	
	public static void main(String[] args){
		SelectionSort selectionSort = new SelectionSort();
		int[] unSortedData = {5,7,3,2,1,8,4};
		selectionSort.display(unSortedData);
		selectionSort.sort(unSortedData);
		System.out.println();
		selectionSort.display(unSortedData);
	}
	
	
	private void sort(int[] unsortedList){
		for (int i=0; i<unsortedList.length; i++){
			int min = unsortedList[i];
			int index = i;
			for (int j=i+1; j<unsortedList.length; j++){
				if(unsortedList[j] < min){
					min = unsortedList[j];
					index = j;
				}
			}
			unsortedList[index] = unsortedList[i];
			unsortedList[i] = min;	
			display(unsortedList);
			System.out.println();
		}
		
	}
	
	private void display(int[] data){
		for (int i=0; i< data.length; i++){
			System.out.print(data[i] + " : ");
		}
	}

}
