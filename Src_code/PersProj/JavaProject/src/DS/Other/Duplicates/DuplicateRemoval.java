package DS.Other.Duplicates;

import java.util.HashMap;
import java.util.Map;


/**
 * Design an algorithm and write code to remove the duplicate characters in a string.
 * You are allowed to use  additional buffer. 
 */

public class DuplicateRemoval {

	public static void main(String[] args) {
		String statement ="My name is manish kumar";
		System.out.println(statement);
		String newStr = removeDuplicate(statement);
		System.out.println(newStr);
	}

	private static String removeDuplicate(String str){

		char[] charArray = str.toCharArray();
		char[] newBuffer = new char[charArray.length];
		boolean found = false;
		int position = 0;

		for (int i=0; i<charArray.length; i++ ) {
			found = false;
			for(int j=0; j<position; j++){
				if (charArray[i] == newBuffer[j] ){
					found = true;
					break;
				}
			}
			if(!found) {
				System.out.println( charArray[i]);
				newBuffer[position++] = charArray[i];
			}

		}

		return new String(newBuffer);
	}
}



