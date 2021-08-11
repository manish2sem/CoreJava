package CoreJava.J_Essential.Collection.Collections.Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {
	
	public static void main(String[] args) {
		String[] myArray = {"abc", "bcd", "cde", "def" };
		List<String> myList = Arrays.asList(myArray);
		
		for (String str : myList) {
			System.out.println(str);
		}
		
	}

}
