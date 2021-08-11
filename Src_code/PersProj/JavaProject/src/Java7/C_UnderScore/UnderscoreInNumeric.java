package Java7.C_UnderScore;

/**
 * You can put underscore at convenient points to make it more readable.
 * 
 *  remember that you cannot put underscore, 
 *  	- just after decimal number or
 *  	- at the beginning or
 *  	- at the end of number.
 */
public class UnderscoreInNumeric {

	public static void main(String[] args) {
		int billion = 1_000_000_000;  // 10^9
		long creditCardNumber =  1234_4567_8901_2345L; //16 digit number
		long ssn = 777_99_8888L;
		double pi = 3.1415_9265;
		float  pif = 3.14_15_92_65f;
		
		System.out.println(billion);
		System.out.println(creditCardNumber);
		
		/*
		 * invalid numeric literals because of wrong placement of underscore
		 * 
		double pi = 3._1415_9265; // underscore just after decimal point
		long creditcardNum = 1234_4567_8901_2345_L; //underscore at the end of number
		long ssn = _777_99_8888L; //undersocre at the beginning
		
		*/

	}

}
