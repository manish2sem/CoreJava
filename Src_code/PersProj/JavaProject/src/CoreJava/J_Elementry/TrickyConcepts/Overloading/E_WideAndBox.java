package CoreJava.J_Elementry.TrickyConcepts.Overloading;

/**
 * Very Importent - 
 * 	Widening alone is possible.  -> go(long x){} <-- go(5); 5 in int.
 *  Boxing alone is possible.   -> go(Long x) <-- go(lngVar);  
 *  
 *  But when both are combined [i.e. widening and autobox] compile time error.
 *  
 *  Strangely,  boxing operation followed by a widening operation is possible. se next ex

 * @author sinhama
 *
 */

public class E_WideAndBox {


	public static void main(String [] args) {
		int b = 5;
		go(b); // must widen then box - illegal
		
		//while this is possible
		
		long l = 5;
		go(l);// Boxing alone
	}

	static void go(Long x) { 
		System.out.println("Long"); 
	}
}

/**
 * Why didn't the compiler try to use the box-then-widen logic?
 * if it tried to box first, the byte would have been converted to a Byte. 
 * Now we're back to trying to widen a Byte to a Long, and of course, the IS-A test fails.
 */
