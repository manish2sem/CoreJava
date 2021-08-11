package DS.String.Basic.A_reverse;


/**
 * Reverse the string of given statement.
 * Ex : Input ->  My Name is Manish.
 *      output -> Manish is Name My. 
 * @author sinhama
 *
 */

public class B_ReverseStmnt {

	public static void main(String[] args) {
		System.out.println("Reversed string ->  " + imprvIeverseStmnt("My Name is Manish"));
	}

	static String reverseStmnt(String str) {

		if (str == null || str.equals("")) {
			return null;
		}

		String strArray[] = str.split(" ");
		String newStr = "";

		for(int i = strArray.length-1; i>=0 ; i--) {
			newStr = newStr + strArray[i] + " ";			
		}

		return newStr;
	}

	static String imprvIeverseStmnt(String str) {

		if (str == null || str.equals("")) {
			return null;
		}

		String strArray[] = str.split(" ");
	//	String newStr = "";

		int n = strArray.length;
		for(int i = 0; i<n; i++) {
			String tmp = strArray[i];
			strArray[i] = strArray[n-1];
			strArray[n-1] = tmp;
			n--;
		}
		String newStr = "";
		for(int i = 0; i< strArray.length ; i++) {
			newStr = newStr + strArray[i] + " ";			
		}
		return newStr;
	}

}


