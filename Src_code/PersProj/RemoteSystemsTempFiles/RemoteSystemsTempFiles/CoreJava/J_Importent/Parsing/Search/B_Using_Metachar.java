package CoreJava.J_Importent.Parsing.Search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MetaCharacter provides more flexibility and dynaminism for searching.
 * Eg to find all of the occurrences of hex numbers or phone numbers or ZIP codes.

 *	\d : numeric digits
 *	\s : A whitespace character
	\w : A word character
 *
 */

public class B_Using_Metachar {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("\\d"); // the expression
		Matcher m = p.matcher("a12c3e456f"); // the source
		while(m.find()) {
			System.out.print(m.start() + " ");
		}
		
		System.out.println("");
		System.out.println("Calling Word  ");
		find_word("a 1 56 _Z", "\\w");
	}
	
	
	private static void find_word(String source, String expr) {
		Pattern p = Pattern.compile(expr); // the expression
		Matcher m = p.matcher(source); // the source
		while(m.find()) {
			System.out.print(m.start() + " ");
		}
	}
}
