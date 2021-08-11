package CoreJava.J_Basic.Clone.B_Array;

/**
 * 
 * When clone method is invoked on array,
 * It returns reference of new array which contains same element as source.
 * But if source is modified it s not reflected new array.
 * 
 * @author Manish 
 *
 */

public class CloningArray {
	public static void main(String[] args) {
		int[] a = {1,2,3};
		int[] b = a.clone();
		
		a[2]=10;
		
		System.out.println("b[2]= "+b[2]);
	}
}
