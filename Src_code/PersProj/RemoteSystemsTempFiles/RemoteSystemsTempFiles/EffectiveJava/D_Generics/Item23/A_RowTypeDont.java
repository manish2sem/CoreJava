package EffectiveJava.D_Generics.Item23;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * A class or interface whose declaration has one or more type parameters is a generic class or interface.
 * List<E> (read “list of E”). 
 * Generic classes and interfaces are collectively known as generic types.
 *
 * parameterized Type - List<String> (read “list of string”)
 * List - raw type corresponding to List<E>.
 * 
 * For all practical purposes, the raw type List behaves the same way as the interface type List.
 * @author Manish
 * 
 * If you accidentally put a coin into your stamp collection, 
 * the erroneous insertion compiles and runs without error:
 * You don’t get an error until you retrieve the coin from the stamp collection:
 * 
 * Burn In Mind:
 * you should not use raw types in new code,
 *
 */
public class A_RowTypeDont {
	
	public static void main(String[] args) {
		 List stamps = new ArrayList();
		 stamps.add(new Stamps());
		 stamps.add(new Coin());
		 
		 for(Iterator i = stamps.iterator(); i.hasNext();){
			 Stamps stamp = (Stamps)i.next();
			 
		 }
	}

}


class Stamps{}

class Coin{}

/**
 * it pays to discover errors as soon as possible after they are made, ideally at compile time.
 *  In this case, you don’t discover the error till runtime.
 *  
 *  Once you see the ClassCastException, you have to search through the code base 
 *  looking for the method invocation that put the coin into the stamp collection. 
 *  The compiler can’t help you, because it can’t understand the comment that says, “Contains only Stamp instances.”
 *  
 *  When stamps is declared with a parameterized type, 
 *  the erroneous insertion generates a compile-time error message that tells you exactly what is wrong:
 *  As an added benefit, you no longer have to cast manually when removing elements from collections.
 *  
 *  This problem has practical significance:
 *  	putting a java.util.Date instance into a collection 
 *  	that is supposed to contain only java.sql.Date instances.
 *  
 *  Burn in Mind : 
 *  	If you use raw types, you lose all the safety and expressiveness benefits of generics.
 *  The language designers still allow them only To provide backward compatibility.
*/
