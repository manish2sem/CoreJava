package CoreJava.J_Elementry.variables;

/**
 * 
 * @author Manish
 * 
 * 1.) Local (method) variables must be initialized before use. WHY???
 * 2.)only one modifier available to local variable - final.
 * 
 * 3.)Instance variables are initialized with default value.
 * 4.)Instance variables can have any access modifier including final.
 * 
 * 5.) static variables are initialized with default value.
 * 
 * 
 *
 */

public class Intialization {
	int i;
	static int k;
	String str;

	Intialization(){
		System.out.println("Inside constructor " );
	}
	void getValue(){
		int j;
		j=3;
		System.out.println("Local Variable : " +j);
		System.out.println("Instanse Variable : " +i);		

	}

	{
		System.out.println("inside class Initialization Block");
	}

	static{
		System.out.println("inside Static Block");
	}

	public static void main(String args[]){
		Intialization init = new Intialization();
		//System.out.println("Instanse Variable : " +init.str);
		//System.out.println("Static Variable : " +k++);
		Intialization init1 = new Intialization();
		//System.out.println("Static Variable : " +init1.k);	

	}
}

/**
 * method variables are instantiated by simply adding a number to the stack pointer.
 * To zero them would be an extra step. For class variables they are put into initialized memory on the heap.
 * 
 * Why not take the extra step? Take a step back--Nobody mentioned that the "warning" in this case is a Very Good Thing.
 * You should never initialize your variable to zero or null on the first pass (when you are first coding it).
 * Either assign it to the actual value or don't assign it at all because if you don't then 
 * java can tell you when you really screw up.
 * */
