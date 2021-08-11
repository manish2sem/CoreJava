package CoreJava.J_Essential.MultiThreading.Z_Jenkov.A_SharedObj.C_ImmutObj;

/**
 *  Notice how it is possible to change that reference through both the setValue() and add() methods.
 *   Therefore, even if the ImmuRefNotThreadSafe class uses an immutable object internally, it is not itself immutable, and therefore not thread safe.
 *   In other words: The A_immutObj class is thread safe, but the use of it is not.
 * @author sinhama
 *
 */
public class ImmuRefNotThreadSafe {


	private A_immutObj currentValue = null;

	public A_immutObj getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(A_immutObj currentValue) {
		this.currentValue = currentValue;
	}

	public void add(int newValue){
		this.currentValue = this.currentValue.add(newValue);
	}
	
}

/**
 * To make the Calculator class thread safe you could have declared the getValue(), setValue(), and add() methods synchronized
 */