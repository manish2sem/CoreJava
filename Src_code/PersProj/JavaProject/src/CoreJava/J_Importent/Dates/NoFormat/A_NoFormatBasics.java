package CoreJava.J_Importent.Dates.NoFormat;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This class is used to format numbers or currency values.
 * 
 * NumberFormat is an abstract class,  * so you'll typically use some version of either 
 * 	- getInstance() or
 * 	- getCurrencyInstance() 
 * to create a NumberFormat object.
 * 
 * Useful methods :
 * 	- format -> 
 * 	- getMaximumFractionDigits() ->
 * 	- setMaximumFractionDigits() ->
 * 	- parse() -> and 
 * 	- setParseIntegerOnly()
 * 
 * Format method is used to 
 *
 */

public class A_NoFormatBasics {
	public static void main(String[] args) {
		float f1 = 123.4567f;
		Locale locFR = new Locale("hi"); // France
		
		NumberFormat[] nfa = new NumberFormat[4];
		nfa[0] = NumberFormat.getInstance();
		nfa[1] = NumberFormat.getInstance(locFR);
		nfa[2] = NumberFormat.getCurrencyInstance();
		nfa[3] = NumberFormat.getCurrencyInstance(locFR);
		
		for(NumberFormat nf : nfa)
			System.out.println(nf.format(f1));
	}
}
