package EffectiveJava.D_Generics.Item26;

import java.util.Arrays;
import java.util.EmptyStackException;


/**
 * Issue: Generifying array of type E.
 *  	elements = new E[DEFAULT_INITIAL_CAPACITY]; 

 * First Solution: 
 * 	create an array of Object and cast it to the generic array type.
 * 		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY]; 
 * 
 * This usage is legal, but it’s not (in general) typesafe:
 * compiler will emit a warning.
 * 
 * You can supress the warning but before that 
 * 	you need to prove that program is typesafe.
 * 
 * The array in question (elements) is stored in a private field and 
 never returned to the client or 
 passed to any other method. 
The only elements stored in the array are those passed to the push method,
which are of type E, so the unchecked cast can do no harm.
 */
public class B_GenericStack<E> {
	
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
		
	/**
	 * Solution1:
	 * create an array of Object and cast it to the generic array type.
	 * This usage is legal, but it’s not (in general) typesafe:
	 * compiler will emit a warning.
	 */
	public B_GenericStack() {
		//elements = new Object[DEFAULT_INITIAL_CAPACITY];
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		E result = elements[--size];
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
 * 
 * 
 */
