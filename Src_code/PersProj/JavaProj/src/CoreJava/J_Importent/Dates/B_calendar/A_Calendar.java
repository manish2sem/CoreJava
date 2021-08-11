package CoreJava.J_Importent.Dates.B_calendar;


import java.util.Calendar;
import java.util.Date;


/**
 * The Calendar class is designed to make date manipulation easy!
 * 
 * Calendar class is an abstract class. 
 * To create a Calendar instance, you have to use one of the overloaded getInstance() static factory methods: 
 * 		Calendar cal = Calendar.getInstance()
 * 
 * cal refers to an instance of a concrete subclass of Calendar, 
 * 		mostly java. util.GregorianCalendar.
 * 
 * We assign the Date to the Calendar instance and vice-versa.
 	c.setTime(d1);
 	Date d2 = c.getTime();

 * add() is very powerful method lets you add or subtract units of time appropriate for whichever Calendar field you specify. 
 * @author sinhama
 *
 */

public class A_Calendar {
	public static void main(String[] args) {
		Date d1 = new Date(1000000000000L);
		System.out.println("1st date " + d1.toString());
		Calendar c = Calendar.getInstance();
		c.setTime(d1); // #1
		
		if(Calendar.SUNDAY == c.getFirstDayOfWeek()) // #2
			System.out.println("Sunday is the first day of the week");
		
		System.out.println("trillionth milli day of week is " + c.get(Calendar.DAY_OF_WEEK)); // #3
		c.add(Calendar.MONTH, 1); // #4
		Date d2 = c.getTime(); // #5
		System.out.println("new date " + d2.toString() );
	}

}
