package EffectiveJava.F_Methods.Item39.defensive;
import java.util.Date;

/**
 * To protect the internals of a Period instance from this sort of attack, 
 * it is essential to make a defensive copy of each mutable parameter to the constructor and 
 * to use the copies as components of the Period instance in place of the originals.
 * @author mk833544
 *
 */

public class PeriodRepaired {
	 private final Date start;
	    private final Date end;

	    /**
	     * 
	     * @throws IllegalArgumentException if start is after end.
	     * @throws NullPointerException if start or end is null.
	     */
	    public PeriodRepaired(Date start, Date end) {
	    	this.start = new Date(start.getTime());
	        this.end   = new Date(end.getTime());

	        if (this.start.compareTo(this.end) > 0)
	            throw new IllegalArgumentException(start + " after " + end);
	      
	    }

	    public Date start() {
	        return start;
	    }
	    public Date end() {
	        return end;
	    }

}
