package CoreJava.J_Importent.CollectionsClass.Arrays.Sort;
import java.util.Arrays;

/**
 * the Arrays.sort() method is overloaded for almost every type of primitive. 
 * The Arrays.sort() methods that sort primitives always sort based on natural order.
 * Don't be fooled by interviwer that tries to sort a primitive array using a Comparator.
 * 
 * Finally, remember that the sort() methods for both the Collections class and the Arrays class are static methods, and 
 * that they alter the objects they are sorting, instead of returning a different sorted object.
 * 
 * In case of object, comparable or comparator can be used. 
 *
 */


public class A_SimpleSort {
	public static void main(String[] args) {
		String[] myStr = {"abc", "xyz", "abcd", "def", "lmn"};
		Arrays.sort(myStr);
		
		for(int i=0; i<myStr.length; i++) {
			System.out.println(myStr[i]);
		}		
	}

}
