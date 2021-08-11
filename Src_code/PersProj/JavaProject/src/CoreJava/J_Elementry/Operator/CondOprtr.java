package CoreJava.J_Elementry.Operator;

/**
 * precedence is left to right
 *
 */

public class CondOprtr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sizeOfYard = 10;
		int numOfPets = 3;
		String status = (numOfPets<2)?"Pet count OK"
		:(sizeOfYard > 8)? "Pet limit on the edge"
		:"too many pets";
		System.out.println("Pet status is : " + status);
		
	}

}
