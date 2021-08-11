package CoreJava.J_Importent.Dates.B_calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * The roll() method acts like the add() method, except that when a part of a Date gets incremented or decremented, 
 * larger parts (i.e. year) of the Date will not get incremented or decremented.
 * 
 *
 */

public class B_CalRoll {
	
	public static void main(String[] args) {
		Date d1 = new Date(1000000000000L);
		System.out.println("1st date " + d1.toString());
		Calendar c = Calendar.getInstance();
		c.setTime(d1); // #1
						
		c.roll(Calendar.MONTH, 9); // #4
		Date d2 = c.getTime(); // #5
		System.out.println("new date " + d2.toString() );
	}

}
