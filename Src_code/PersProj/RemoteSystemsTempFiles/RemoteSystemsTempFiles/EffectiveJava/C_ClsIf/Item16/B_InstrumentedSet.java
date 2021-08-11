package EffectiveJava.C_ClsIf.Item16;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Instead of extending an existing class (i.e. Inheritence use composition),
 * give your new class a private field that references an instance of the existing class.
 * 
 * Each instance method in the new class invokes the corresponding method on the contained instance of the existing class and returns the results. 
 * This is known as forwarding,
 * and the methods in the new class are known as forwarding methods.
 *
 * The class has no dependencies on the implementation details of the existing class.
 * Even adding new methods to the existing class will have no impact on the new class.
 * @param <E>
 */

public class B_InstrumentedSet<E> extends ForwardingSet<E> {
	private int addCount = 0;
		
	public B_InstrumentedSet(Set<E> s) {
		super(s);
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
		B_InstrumentedSet<String> s =
				new B_InstrumentedSet<String>(new HashSet());
				s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
				System.out.println("Size " +s.getAddCount());
	}

}