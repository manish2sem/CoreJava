package CoreJava.J_Elementry.Operator.incrmnt;

/**
 * Rules are:
 * 1. If the ++ appears BEFORE the variable, the variable's value is incremented FIRST. THEN, the variable's value is resolved.
 * 2. If the ++ appears AFTER the variable, the variable's value is resolved FIRST. THEN, the variable's value is incremented.
 * In any expression or equation, both operands are fully evaluated before the operator is applied.
 */
public class A_Basics {
	public static void main(String[] args) {
		//eqn1();
		//incrementVarExplain();
		gsIntrvw();
	}
	
	/* x is incremented but 
	old value is assigned back
	*/
	public static void eqn() {
		int x = 20;
		x = x++;
		System.out.println("x= " + x); 
	}

	public static void eqn1() {
		int x =20;
		int y = x++;  // x++ = ++x + x++;
		System.out.println("y= " + y); 
		System.out.println("x= " + x); 
	}

	public static void incrementVarExplain(){

		int i = 0;

		int j = (i++) + (i++) + (i++) + (i++);

		/**
		 * Using rule (2) from above, the variable's value is first resolved, in this case, to 0. 
		 * The variable 'i' is then incremented from 0 to 1. This effectively leaves:		 * 
		 * int j = (0) + (i++) + (i++) +(i++); // i = 1
		 * 
		 * The 2nd set of parentheses is then examined. Using rule (2) from above, the variable's value is first resolved, in this case, to 1. 
		 * The variable 'i' is then incremented from 1 to 2. This effectively leaves:
		 * int j = (0) + (1) + (i++) + (i++); // i = 2
		 * 
		 * finally :
		 * int j = (0) + (1) + (2) + (3); // i = 4
		 */
		i = 0;
		int k = (++i) + (++i) + (++i) + (++i);
		System.out.println("i = " + i);  // 3
		//	System.out.println("j = " + j);  // 3
		System.out.println("k = " + k); 
	}

	public static void gsIntrvw() {
		//GS Interview
		int x = 2;
		int y = ++x + x++;  // x++ = ++x + x++;
		System.out.println("x = " + x); 
		System.out.println("y = " + y); 

	}
}
