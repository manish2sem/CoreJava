package CoreJava.J_Elementry.TrickyConcepts;
/**
 * 
 * main() can be overloaded!!
 * But while running "public static void main(String args[])" one is called.
 *
 */

public class TwoMainCls {
	
	public static void main(String args[]) { 
		System.out.println("Inside main");
		//main();
	}

	public static void main() { 
		System.out.println("Inside ovreloaded main");
		//main(new String[]{"TestString"});
	}
	
	public static void main(int i) { 
		System.out.println("Inside ovreloaded main");
		//main(new String[]{"TestString"});
	}
}
