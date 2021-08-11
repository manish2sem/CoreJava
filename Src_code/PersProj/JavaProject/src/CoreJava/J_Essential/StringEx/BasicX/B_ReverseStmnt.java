package CoreJava.J_Essential.StringEx.BasicX;

/**
 * Reverse the sring of given statement.
 * Ex : Input ->  My Name is Manish.
 *      output -> Manish is Name My. 
 * @author sinhama
 *
 */

public class B_ReverseStmnt {
	
	public static void main(String[] args) {
		System.out.println("Reversed string ->  " + reverseStmnt("My Name is Manish"));
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

}


