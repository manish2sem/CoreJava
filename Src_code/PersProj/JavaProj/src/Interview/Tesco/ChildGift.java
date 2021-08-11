package Interview.Tesco;

/**
 * Children are asked to read books.
 * there is some time to read the each book. and points are awarded to read books.
 * In given fixed time they need to read book in such a way that points are more
 * input1 - No. of books
 * input2 - time to read
 * input3 - points for each book
 * input4 - time to read each book
 * 
 * Goal - Optimize the point
 * 
 * 4, 10, {2,4,5,6},new int[]{3,3,5,7}
 * 
 * @author Manish
 *
 */

public class ChildGift {


	public static void main(String[] args) {
		System.out.println("Starting main ...");
		int result = Books(4, 10, new int[]{2,4,5,6},new int[]{3,3,5,7});
		System.out.println("Starting main ..." + result);
	}

	public static int Books(int input1, int input2, int[] input3, int[] input4){
		int result=0;

		float div[][] = new float[input1][2];
		for (int i=0; i<input1; i++){		
			float rslt = (float)input3[i]/(float)input4[i];					
			div[i][0] = rslt;
			div[i][1] = i;		
		}

		int length = div.length;
		for(int i=0; i<length; i++){
			for(int j=i+1; j<length; j++){
				if(div[i][0] <= div[j][0] ){
					//swap(intData[i],intData[j]);
					float tmp[] = div[i];
					div[i] = div[j];
					div[j] = tmp;
				}
			}			
		}
		
		
		for(int i=0; i<input1; i++){
			int index = (int)div[i][1];
			if(input2> input4[index] ){
				result = result + input3[index];
				input2 = input2 - input4[index];
			}
		}
		
		return result;

	}
}
