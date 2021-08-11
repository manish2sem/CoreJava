package CoreJava.J_Essential.StringEx.StrMethds;

/**
 * Replaces the first substring of this string (value)
 *  that matches the given regular expression (!, @, #, -, +, ? etc. ) with the given replacement ("" i.e. blank space).
 * @author MAKUM
 *
 */

public class ReplaceFrst {
	
	private static String regExp  = " |\\?|\\~|`|\\!|@|#|\\$|\\%|\\^|\\&|\\*|\\(|\\)|\\-|\\+|=|\\{|\\}|\\||\\[|\\]|\\\\|:|\"|;|'|\\<|\\>|,|/|\\n";

	public static void main(String[] args) {
		
		String value = "Manish\n";
		
		System.out.println("Before : " +value);
		String result = value.replaceFirst(regExp, "");
		
		System.out.print("after : " +result);
		System.out.print("End " );
		
		String param = "\n";
		if (value.contains(param)) {
			System.out.println("Contains new line");			
		}else {
			System.out.println("NO new line");			

		}


	}

}
