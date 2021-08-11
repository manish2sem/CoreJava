package CoreJava.J_Elementry.castingrule;

/**
 * @author Manish
 * 
 * Integer literal is int type.
 * floating literal is double type.
 * 
 * NOTE : one Exception :
 *  * when int literal is assigned to sort/byte variable no explicit cast is required.

 * 
 * Type Promotion rule on expression :
 * 1.) in expression if largest type of any operand is int or less then expression value is promotated to int.
 * 2.) else the expression value is promoted to type of largest operand. 
 * 3.) Compound assignments (+=. *= etc) does an automatic cast. 
 *
 */
public class AutomaticTypePromotion {
	public static void main(String args[]){
		byte b=50;   // Watch no explicit cast is required. Exception
		float f = 50.50 //Expected error.
		
		b=b*2;     //error due to type promotion.
		b=b*b;// Rule-1, expression is int. variable is byte. so problem
		
		b*=2; //watch no error!!!
		//i=l; compilaton error since violation of rule.
				
		System.out.println("byte : " +b);
		
		//System.out.println("char : " +c);
	}


}
