package EffectiveJava.D_Generics.Item27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A_RawMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> guys = new HashSet<String>(
				Arrays.asList("Tom", "Dick", "Harry"));
		Set<String> stooges = new HashSet<String>(
				Arrays.asList("Larry", "Moe", "Curly"));
		/*Set<Integer> stooge = new HashSet<Integer>(
				Arrays.asList(1, 2, 3));*/
		Set<String> aflCio = union1(guys, stooges);
		System.out.println(aflCio);

	}

	// Uses raw types - unacceptable! (Item 23)
	public static Set union(Set s1, Set s2) {
		//s1.add(2);
		Set result = new HashSet(s1);
		result.addAll(s2);
		return result;
	}

	public static <E> Set<E> union1(Set<E> s1, Set<E> s2) {
		//s1.add(2);
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}

}
