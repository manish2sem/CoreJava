package EffectiveJava.D_Generics.Item23;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Scenarios where, element type is unknown and doesn’t matter.
 * 
 * For example, suppose you want to write a method 
 * that takes two sets and returns the number of elements they have in common.
 * 
 * In such Scenarios use unbounded wildcard type.
 * unbounded wildcard type for the generic type Set<E> is Set<?> (read “set of some type”).
 * It is the most general parameterized Set type, capable of holding any set.
 * @author Manish
 * 
 * Do the question marks really buy you anything?
 * The wildcard type is safe and the raw type isn’t.
 * you can’t add any element (other than null) into a Collection<?>.
 *  Attempting to do so will generate a compile-time error message.
 *
 */

public class C_UnboundedWildCard {

	public static void main(String[] args) {
		
		Set s1 = new HashSet();
		
		Set s2 = new TreeSet();

		int i = numElementsInCommon(s1, s2);
		
		int j = numElementsInCommonUnbounded(s1, s2);

	}


	static int numElementsInCommonUnbounded(Set<?> s1, Set<?> s2) {
		int result = 0;
	//	s1.add(2);
		for (Object o1 : s1)
			if (s2.contains(o1))
				result++;
		return result;
	}

	static int numElementsInCommon(Set s1, Set s2) {
		int result = 0;
	//	s1.add(2);
		for (Object o1 : s1)
			if (s2.contains(o1))
				result++;
		return result;
	}

}

/**
 * There are two minor exceptions to the rule - that you should not use raw types in new code.
 * You must use raw types in class literals
 * 	 List.class, String[].class, and int.class are all legal, but 
 *   List<String>.class and List<?>.class are not.
 *   
 *  second exception:
 *  Because generic type information is erased at runtime, 
 *  it is illegal to use the instanceof operator on parameterized types other than unbounded wildcard types.
 *  
 *  This is the preferred way to use the instanceof operator with generic types:
		if (o instanceof Set) { // Raw type
			Set<?> m = (Set<?>) o; // Wildcard type
			...
		}

*/
