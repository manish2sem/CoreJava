package CoreJava.J_Elementry.Operator;

/**
 * Short-Circuit Logical Operators : 
 * They are used to link little boolean expressions together to form bigger boolean expressions.
 * 		&& short-circuit AND
 * 		|| short-circuit OR
 * The short-circuit feature of the && operator is so named because it doesn't waste its time on pointless evaluations.
 * && evaluates the left side of the operation first (operand one), and if it resolves to false, 
 * the && operator doesn't bother looking at the right side of the expression.
 * If the first operand in an OR operation is true, the result will be true,
 *  so the short-circuit || doesn't waste time looking at the right side of the equation.
 * 
 */

public class LogicalOpr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if ((isItSmall(3)) || (isItSmall(7))) {
			System.out.println("Result is true");
		}
		if ((isItSmall(6)) || (isItSmall(9))) {
			System.out.println("Result is true");
		}
	}

	public static boolean isItSmall(int i) {
		if (i < 5) {
			System.out.println("i < 5");
			return true;
		} else {
			System.out.println("i >= 5");
			return false;
		}
	}

}
