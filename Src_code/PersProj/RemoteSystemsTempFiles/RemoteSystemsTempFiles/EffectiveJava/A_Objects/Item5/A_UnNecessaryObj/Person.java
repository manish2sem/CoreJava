package EffectiveJava.A_Objects.Item5.A_UnNecessaryObj;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * The isBabyBoomer method unnecessarily creates below 4 objects each time when it is invoked.
 *  - a new Calendar, 
 *  - TimeZone, and 
 *  - two Date instances.
 *
 * Solution - See Next implementation, with a static initializer.
 */
public class Person {

	private final Date birthDate = null;
	// DON'T DO THIS!
	public boolean isBabyBoomer() {
		// Unnecessary allocation of expensive object
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomStart = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomEnd = gmtCal.getTime();
		return birthDate.compareTo(boomStart) >= 0 &&
				birthDate.compareTo(boomEnd) < 0;
	}
}
