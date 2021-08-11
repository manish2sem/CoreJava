package DS.String.Basic.D_anagram;

import java.util.Arrays;

/**
 * To check if given input is anagram or not.
 * 
 * Example -> ABCD and ACDB 
 * @author sinhama
 * 
 * Algo : Very basic
 *	Sort both the string
 *	match if each characters are equal.
 *
 * Order of n^2.
 *
 */

public class A_CheckAnagram {

	public static void main(String[] args) {
		
		System.out.println("Strings " + "Are Anagram " +  checkAnagram("ABaDCw", "BaCADw"));
		
	}
	
	static boolean checkAnagram(String str1, String str2){
		
		if (str1.length() != str2.length()) {
			return false;
		}
		
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		boolean notEqual = false;
		for (int i=0; i< charArray1.length; i++) {
			if(charArray1[i] != charArray2[i]) {
				notEqual = true;
				break;
			}
		}
		return !notEqual;
	}
}
