package CoreJava.J_Essential.StringEx.BasicX;

/**
 * Logic is very simple, just read the char araay from last and return.
 * @author sinhama
 *
 */
public class A_Reverse {
	
	public static void main(String[] args) {
		
		System.out.println("Reversed string ->  " + reverseStr("reversed"));
		
	}
	
	static String reverseStr(String str) {
		
		if (str == null || str.equals("")) {
			return null;
		}
		
		char charArray[] = str.toCharArray();
		String newStr = "";
		
		for(int i = charArray.length-1; i>=0 ; i--) {
			newStr = newStr + charArray[i];			
		}
		
		return newStr;
	}

}
