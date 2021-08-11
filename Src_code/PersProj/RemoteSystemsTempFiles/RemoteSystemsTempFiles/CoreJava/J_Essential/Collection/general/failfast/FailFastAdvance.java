package CoreJava.J_Essential.Collection.general.failfast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Three way to avoid ConcurrentModificationException.
 * 	- after modifying collection[after creating iterator] break the loop.
 * 	- Always use Iterator.remove for removing data from collection.
 * 	- Use another list[see the code below]
  *
 */

public class FailFastAdvance {
	
			
		public static void main(String args[]) { 
			 
			String statement ="My name is manish kumar";
			 ArrayList arrayList  = new ArrayList(Arrays.asList(statement.split(" ")));  //Unordered set
			// ArrayList arrayList1 = arrayList;
			 ArrayList arrayList1=new ArrayList();
			 arrayList1.addAll(arrayList);
			 for (Object str : arrayList)
			 {
				 System.out.println("String -> : " +str);
				 if (str.equals("My"))
				 {
					 arrayList1.remove(str);
				 }
			 } 
			 
			 for (Object str : arrayList1)
			 {
				 System.out.println("String -> : " +str);
				
			 } 
	 }
	


}
