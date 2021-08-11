package CoreJava.J_Importent.Dates.Local;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * Below methods let you create Strings that represent a given locale's country and language 
 * in terms of both the default locale and any other locale:
 * 	getDisplayCountry()
 * getDisplayLanguage()
 *  
 * @author MAKUM
 *
 */

public class B_LocalMethods {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2010, 11, 14);
		Date d2 = c.getTime();
		
		Locale locBR = new Locale("pt", "BR"); // Brazil
		Locale locDK = new Locale("da", "DK"); // Denmark
		Locale locIT = new Locale("it", "IT"); // Italy
		Locale locIN = new Locale("IN", "IN"); // Italy

		System.out.println("def " + locBR.getDisplayCountry());
		System.out.println("loc " + locBR.getDisplayCountry(locBR));
		System.out.println("def " + locDK.getDisplayLanguage());
		System.out.println("loc " + locDK.getDisplayLanguage(locDK));
		System.out.println("D>I " + locDK.getDisplayLanguage(locIT));
		System.out.println("loc " + locIN.getDisplayLanguage());
		System.out.println("loc " + locIN.getDisplayCountry());



	}

}
