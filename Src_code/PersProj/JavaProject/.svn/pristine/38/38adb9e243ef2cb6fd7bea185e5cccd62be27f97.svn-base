package EffectiveJava.D_Generics.Item23;

import java.util.ArrayList;
import java.util.List;

/**
 * While you shouldn’t use raw types such as List in new code, 
 * it is fine to use types that are parameterized to allow insertion of arbitrary objects, 
 * such as List<Object>.
 * 
 * what is the difference between the raw type List and the parameterized type List<Object>?
 * you lose type safety if you use a raw type like List, 
 * but not if you use a parameterized type like List<Object>.
 * 
 * 
 * List<Object> is capable of holding objects of any type.
 * But you can’t pass list of any generic type to a parameter of type List<Object>.
 * 
 * Example:
 * you can pass a List<String> to a parameter of type List, 
 * you can’t pass List<String> to a parameter of type List<Object>.
 * And this makes all difference.
 * @author Manish
 *
 */
public class B_GenList {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		unsafeAdd(strings, new Integer(42));
		//safeAdd(strings, new Integer(42));

		String s = strings.get(0); //
	}

	private static void unsafeAdd(List list, Object o) {
		list.add(o);
	}
	
	private static void safeAdd(List<Object> list, Object o) {
		list.add(o);
	}
}
