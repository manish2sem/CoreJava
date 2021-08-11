package EffectiveJava.D_Generics.Item26;

import java.util.Arrays;
import java.util.EmptyStackException;


/**
 * to parameterize collection declarations is generally not too difficult. and
 * Also making use of the generic types and methods provided by the JDK is easy.
 * 
 * But Writing your own generic types is a bit difficult !!
 * 
 * In this example our target is to generify simple stack implementation from Item 6:
 * 
 * steps to generify 
 *  - add one or more type parameters to its declaration. 
 *  	Here there is only one type parameter(E), representing the element type of the stack. 
 *  - replace all the uses of the type Object with the appropriate type parameter.
 *  	Replace Objec to E.
 *
 */
public class A_GenericStack<E> {
	
	//private Object[] elements;
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	/**
	 * you can’t create an array of a non-reifiable type, such as E. - Item 25
	 * There are two way to fix this issue
	 * See the Next class
	 */
	
	public GenericStack() {
		//elements = new Object[DEFAULT_INITIAL_CAPACITY];
		elements = new E[DEFAULT_INITIAL_CAPACITY];
	}
	
	

	//public void push(Object e) {
	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	//public Object pop() {
	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		//Object result = elements[--size];
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
 * After generifying as (suggested by above) this class generates one error.
 * 			elements = new E[DEFAULT_INITIAL_CAPACITY]; 
 * And reason is :
 * 	An array of a non-reifiable type (such as E) can't be created. - Item 25
 * 
 * There are two ways to solve it.
 * 	See next two class
 * 
 */
