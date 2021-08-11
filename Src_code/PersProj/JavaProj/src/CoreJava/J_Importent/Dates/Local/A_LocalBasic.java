package CoreJava.J_Importent.Dates.Local;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * A locale is "a specific geographical, political, or cultural region."
 * It is used to do basic internationalization.
 * 
 * The two Locale constructors
 * 	- Locale(String language) : If you want to represent basic region (Italian) in your application
 *  - Locale(String language, String country) : If, you want to represent the Italian used in Switzerland,
 *  				 							You need to pass Switzerland as second param.
 *  
 *  
 *  This program explains, how a single Date object can be formatted to work for many locals.
 * @author MAKUM
 * 
 * Note: Remember that local set only at the time of instantiation.
 *
 */

public class A_LocalBasic {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		//c.set(2010, 11, 14); // December 14, 2010  (month is 0-based
		c.setTime(new Date());
		Date d2 = c.getTime();
		
		Locale locBR = new Locale("pt", "BR"); // Brazil
		Locale locIT = new Locale("it", "IT"); // Italy
		Locale locPT = new Locale("pt"); // Portugal		
		Locale locIN = new Locale("hi", "IN"); // India
		Locale locJA = new Locale("ja"); // Japan
		
		

		
		DateFormat dfUS = DateFormat.getInstance();		
		System.out.println("US : " + dfUS.format(d2));
		
		DateFormat dfUSfull = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("US full : " + dfUSfull.format(d2));
		
		DateFormat dfIT = DateFormat.getDateInstance(DateFormat.FULL, locIT);
		System.out.println("Italy : " + dfIT.format(d2));
		
		DateFormat dfPT = DateFormat.getDateInstance(DateFormat.FULL, locPT);
		System.out.println("Portugal : " + dfPT.format(d2));
		
		DateFormat dfBR = DateFormat.getDateInstance(DateFormat.FULL, locBR);
		System.out.println("Brazil : " + dfBR.format(d2));
		
		DateFormat dfIN = DateFormat.getDateInstance(DateFormat.FULL, locIN);
		System.out.println("India : " + dfIN.format(d2));
		
		DateFormat dfJA = DateFormat.getDateInstance(DateFormat.FULL, locJA);
		System.out.println("Japan : " + dfJA.format(d2));
	}

}


/**
 * You can see output as ??? for few locals like India or Japan.
 * This is because your machine isn't configured to support locales for India or Japan.
 * 
 **/