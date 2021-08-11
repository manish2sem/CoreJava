package CoreJava.J_Importent.Parsing.Formatting;

/**
 * The format() and printf() methods were added to java.io.PrintStream in Java 5. 
 * These two methods behave exactly the same way.
 * 
 * Behind the scenes, the format() method uses the java.util.Formatter class to do the heavy formatting work. 
 * You can use the Formatter class directly if you choose.
 * 
 * Let's start by paraphrasing the API documentation for format strings:
 * 		printf("format string", argument(s));
 * The format string can contain both normal string literal information that isn't associated with any arguments, and 
 * argument-specific formatting data. 
 * formatting data will always start with a percent sign (%).
 * 		System.out.printf("%2$d + %1$d", 123, 456);
 * 
 * %[arg_index$][flags][width][.precision]conversion char
 * the only required elements of a format string are the % and a conversion character
 * ARG_INDEX$ : An integer followed directly by a $, this indicates which argument should be printed in this position.
 * Flags :  Following are the importent flags:
				 "-" Left justify this argument
				 "+" Include a sign (+ or -) with this argument
				 "0" Pad this argument with zeroes
				 "," Use locale-specific grouping separators (i.e., the comma in 123,456)
				 "(" Enclose negative numbers in parentheses
 * 
 * Width : This value indicates the minimum number of characters to print.
 * Precision :  precision indicates the number of digits to print after the decimal point.
 * conversion : The type of argument you'll be formatting. You'll need to know:
				 b boolean
				 c char
				 d integer
				 f floating point
				 s string
 * @author sinhama
 *
 */

public class PrintfFormating {
	
	public static void main(String[] args) {
		int i1 = -123;
		int i2 = 12345;
		System.out.printf(">%1$(7d< \n", i1);
		System.out.printf(">%0,7d< \n", i2);
	}

}
