package DS.Sorting.nLogn.QuickSort;

public class B_QuickSort {
	
	private long[] theArray; // ref to array theArray
	private int nElems;

	public B_QuickSort(int max)	{
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
	
	
	public void swap(int dex1, int dex2) {		
		long temp = theArray[dex1]; 
		theArray[dex1] = theArray[dex2]; 
		theArray[dex2] = temp; 
	}
	
	public void createRandomArray(int maxSize, B_QuickSort arr){
		for(int j=0; j<maxSize; j++) {
			long n = (int)(java.lang.Math.random()*99);
			arr.insert(n);
		}
	}
	
	public static void main(String[] args){
		int maxSize = 16; // array size
		B_QuickSort arr;
		arr = new B_QuickSort(maxSize); // create array
		arr.createRandomArray(maxSize, arr);
		arr.display(); // display items
		arr.quickSort(); // quicksort them
		arr.display(); // display them again
	}

}
