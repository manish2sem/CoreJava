package EffectiveJava.F_Methods.Item39.defensive;
import java.util.Date;

/**
 * 
 * JAVA is a safe language.
 * This means it is immune to buffer overruns, array overruns, wild pointers, and 
 * other memory corruption errors that plague unsafe languages such as C and C++.
 * 
 * In a safe language it is possible to write classes and to know with certainty that 
 * their invariants will remain true, no matter what happens in any other part of the system.
 * 
 * Even in a safe language, you aren't insulated from other classes without some effort on your part.
 * While it is impossible for another class to modify an object's internal state without some assistance from the object,
 * It is surprisingly easy to provide such assistance without meaning to do so.

 * @author mk833544
 *
 */
public final class Period {
    private final Date start;
    private final Date end;

    /**
     * 
     * @throws IllegalArgumentException if start is after end.
     * @throws NullPointerException if start or end is null.
     */
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
        this.start = start;
        this.end   = end;
    }

    public Date start() {
        return start;
    }
    public Date end() {
        return end;
    }
   
}

/**  
 * You must program defensively with the assumption that clients of your class will do their best to destroy its invariants.
 * 
 */