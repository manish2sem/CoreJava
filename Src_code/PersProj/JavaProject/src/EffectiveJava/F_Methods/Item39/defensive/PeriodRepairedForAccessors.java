package EffectiveJava.F_Methods.Item39.defensive;
import java.util.Date;

/**
 * With the new constructor and the new accessors in place, Period is truly immutable.
 * @author mk833544
 *
 */
public class PeriodRepairedForAccessors {
	private final Date start;
	private final Date end;

	/**
	 * 
	 * @throws IllegalArgumentException if start is after end.
	 * @throws NullPointerException if start or end is null.
	 */
	public PeriodRepairedForAccessors(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end   = new Date(end.getTime());

		if (this.start.compareTo(this.end) > 0)
			throw new IllegalArgumentException(start + " after " + end);

	}

	public Date start() {
		return (Date) start.clone();
	}

	public Date end() {
		return (Date) end.clone();
	}
}
