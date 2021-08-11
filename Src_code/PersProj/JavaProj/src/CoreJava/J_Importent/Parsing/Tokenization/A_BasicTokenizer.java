package CoreJava.J_Importent.Parsing.Tokenization;
/**
 * Tokenizing is the process of taking big pieces of source data, 
 * breaking them into little pieces, and 
 * storing the little pieces in variables.
 * 
 * We'll look at two classes in the API that provide tokenizing capabilities:
 * String (using the split() method) and 
 * Scanner, which has many methods that are useful for tokenizing.
 * 
 * When we talk about tokenizing, we're talking about data that starts out composed of two things: tokens and delimiters.
 *  Tokens are the actual pieces of data, and delimiters are the expressions that separate the tokens from each other.
 *  delimiters can be anything that qualifies as a regex expression but mostly they are single characters, 
 *  like commas or backslashes or maybe a single whitespace.
 *  
 *  The String class's split() method takes a regex expression as its argument,
 *  and returns a String array populated with the tokens produced by the split (or tokenizing) process.
 * @author sinhama
 *
 */

public class A_BasicTokenizer {
	
	public static void main(String[] args) {
		String dataSource = "ab.cde.fg";
		String delim = "\\.";
		String[] tokens = dataSource.split(delim);
		for (int i=0; i<tokens.length; i++) {
			System.out.println("Token[" +i+ "]" + " : " + tokens[i]);
		}
	}

}
