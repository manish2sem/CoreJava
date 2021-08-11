package CoreJava.J_Elementry;

/**
 * Default value 0 is assigned to 6 numerical Instance variables.
 * Default value false is assigned to boolean Instance variables.
 * Default value 0(equivalent) is assigned to character Instance variables.
 * Default value null is assigned to class Instance variables. 
 * 
 * We need to assign the value for local variable(including class var) before using it.
 * Not doing so will throw compilation error.
 * It never take any default instance variable.
 *  
 *
 */


public class DefaultInitialization {
	short sort;
	byte byt;
	int i;
	long lng;
	char c;
	boolean bl;
	float flt;
	double dbl;
	Aclass aclass;
	
	public static void main(String[] args) {
		short sort;
		byte byt;
		int i;
		long lng;
		char c;
		boolean bl;
		float flt;
		double dbl;
		Aclass aclass;
		DefaultInitialization defaultValue = new DefaultInitialization();
		defaultValue.prntInstVar();
		
	/**
	 * 	Following uncommented code would be compilation error.
	 * Local variable must initialize before using;
	 */
		i=10;
		System.out.println("value of int   : "+i);
	//	System.out.println("value of Aclass   : "+aclass);
		/*System.out.println("value of short   : "+sort);
		System.out.println("value of byt   : "+byt);
		System.out.println("value of int   : "+i);
		System.out.println("value of char   : "+c);
		System.out.println("value of boolean   : "+bl);
		System.out.println("value of float   : "+flt);
		System.out.println("value of double   : "+dbl);
		System.out.println("value of long   : "+lng);*/
	}
	
	public void prntInstVar() {
		System.out.println("value of short   : "+sort);
		System.out.println("value of byt   : "+byt);
		System.out.println("value of int   : "+i);
		System.out.println("value of char   : "+(int)c);
		System.out.println("value of boolean   : "+bl);
		System.out.println("value of float   : "+flt);
		System.out.println("value of double   : "+dbl);
		System.out.println("value of long   : "+lng);
		System.out.println("value of Aclass    : "+aclass);
		
	}

}

class Aclass{
	public String toString() {
		System.out.println("Inside class a");
		
		return "ClassA";
	}
}
