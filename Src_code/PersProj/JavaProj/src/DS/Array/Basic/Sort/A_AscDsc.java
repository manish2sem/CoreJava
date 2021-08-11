package DS.Array.Basic.Sort;
/**
 * Given an array sort all the elements in even positions in ascending order and 
 * odd positions in descending order.
 *
 */
public class A_AscDsc {

	public static void main(String[] args) {

		int[] unSortedData = {5,7,3,2,1,8,4,13,6,34,5,2};
		sortAscEven(unSortedData);
		sortDscOdd(unSortedData);
		System.out.println();
		display(unSortedData);

	}

	public static void sortAscEven(int evenSort[]){
		
		for(int i=0; i<evenSort.length ; i=i+2 ) {
			for(int j=i; j<evenSort.length ; j=j+2 )  {
				if(evenSort[i] > evenSort[j]){
					int temp = evenSort[i];
					evenSort[i] = evenSort[j];
					evenSort[j] = temp;
					
				}
			}
		}
	}

	public static void sortDscOdd(int oddSort[]){
		for(int i=1; i<oddSort.length ; i=i+2 ) {
			for(int j=i; j<oddSort.length ; j=j+2 )  {
				if(oddSort[i] < oddSort[j]){
					int temp = oddSort[i];
					oddSort[i] = oddSort[j];
					oddSort[j] = temp;
					
				}
			}
		}
	}
	
	private static void display(int[] data){
		for (int i=0; i< data.length; i++){
			System.out.print(data[i] + " : ");
		}
	}
	
	public static void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	} 
}
