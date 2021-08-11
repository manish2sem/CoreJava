package CoreJava.J_Elementry.Operator.incrmnt;

/**
 * Rules are:
 * 1. If the ++ appears BEFORE the variable, the variable's value is incremented FIRST. THEN, the variable's value is resolved.
 * 2. If the ++ appears AFTER the variable, the variable's value is resolved FIRST. THEN, the variable's value is incremented.
 * In any expression, both operands are fully evaluated before the operator is applied.

OK. Those are the rules. Now an example. 
I think I'll use a fuller example to explain how this works so you can get into the rhythm
 of how such expressions are <b>evaluated</b> and <b>executed</b>.
 * @author Manish
 *
 */

public class B_IncrmntOprt {

	public static void main(String[] args) {
		B_IncrmntOprt incrementOprt = new B_IncrmntOprt();
		incrementOprt.incrementVar();
		//incrementOprt.incrementVarExplain();
	}
	
	//GS-Puzzle
	public void incrementVar(){
		int j=0;
		//int j =0;
		for (int i=0; i<100; i++){
			j=j++;
			System.out.println("J is " +j);
			//j = ++j;

			/****
			 * Using rule (2), the variable's value is first resolved, in this case, to 0. 
			 * The variable 'j' is then incremented from 0 to 1. This effectively leaves:
			 * j = (0); // j = 1
			 * 
			 * and this is the important point. 
			 * Although the variable 'j' currently contains 1, that value will be overwritten when the above line of code executes,
			 * overwriting the 1, with a 0.
			 */
		}
		System.out.println("value of j is : "+j);
		
	}
	
	
    

}
