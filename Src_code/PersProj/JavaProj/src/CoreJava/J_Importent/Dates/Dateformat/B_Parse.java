package CoreJava.J_Importent.Dates.Dateformat;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;


/**
 * Parse() takes a String formatted in the style of the DateFormat instance being used, and 
 * converts the String into a Date object.
 * Because the parse() method could easily receive a badly formatted string, it can throw a ParseException.
 * @author sinhama
 *
 */

public class B_Parse {
	public static void main(String[] args) {
		Date d1 = new Date(1000000000000L);
		System.out.println("d1 = " + d1.toString());
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		String s = df.format(d1);	//Converting(formatting) date to object
		System.out.println(s);
		Date d2=null;
		try {
			d2 = df.parse(s);  // converts the String into a Date object.;
			System.out.println("parsed = " + d2.toString());
		} catch (ParseException pe) {
			System.out.println("parse exc");
		}
		
		if(d1 == d2){
			System.out.println("d1 == d2");
		}
		
		if(d1.equals(d2)){
			System.out.println("d1.equals(d2");
		}

	}
}
