package DS.Sorting.nLogn.heapSort;

public class A_HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] intData = new int[]{1,4,7,6,10,23,5}; 
		display(intData);
		//System.out.println(5/2);
		CreateHeap(intData, intData.length);
		display(intData);
		TraverseHeap(intData);
		display(intData);
	}

	/**
	 * Below is the core part
	 * 	- index of parent = [index of n -1]/2
	 * 	- Parent should be greater than it's children.
	 * So once heap is created root will have largest element (for ascending sort)
	 * @param intData
	 */
	public static void CreateHeap(int[] intData, int arrayLength){

		//for(int i=0; i<intData.length; i++  ){
		for(int i=0; i<arrayLength; i++  ){
			int candidateInd = i;
			//int parentInd = (i-1)/2;
			while(candidateInd >=1  ){
				int parentInd = (candidateInd -1)/2;
				//int candidate = intData[candidateInd];
				//int parent = intData[(parentInd)];
				if (intData[parentInd] < intData[candidateInd]) {
					int temp = intData[parentInd];
					intData[parentInd] = intData[candidateInd];
					intData[candidateInd] = temp;	
				//	System.out.println("candidateid = "+ candidateInd);
				}else {
					break;
				}
				candidateInd = parentInd;
			}

		}

	}

	/**
	 * After crating heap root will be the largest.
	 * So swap root with last unprocessed element.
	 * and then recreate(rebalance using CreateHeap) the heap
	 * @param intData
	 */
	public static void TraverseHeap(int[] intData){
		System.out.println("Sorting - ");
		for(int i=intData.length; i>0; i--  ){
			int temp = intData[i-1];
			intData[i-1] = intData[0];
			intData[0] = temp;	
			display(intData);
			System.out.println("Rebalancing - ");

			CreateHeap(intData, i-1);
			display(intData);


			
		}

	}
	
	public static void display(int[] intData){
		for(int i=0; i<intData.length; i++  ){
			System.out.print(intData[i]+" ");			
		}
		System.out.println();
	}


	


}
