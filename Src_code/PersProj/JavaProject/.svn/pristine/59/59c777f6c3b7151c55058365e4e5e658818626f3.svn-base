package Algorithm.Recursion.B_medium;

/**
 * Find the gcd (greatest common divisor) of 2 numbers:
 * @author Manish
 *
 */
public class C_FigdGCD {

	public static void main(String[] args) {
		System.out.println("Starting main ...");
		int gcd = gcd(1250, 2455);
		
		System.out.println("gcd = " +gcd);

	}

	public static int gcd(int a, int b) {
        int remainder = a % b;

        if (remainder == 0)
            return b;
        else
            return gcd(b, remainder);
    }
}
