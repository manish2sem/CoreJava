package CoreJava.J_Importent.Dates.A_date;

import java.util.Date;


/**
 * A Date instance represents a mutable date and time as a primitive long, to a millisecond. 
 * The long holds the number of milliseconds between the date being represented and January 1, 1970.
 * @author sinhama
 *
 */

public class A_TestDates {

	public static void main(String[] args) {
		Date d1 = new Date(1000000000000L); // a trillion!
		System.out.println("1st date " + d1.toString());
		
		//Adding an hour.
		d1.setTime(d1.getTime() + 3600000); // 3600000 millis / hour
		System.out.println("new time " + d1.toString());
	}


}

/**
 * Most of this class's methods have been deprecated. 
 * 	 - For most practical purposes Calendar class replaces Date class.
 * In current world, Date is mostly used to bridge between the Calendar and DateFormat class.
 */
