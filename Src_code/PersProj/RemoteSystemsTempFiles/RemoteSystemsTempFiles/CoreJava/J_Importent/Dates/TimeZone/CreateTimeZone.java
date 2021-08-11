package CoreJava.J_Importent.Dates.TimeZone;

/**
 * 
 * http://tutorials.jenkov.com/java-date-time/java-util-timezone.html
 * 
 * The UTC offset is the difference of time in MilliSsconds from 
 * Coordinated Universal Time (UTC same as GMT) for a particular place and date.
 * GMT is a time zone and UTC is a time standard.
 * Ex for India it is 19800000 (i.e. 5.5 * 60 *60 * 1000)
 * 
 * https://en.wikipedia.org/wiki/UTC_offset
 * https://time.is/time_zones
 * https://www.timeanddate.com/time/gmt-utc-time.html
 */

import java.util.TimeZone;

public class CreateTimeZone {

	public static void main(String[] args) {
			
		//default time zone for the system (computer) this program is running on.
		TimeZone timeZone = TimeZone.getDefault();
		
		System.out.println("TimeZone is : " + timeZone.getDisplayName());
		System.out.println("ID  is : " + timeZone.getID());
		System.out.println("TimeZone is : " + timeZone.toString());
		System.out.println("DayLight Saving : " + timeZone.getDSTSavings());
		System.out.println("Offset : " + timeZone.getOffset(System.currentTimeMillis() ));
	}

}
