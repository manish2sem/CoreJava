package CoreJava.J_Importent.Parsing.Search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [abc] Searches only for a's, b's or c's
 * [a-f] Searches only for a, b, c, d, e, or f characters
 * [a-fA-F] Searches for the first six letters of the alphabet, both cases.
 * "^" to negate the characters specified, 
 * nested brackets to create a union of sets,
 * "&&" to specify the intersection of sets.
 * @author sinhama
 *
 */

public class C_UsinfSetofChar {
	
	public static void main(String[] args) {
		String patternStr = "[0-3a-c]";
		Pattern p = Pattern.compile(patternStr); // the expression
		Matcher m = p.matcher("a12v3e456fc"); // the source
		while(m.find()) {
			System.out.print(m.start() + " ");
		}
	}

}
