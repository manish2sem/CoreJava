package EffectiveJava.C_ClsIf.Item16;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;



/**
 * A_InstrumentedHashSet extends HashSet and 
 * uses add and addAll methods of HashSet to keep track of it's own insertion.
 * 
 * This class looks reasonable, but it doesn’t work!!
 * We expect the getAddCount method to return three, but it returns six.
 * Reason: HashSet’s addAll method is implemented on top of its add method,
 * 
 * public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }
    
 *  The addAll method in InstrumentedHashSet added three to addCount and 
 *  then invoked HashSet’s addAll implementation using super.addAll. 
 *  This in turn invoked the add method (of A_InstrumentedHashSet as this is the objectthrough which addAll() is called.), as overridden in InstrumentedHashSet, once for each element.
 * @param <E>
 */

public class A_InstrumentedHashSet<E> extends HashSet<E> {

	// The number of attempted element insertions
	private int addCount = 0;
	public A_InstrumentedHashSet() {
	}
	public A_InstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	@Override public boolean add(E e) {
		addCount++;
		return super.add(e);
	}
	@Override public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}
	public int getAddCount() {
		return addCount;
	}
	
	public static void main(String[] args) {
		A_InstrumentedHashSet<String> s =
				new A_InstrumentedHashSet<String>();
				s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
				System.out.println("Size " +s.getAddCount());
	}

}
