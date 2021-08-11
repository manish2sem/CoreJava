package EffectiveJava.D_Generics.Item25;

import java.util.Arrays;
import java.util.List;

public class B_GenericArray {

	public static void main(String[] args) {
		List<String>[] stringLists = new List<String>[1]; // (1)
		List<Integer> intList = Arrays.asList(42); // (2)
		Object[] objects = stringLists; // (3)
		objects[0] = intList; // (4)
		String s = stringLists[0].get(0);
	}

}
