package CoreJava.J_Advance.Reflection.F_Arrays;

import java.lang.reflect.Array;

/**
 * Working with arrays via Java Reflection is done using the java.lang.reflect.Array class.
 * Do not confuse this class with the java.util.Arrays class in the Java Collections suite.
 * 
 * Creating Arrays : Array.newInstance
 * 	done using newInstance method of the java.lang.reflect.Array class.
 * 
 * Accessing Arrays :
 *  Array.get(...) and Array.set(...) methods are used to access the elements of an array using Java Reflection.
 *
 */

public class ReflectionArrayBasics {
	
	public static void main(String args[])
	{
		int[] intArray = (int[]) Array.newInstance(int.class, 3);
		Array.set(intArray, 0, 123);
		Array.set(intArray, 1, 456);
		Array.set(intArray, 2, 789);

		System.out.println("intArray[0] = " + Array.get(intArray, 0));
		System.out.println("intArray[1] = " + Array.get(intArray, 1));
		System.out.println("intArray[2] = " + Array.get(intArray, 2));
		
	}

}
