package EffectiveJava.F_Methods.Item39.defensive;
import java.util.Date;

public class PeriodPerfect {

	public static void main(String[] args) {
		Date start = new Date();
		Date end = new Date();
		PeriodRepairedForAccessors periodPerfect = new PeriodRepairedForAccessors(start, end);
		periodPerfect.end().setYear(78); 
		System.out.println("Start : " +periodPerfect.start().toString());
		System.out.println("End : "  +periodPerfect.end().toString());
	}

}
