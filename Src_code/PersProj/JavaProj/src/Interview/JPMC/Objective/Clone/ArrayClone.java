package Interview.JPMC.Objective.Clone;

/**
 * Wrong
 * @author Manish
 *
 */
public class ArrayClone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[][] ={{1,2,3},{4,5,6}}; 
		int copy[][] = data.clone();
		
		copy[0][0] = 100;
 
		System.out.println("data[0][0] = "+ data[0][0]);
		System.out.println("copy[0][0] = "+ copy[0][0]);

		copy[1] = new int[]{400,500,600};

		System.out.println("data[1][1] = "+ data[1][1]);
		System.out.println("copy[1][1] = "+ copy[1][1]);

	}

}
/**
*	Explained:
*		2D array is = 1 D array and each 1cell of 1D contains another 1D
*   int data[][] ={{1,2,3},{4,5,6}}; 
*   		This is equal to 
*   	data[0] = [1][2][3]	
*   	data[1] = [4][5][6]	
*   When cloned array contains same element as source.
*   so Copy[0] and copy[1] contains the same reference as data[0] and data[1].
*   
*   So if d[0][0] is changed then
*   it will be reflected in c[0][0] as both can be retrieved using same reference.
*
*
*
*/
