package EffectiveJava.D_Generics.Item26;

import java.util.Arrays;
import java.util.EmptyStackException;


/**
 * Second Solution: 
 * 	change the type of the field elements from E[] to Object[].
 * 
 * Then cast the element retrieved from the array from Object to E:
 * 			E result = (E)elements[--size];
 * 
 * Before suppressing the warning
 * 	 prove and document that unchecked cast is safe.
 *
 */
public class C_GenericStack<E> {
	
	//private Object[] elements;
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	/**
	 * you can’t create an array of a non-reifiable type, such as E. - Item 25
	 * See the below two solutions
	 */
	
	public C_GenericStack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	
	

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		//Object result = elements[--size];
		E result = (E)elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		return result;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

}
/**
 * 
 * Which is better:
 * 	it is riskier to suppress an unchecked cast to an array type than to a scalar type. 
 * 		This favors second solution.
 * In realistic Situation, you will be reading from the array at many points in the code, 
 * so choosing the second solution would require many casts to E rather than a single cast to E[].
 * So the first solution is used more commonly.
 * 
 * This depends on you if above factors doesn't count. 
 * 
 */
