package DS.String.A_Elementry;

import java.util.Arrays;

/**
 * So when you need to convert String to char array, you can use String.toCharArray() method. 
 * For converting char array to String, you need to use the String constructor that takes char array argument 
 * 		i.e new String(char[] chArr).
 * Also note that the two Strings are equal in value but they are not referring to same String
 *  because the second String is created using new operator.
 *
 */

public class B_ArrayExamples {

	/**
	 * This class shows how to convert String to character array and then character array to String
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "journaldev.com";
		char[] charArr = strToChar(str);
		
		String str1 = charToStr(charArr);
		
		//let's see if str and str1 are equals or not
		System.out.println("str == str1? " + (str == str1));
		System.out.println("str.equals(str1)? " + (str.equals(str1)));
	}

	private static char[] strToChar(String str){

		char[] charArr = str.toCharArray();
		System.out.println("String converted to char array: " + Arrays.toString(charArr));
		return charArr;

	}

	private static String charToStr(char[] charArr){

		String str = new String(charArr);
		System.out.println("char array converted to String: " + str);
		return str;

	}

}