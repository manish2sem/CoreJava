package CoreJava.J_Importent.Dates.NoFormat;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Useful methods :
 * 	- format -> 
 * 	- getMaximumFractionDigits() -> returns 
 * 	- setMaximumFractionDigits() ->
 *  - parse() -> and 
 *  - setParseIntegerOnly()
 * @author sinhama
 *
 */

public class B_UsefulMethods {
	public static void main(String[] args) {
		
		float f1 = 123.45678f;
		NumberFormat nf = NumberFormat.getInstance();
		
		System.out.println(nf.getMaximumFractionDigits() + " ");
		System.out.println(nf.format(f1) + " ");
		
		nf.setMaximumFractionDigits(5);
		System.out.println(nf.format(f1) + " ");
		try {
			System.out.println(nf.parse("1234.567"));
			nf.setParseIntegerOnly(true);
			System.out.println(nf.parse("1234.567"));
			System.out.println(nf.getMaximumFractionDigits() + " ");
		} catch (ParseException pe) {
			System.out.println("parse exc");
		}
	}

}
