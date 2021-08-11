package Interview.JPMC.Objective;

/**
 * Wrong 
 * @author Manish
 *
 */
public class NullcheckOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		commMethod(null);

	}
	
	public static void commMethod(String str){
		System.out.println("Inside String");
	}
	
	public static void commMethod(StringBuffer strbuff){
		System.out.println("Inside String");
	}


}
