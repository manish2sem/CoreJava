package CoreJava.J_Importent.Dates.Dateformat;

import java.text.DateFormat;
import java.util.Date;

/**
 * This class is used to format Date. 
 * 
 * It is an abstract class, using two[mostly] factory methods, 
 * 		- getInstance() and 
 * 		- getDateInstance()
 *  we create instances of DateFormat.
 * 
 * getDateInstance() constructor is overloaded which takes static fields from the DateFormat class 
 * to customize our various instances of DateFormat. 
 * 
 * format() method is used to create Strings representing the properly formatted versions of the Date.

 * @author sinhama
 *
 */

public class A_DtFormat {
	public static void main(String[] args) {
		
		Date d1 = new Date(1000000000000L);
		DateFormat[] dfa = new DateFormat[6];
		
		dfa[0] = DateFormat.getInstance();
		dfa[1] = DateFormat.getDateInstance();
		dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT);
		dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
		dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);
		dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);
		
		for(DateFormat df : dfa)
			System.out.println(df.format(d1));
	}

}
