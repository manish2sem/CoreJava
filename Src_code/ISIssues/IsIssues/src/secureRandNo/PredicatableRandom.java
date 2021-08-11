package secureRandNo;

import java.util.Random;

/**
 * The algorithm that produces the randomness is based on a number called a seed. 
 * If the seed number is known then it's possible to figure out the numbers that are going to be produced from the algorithm.
 * @author MAKUM
 * For the date 20th July 1969 as seed 
 * "random" numbers produced will be always (in the range of 10 ):
 * 	3 0 3 0 7 9 8 2 2 5 
 * 
 * https://www.thoughtco.com/how-to-generate-random-numbers-2034206
 * https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
 *
 */

public class PredicatableRandom {

	public static void main(String[] args) {
		// Random rand = new Random(20071969);
		 Random rand = new Random();

		 rand.setSeed(20071969);
		 
		    for (int j = 0; j<10; j++){
		    	System.out.println(rand.nextInt(10));
		    }

	}

}

/**
 * By default the seed number that is used by: 
 		Random rand = new Random(); 
 * is the current time in milliseconds since January 1, 1970. 
 * Normally this will produce sufficiently random numbers for most purposes. 
*/
