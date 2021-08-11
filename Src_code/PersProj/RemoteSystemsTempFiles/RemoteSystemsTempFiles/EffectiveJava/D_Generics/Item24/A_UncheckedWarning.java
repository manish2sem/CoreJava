package EffectiveJava.D_Generics.Item24;

import java.util.Arrays;
import java.util.Objects;
/**
 * The SuppressWarnings annotation can be used at any granularity.
 *  from an individual local variable declaration to an entire class. 
 *  
 *  RULE - Always use the Suppress- Warnings annotation on the smallest scope possible. 
 *  Typically this will be a variable declaration or a very short method or constructor.
 * 
 * Code:
 *	This this toArray method, comes from ArrayList Class of java.
 *	This method generates this warning at return statement for unchecked cast from Object[] to T[].
 * 	It is illegal to put a SuppressWarnings annotation on the return statement, 
 *  because it isn’t a declaration.
 *  
 *  You may put the annotation on the entire method, but don’t. -> toArraySupressed(T[] a) 
 *  Instead, declare a local variable to hold the return value and
 *  	 annotate its declaration.  -> toArrayCleanSupressed(T[] a) 
 */

public class A_UncheckedWarning<E> {
	int size;
	private final E[] elements;
	
	A_UncheckedWarning(E[] array) {
		elements = Objects.requireNonNull(array);
    }
	
	public static void main(String[] args) {

	}
		
	
	public <T> T[] toArray(T[] a) {
		if (a.length < size)
			return (T[]) Arrays.copyOf(elements, size, a.getClass());
		System.arraycopy(elements, 0, a, 0, size);
		if (a.length > size)
			a[size] = null;
		return a;
	}
	
	/**
	 * You may put the annotation on the entire method, but don’t.
	 * This is done in original java code - see Arrays.class - 3821.
	 */
	@SuppressWarnings("unchecked")
	public <T> T[] toArraySupressed(T[] a) {
		if (a.length < size)
			return (T[]) Arrays.copyOf(elements, size, a.getClass());
		System.arraycopy(elements, 0, a, 0, size);
		if (a.length > size)
			a[size] = null;
		return a;
	}
	
	/**
	 * Best Solution:
	 *  Declare a local variable to hold the return value and 
	 *  annotate its declaration. 
	 */
	public <T> T[] toArrayCleanSupressed(T[] a) {
		if (a.length < size){
			@SuppressWarnings("unchecked") 
			T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());
			return result;			
		}
		System.arraycopy(elements, 0, a, 0, size);
		if (a.length > size)
			a[size] = null;
		return a;
	}
}

/**
 * Scope of SuppressWarnings annotation 
 * from an individual local variable declaration to an entire class. 
 * This includes 
 * 	- Local Variable,
 * 	- Constructor,
 *  - Method,
 *  - Class.
 */
