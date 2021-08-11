package Interview.JPMC.Objective;

import java.util.HashSet;
import java.util.Set;

/**
 * Wrong
 * @author Manish
 * adding short and removing int.
 * Why int? because of i-1; any expression involves less than int promoted to int automatically.
 * 
 *
 */
public class RemovePrev {

	public static void main(String[] args) {
		//Set<Short> set = new HashSet<Short>();
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<100; i++){
			set.add(i);
			//System.out.println();
			set.remove(i-1);
			set.remove((short)(i-1));
		}
		System.out.println("Size " + set.size());
	
		for(Short i=0; i<100; i++){
			//set.add(i);
			//System.out.println();
			//set.remove(i-1);
	//		set.remove((short)(i-1));
		}
		
		System.out.println("Size " + set.size());
	}

}
