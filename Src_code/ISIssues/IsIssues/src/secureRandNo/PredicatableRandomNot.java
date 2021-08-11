package secureRandNo;

import java.security.SecureRandom;

/**
 * The algorithm that produces the randomness is based on a number called a seed. 
 * If the seed number is known then it's possible to figure out the numbers that are going to be produced from the algorithm.
 * @author MAKUM
 * For the date 20th July 1969 as seed 
 * "random" numbers produced will be always (in the range of 10 ):
 * 	 2 4 5 5 4 8 4 8 7 5
 * 
 * As both Random and secureRandom produce the predictable sequence of no. then what is the difference?
 * 	- default random takes system current time as seed.
 * 		so the random no can be predicted knowing the time of instantiation of Random();
 *  - default  SecureRandom() takes Random Data from your OS and use that as the seed.
 * 		This makes seed almost unpredictable.

 *
 */

public class PredicatableRandomNot {

	public static void main(String[] args) {
		 SecureRandom rand = new SecureRandom();
		// rand.setSeed(20071969);
		// byte[] values = new byte[20];
		// rand.nextBytes(values);
		 System.out.println(rand.getAlgorithm());
		    for (int j = 0; j<10; j++){
		    	System.out.println(rand.nextInt(10));
		    }

	}

}

/**
 *  - Random Data taken by SecureRandom()  from your OS 
 *  	- interval between keystrokes 
 *  	– most OS collect these data and store them in files – /dev/random and /dev/urandom in case of linux/solaris)
*/
