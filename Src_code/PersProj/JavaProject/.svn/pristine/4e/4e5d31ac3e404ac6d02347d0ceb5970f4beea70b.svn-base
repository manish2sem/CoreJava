package CoreJava. J_Elementry.WrapperClass.Boxing;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Manish
 * 
 * Unboxing converts wrapper class reference (like an Integer or a Long) to a primitive.
 * 
 * When using legacy (non-type safe) collections—watch out for unboxing problems! 
 * If you declare a non-generic collection, the get() method ALWAYS returns a 
 * reference of type java.lang.Object. Remember that unboxing can’t convert a plain old 
 * Object to a primitive, even if that Object reference points to an Integer (or some other primitive) on the heap. 
 *
 */

public class A_Unboxng {
	public static void main (String [] args) {
		
		Integer x3 = new Integer(45);  
		int x4 = x3;                    //UnBoxing
		System.out.println("Autoboxed x4 : "+x4);
		long x5 = new Long(45);	//UnBoxing
		
		List<Integer> test2 = new ArrayList<Integer>();
		test2.add(343);			//AutoBoxing
		test2.add(new Integer(43));
		int y1 = test2.get(0);	//UnBoxing
		int y2 = test2.get(1);	//UnBoxing
		
		System.out.println("Autoboxed y2 : "+y2);
		
		
		
		List test = new ArrayList();
		test.add(43);		//AutoBoxing
		int x = (Integer)test.get(0); // you must cast !!
	}

}
