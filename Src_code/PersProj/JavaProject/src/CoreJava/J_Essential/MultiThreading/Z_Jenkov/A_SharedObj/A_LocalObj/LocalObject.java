package CoreJava.J_Essential.MultiThreading.Z_Jenkov.A_SharedObj.A_LocalObj;

/**
 * Local(method) variables are stored in each thread's own stack. 
 * That means that local variables are never shared between threads. 
 * That also means that all local primitive variables are thread safe. 
 * @author sinhama
 *
 */

public class LocalObject {

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void localMethod(){

		long threadSafeInt = 0; // this is local variable

		threadSafeInt++;
	}

}
