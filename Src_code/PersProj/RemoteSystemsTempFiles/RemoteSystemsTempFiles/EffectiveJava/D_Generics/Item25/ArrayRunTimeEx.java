package EffectiveJava.D_Generics.Item25;

import java.util.ArrayList;
import java.util.List;

public class ArrayRunTimeEx {

	public static void main(String[] args) {


	}

	public static void arrayStore(){
		Object[] objectArray = new Long[1];
		//	Object[] objectArray = new Object[1]; // This is fine.
		objectArray[0] = "I don't fit in"; // Throws ArrayStoreException
		System.out.println("arrayStore exiting ...");

	}

	public static void listStore(){
		List<Object> ol = new ArrayList<Long>(); // Incompatible types
		ol.add("I don't fit in");
		System.out.println("listStore exiting ...");

	}
	
	
}
