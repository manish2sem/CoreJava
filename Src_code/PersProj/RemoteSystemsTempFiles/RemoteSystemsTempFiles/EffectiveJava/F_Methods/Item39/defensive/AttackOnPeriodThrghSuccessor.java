package EffectiveJava.F_Methods.Item39.defensive;

import java.util.Date;

public class AttackOnPeriodThrghSuccessor {
	public static void main(String[] args) {
		Date start = new Date();
		Date end = new Date();
		Period period = new Period(start, end);
		period.end().setYear(78); 
		System.out.println("Start : " +period.start().toString());
		System.out.println("End : "  +period.end().toString());
	}
}
