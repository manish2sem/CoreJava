package CoreJava.J_Elementry.Operator;

/**
 * If either operand is a String, the + operator becomes a String concatenation operator. 
 * If both operands are numbers, then only + operator is the addition operator.
 * 
 * when using a compound operator, the expression on the right side of the = will always be evaluated first.
 * 			x *= 2 + 5; ===> x *= 7 ===> x = x*7
 * 			x = x * (2 + 5);
 *
 */

public class AddOprt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AddOprt addOprt = new AddOprt();
		addOprt.compoundAdd();
		addOprt.strAdd();

	}
	
	void compoundAdd() {
		int x=4;
		x *= 2 + 5;
		System.out.println(" X : = " +x);
	}
	
	void strAdd() {
		
		System.out.println("" + 4 +5);
		System.out.println(4 +5 + "");
	}

}
