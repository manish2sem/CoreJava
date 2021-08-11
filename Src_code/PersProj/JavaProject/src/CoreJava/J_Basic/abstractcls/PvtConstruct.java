package CoreJava.J_Basic.abstractcls;
/**
 * We can declare private constructor in abstract class.	
 * 		Contradict.
 * 
 * Such abstract class can be used via static methods.
 * @author Manish
 *
 */

public abstract class PvtConstruct {

	// Perfectly fine.
	private PvtConstruct(){

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static final void getInstance() {
		System.out.println("This is abstract class");
	}
	
	public abstract void anoInstance();

}
