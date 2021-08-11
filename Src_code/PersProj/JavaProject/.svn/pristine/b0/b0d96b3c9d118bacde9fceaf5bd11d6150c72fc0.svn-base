package EffectiveJava.A_Objects.Item6.MemoryLeak;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 
 * The program has a “memory leak,” which can silently manifest itself as reduced performance due to
 * increased garbage collector activity or 
 * increased memory footprint. 
 * In extreme cases, such memory leaks can cause disk paging and even program failure with an OutOfMemoryError, but such failures are relatively rare.
 * 
 * Can you spot the "memory leak"?
 *
 */

public class StackCls {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	public StackCls() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		return elements[--size];
	}
	/**
	 * Ensure space for at least one more element, roughly
	 * doubling the capacity each time the array needs to grow.
	 */
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
}

/**
 * If a stack grows and then shrinks, the objects that were popped off the stack will not be garbage collected, 
 * even if the program using the stack has no more references to them. 
 * This is because the stack maintains obsolete references to these objects. 
 * An obsolete reference is simply a reference that will never be dereferenced again. 
 * In this case, any references outside of the “active portion” of the element array are obsolete. 
 * The active portion consists of the elements whose index is less than size.
 * 
 * If an object reference is unintentionally retained, not only is that object excluded from garbage collection, 
 * but so too are any objects referenced by that object, and so on. 
 * Even if only a few object references are unintentionally retained, many, many objects may be prevented from being garbage collected, 
 * with potentially large effects on performance.
 * 
 * The fix for this sort of problem is simple: null out references once they become obsolete.
 * See the pop() method of EffectiveJava.A_Objects.Item6.MemoryLeak.StackClsLeakFixed.
 * 
 * */

