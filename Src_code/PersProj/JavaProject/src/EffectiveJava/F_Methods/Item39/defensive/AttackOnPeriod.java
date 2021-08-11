package EffectiveJava.F_Methods.Item39.defensive;

import java.util.Date;


/**
 * While it is impossible for another class to modify an object's(Period) internal state without some assistance from the object, 
 * it is surprisingly easy to provide such assistance without meaning to do so.
 * 
 * Here, Period has assisted AttackOnPeriod by providing access of Mutable class date.
 * 
 * @author mk833544
 *
 */
public class AttackOnPeriod {
	public static void main(String[] args) {
		Date start = new Date();
		Date end = new Date();
		Period period = new Period(start, end);
		end.setYear(78);
		
		System.out.println("Start : " +period.start().toString());
		System.out.println("End : "  +period.end().toString());
	}
}
