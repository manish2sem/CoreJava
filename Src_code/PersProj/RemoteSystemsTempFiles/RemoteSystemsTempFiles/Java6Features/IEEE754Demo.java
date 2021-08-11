package Java6Features;

public class IEEE754Demo {
    public static void main(String[] args) {

        // Returns 12.0 x (2^3)
        double scalbResult = Math.scalb(12.0, 3);
        System.out.println("Math.scalb(12.0, 3) = " + scalbResult);

        // Returns the unbiased exponent value of a double, 
        // where 2^exp <= d. In this case, 2^4 <= 17
        int exp = Math.getExponent(17.0);
        System.out.println("Math.getExponent(17.0) = " + exp);

        // Returns the lesser adjacent of a double
        double lesserAdjacent = Math.nextAfter(123.0, 120.0);
        System.out.println("Math.nextAfter(123.0, 120.0) = " + lesserAdjacent);

        // Returns the greater adjacent of a double
        double greaterAdjacent = Math.nextUp(123.0);
        System.out.println("Math.nextUp(123.0) = " + greaterAdjacent);

        // Returns a copySign of the first argument
        double d = Math.copySign(1234.56, -1);
        System.out.println("Math.copySign(1234.56, -1) = " + d);
    }
}
