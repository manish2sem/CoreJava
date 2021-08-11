package CoreJava.J_Basic.InterfaceEx;

/**
 * An interface cannot contain instance fields.
 * 		- The only fields that can appear in an interface must be declared both static and final.
 */

public class FieldInIf implements PhoneHandler{

	public void answer() {
		System.out.println("Take an answer");		
	}

	public boolean forward(int extension) {
		System.out.println("Forwqrd a call to ...");
		return false;
	}
	
	public static void main(String[] args) {
		FieldInIf phoneHandler = new FieldInIf();
		System.out.println("LOCAL :" + phoneHandler.LOCAL);
		System.out.println("LOCAL1 :" + phoneHandler.LOCAL1);
		
		System.out.println("LOCAL :" + FieldInIf.LOCAL);
		System.out.println("LOCAL2 :" + FieldInIf.LOCAL2);
		
		//FieldInIf.LOCAL2 = 23;	// Compilation Error : final field can not be assigned.
		
	}

}

interface PhoneHandler{ 
	//protected int LOCAL3 = 10;  // Compilation Error : only public, static and final are permitted.
	int LOCAL2 = 10;	// by default it is public, static and final.
	public int LOCAL1 = 0;  	// by default it is static and final.
	public static final int LOCAL = 12;
	public static final int LONG_DISTANCE = 1;
	public static final int COLLECT = 2;
	public void answer();
	public boolean forward(int extension);	
}
