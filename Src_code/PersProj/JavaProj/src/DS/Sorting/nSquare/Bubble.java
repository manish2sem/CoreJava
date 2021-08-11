package DS.Sorting.nSquare;

/**
 * In Every Iteration 
 * 	Element of outer loop(@index i) is compared with each each element of inner loop.
 *  if outer[i] > ineer[j] then swap. =>at i, we want smallest element, if it is large any of rest araay[i onward] move it to place i.
 *  
 *  So after pass1 we will have smallest at position 1.
 * 
 * 
 * @author Manish
 *Slow motion run of Bubble Sort (Bold == sorted region):
	4,3,1,5,6,2 <-Initial array
	
	(1):(4):3:5:6:2	After First iteration 1 will be at first position
	1:(2):(4):5:6:3 After Second iteration 2 will be at Second position
	1:2:3:5:6:4:
	1:2:3:4:6:5:
	1:2:3:4:5:6:
	1:2:3:4:5:6:
	1:2:3:4:5:6:
	
In Every itereation - 	(Pass1)
	4,3,1,5,6,2
	(4),(3),1,5,6,2 	-> first swap. as 4 > 3 i.e. out[i] > in[j(=2)] 
		3 4 1 5 6 2
	(3) 4 (1) 5 6 2		-> Second swap. as 3 > 1 i.e. out[i] > in[j(=3)] 
		1 4 3 5 6 2	 -> This is final output. as 1 is less than all other element. 	
	
 */

public class Bubble {

	public static void main(String[] args){
		Bubble bubble = new Bubble();
		bubble.bubbleSort();
	}

	public void bubbleSort(){
		int intData[] = {4,3,1,5,6,2};	
		int lengt = intData.length;
		boolean flag = false;

		for(int i=0; i<lengt; i++){
			for(int j=i+1; j<lengt; j++){
				if(intData[i] > intData[j] ){
					//swap(intData[i],intData[j]);
					int tmp = intData[i];
					intData[i] = intData[j];
					intData[j] = tmp;
				}
				
			/*	for(int k=0;k<lengt ;k++){

					System.out.print(intData[k]+":");
				}
				System.out.println();*/
			}
			for(int k=0;k<lengt ;k++){

				System.out.print(intData[k]+":");
			}
			System.out.println();
		}

		for(int k=0; k<lengt ;k++){

			System.out.print(intData[k]+":");
		}
	}


	private void swap(int x, int y){
		int temp=x;
		x=y;
		y=temp;		
	}


}
