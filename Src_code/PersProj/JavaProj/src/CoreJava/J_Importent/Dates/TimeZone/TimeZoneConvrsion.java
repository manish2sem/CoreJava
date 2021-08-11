package CoreJava.J_Importent.Dates.TimeZone;

/**
 * http://tutorials.jenkov.com/java-date-time/java-util-timezone.html
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * You can covert the date and time in a Calendar between different time zones.
 * 
 * Get the timeZone of src and sest Zones
 * 
 * set TimeZone in Calendar
 * 
 * 
 * 
 *
 */

public class TimeZoneConvrsion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TimeZone timeZone1 = TimeZone.getTimeZone("America/Los_Angeles");
		TimeZone timeZone2 = TimeZone.getTimeZone("Europe/Copenhagen");

		Calendar calendar = new GregorianCalendar();

		long timeCPH = calendar.getTimeInMillis();
		System.out.println("timeCPH  = " + timeCPH);
		System.out.println("hour     = " + calendar.get(Calendar.HOUR_OF_DAY));

		calendar.setTimeZone(timeZone1);

		long timeLA = calendar.getTimeInMillis();
		System.out.println("timeLA   = " + timeLA);
		System.out.println("hour     = " + calendar.get(Calendar.HOUR_OF_DAY));
		
		calendar.setTimeZone(timeZone2);

		long timeCopenhagen = calendar.getTimeInMillis();
		System.out.println("timeCopenhagen   = " + timeCopenhagen);
		System.out.println("hour     = " + calendar.get(Calendar.HOUR_OF_DAY));

	}

}
