package CoreJava.J_Importent.CollectionsClass.Basic;

import java.util.ArrayList;

public class B_ListToArray {
	
	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("abc");
		myList.add("bcd");
		myList.add("cde");
		myList.add("def");
		
		String[] myArray = (String[])myList.toArray();
		
		for(int i=0; i<myArray.length; i++) {
			
		}
		
	}

}
