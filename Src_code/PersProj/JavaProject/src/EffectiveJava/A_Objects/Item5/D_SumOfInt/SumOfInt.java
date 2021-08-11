package EffectiveJava.A_Objects.Item5.D_SumOfInt;

/**
 * This program is much slower than it should be because The variable sum is declared as a Long.
This means that the program constructs about 231 unnecessary
Long instances (roughly one for each time the long i is added to the Long sum).
Changing the declaration of sum from Long to long reduces the runtime from 9 seconds 1 seconds on my machine. 
The lesson is clear: prefer primitives to boxed primitives, and watch out for unintentional autoboxing.
 * @author Manish
 *
 */
public class SumOfInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
	//	long max = Integer.MAX_VALUE;
		long sum = 0L;
		for (long i = 0L; i < Integer.MAX_VALUE; i++) {
			sum += i;

		}
		System.out.println("Max Value = " +Integer.MAX_VALUE);

		System.out.println("Sum is " +sum);
		long endTime = System.nanoTime();
		
		System.out.println("total Time taken = " +(endTime-startTime));

	}
}

/**
 * 
 */