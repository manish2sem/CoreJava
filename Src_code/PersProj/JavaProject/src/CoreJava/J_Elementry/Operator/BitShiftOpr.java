package CoreJava.J_Elementry.Operator;

/**
 * Java provides bit shift operators, which can be used to shift bit from one position to another on both left and right side in a number. 
Java provides three bit shift operator 
signed left shift operator "<<" -> shifts bit into left side and fill the empty place with zero
signed right shift operator ">>" -> shifts the bit on right side and fills the empty place with value of sign bit.
	For positive number it fills with zero and for negative numbers it fills with 1.
unsigned right shift operator ">>>" -> shifts the bit towards right without preserving sign of number. 
 
 
 */

public class BitShiftOpr {
	public static void main(String[] args) {
		byte b1 = 6 << 1;
		byte b2 = 12 << 2;
		byte b3 = 5 ^ 4;
		System.out.println(b1 + " " + b2 + " " + b3);

		int number = 8; //0000 1000
		System.out.println("Original number : " + number);

		//left shifting bytes with 1 position
		number = number<<1; //should be 16 i.e. 0001 0000

		//equivalent of multiplication of 2
		System.out.println("value of 8 after left shift: [<<]" + number);
		
		number = -8;
		number = number<<1; //should be 16 i.e. 0001 0000

		//equivalent of multiplication of 2
		System.out.println("value of -8 after left shift:[<<] " + number);


		number = -8;
		//right shifting bytes with sign 1 position
		number = number>>1; //should be 16 i.e. 0001 0000

		//equivalent of division of 2
		System.out.println("value of -8 after right shift with sign:[>>] " + number);

		number = -8;
		//right shifting bytes without sign 1 position
		number = number>>>1; //should be 16 i.e. 0001 0000

		//equivalent of division of 2
		System.out.println("value of -8 after right shift with Unsign:[>>>] " + number);
		
		number = 8;
		//right shifting bytes without sign 1 position
		number = number>>>1; //should be 16 i.e. 0001 0000

		//equivalent of division of 2
		System.out.println("value of 8 after right shift with Unsign:[>>>] " + number);

	}

}
