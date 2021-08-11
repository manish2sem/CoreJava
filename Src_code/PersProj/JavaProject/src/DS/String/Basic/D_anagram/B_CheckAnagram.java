package DS.String.Basic.D_anagram;

import java.util.Arrays;

/**
 * Check if the two strings have identical counts for each unique char.
 *
 */

public class B_CheckAnagram {

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
