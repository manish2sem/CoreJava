package EffectiveJava.A_Objects.Item5.B_ImprovedVer;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Person class creates Calendar, TimeZone, and Date instances only once, 
 * when it is initialized, instead of creating them in every invocation.
 * 
 * This results in significant performance and
 * clarity.
 * 	static final fields makes it clear that these dates are treated as constants.
 * @author Manish
 * 
 * lazily initializing is not recommended 
 * (considering the possibility when this method is not call at all.). 
 * As it would complicate the implementation and 
 * would be unlikely to result in a noticeable performance improvement beyond what we’ve already achieved.
 * 
 * Again, this objects could be reused(despite being mutable),
 *  because they were not modified after initialization.
 *
 */
class Person {
	private final Date birthDate=null;
	// Other fields, methods, and constructor omitted
	/**
	 * The starting and ending dates of the baby boom.
	 */
	private static final Date BOOM_START;
	private static final Date BOOM_END;
	static {
		Calendar gmtCal =
				Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = gmtCal.getTime();
	}
	public boolean isBabyBoomer() {
		return birthDate.compareTo(BOOM_START) >= 0 &&
				birthDate.compareTo(BOOM_END) < 0;
	}
}