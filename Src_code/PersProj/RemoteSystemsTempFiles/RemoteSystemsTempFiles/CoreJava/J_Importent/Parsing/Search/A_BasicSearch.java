package CoreJava.J_Importent.Parsing.Search;

import java.util.regex.*;


/**
 * In general, a regex search runs from left to right, and 
 * once a source's character has been used in a match, it cannot be reused.
 * For Eg 
 * 		source: abababa
		index:  0123456
		expression: aba
 *Clearly we have three occurence of aba at 0, 2 and 4. since 2 is already used for search it is not counted.
 */

public class A_BasicSearch {

	public static void main(String [] args) {
		Pattern p = Pattern.compile("aba"); // the expression
		Matcher m = p.matcher("abababa"); // the source
		while(m.find()) {
			System.out.print(m.start() + " ");
		}
	}

}
