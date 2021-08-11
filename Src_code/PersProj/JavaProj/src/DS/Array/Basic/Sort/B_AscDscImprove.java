package DS.Array.Basic.Sort;

/**
 * This is based on A_AscDsc.
 * Output is wrong.
 * Try to get the issue and correct it.
 * 
 * @author sinhama
 *
 */
public class B_AscDscImprove {

	public static void main(String[] args) {

		int[] unSortedData = {5,7,3,2,1,8,4,13,6,34,5,2};
		sortAscDsc(unSortedData);

		System.out.println();
		display(unSortedData);

	}

	public static void sortAscDsc(int evenSort[]){

		for(int i=0; i<evenSort.length ; i++ ) {
			for(int j=i; j<evenSort.length ; j++ )  {

				if (i%2 == 0) {
					if(evenSort[i] > evenSort[j]){
						int temp = evenSort[i];
						evenSort[i] = evenSort[j];
						evenSort[j] = temp;

					}
				}else{
					if(evenSort[i] < evenSort[j]){
						int temp = evenSort[i];
						evenSort[i] = evenSort[j];
						evenSort[j] = temp;

					}
				}
			}
		}
	}
	
	private static void display(int[] data){
		for (int i=0; i< data.length; i++){
			System.out.print(data[i] + " : ");
		}
	}

}
