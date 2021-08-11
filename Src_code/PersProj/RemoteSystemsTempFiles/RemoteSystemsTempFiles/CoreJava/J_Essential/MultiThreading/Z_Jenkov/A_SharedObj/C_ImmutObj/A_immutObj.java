package CoreJava.J_Essential.MultiThreading.Z_Jenkov.A_SharedObj.C_ImmutObj;

/**
 *  Notice how the value for the A_immutObj instance is passed in the constructor. 
 *  Notice also how there is no setter method. Once an ImmutableValue instance is created you cannot change its value. It is immutable. 
 *  You can read it however, using the getValue() method.
 *  
 *  If you need to perform operations on the A_immutObj instance you can do so by returning a new instance with the value resulting from the operation.
 * @author sinhama
 *
 */

public class A_immutObj {

	private int value = 0;

	public A_immutObj(int value){
		this.value = value;
	}

	public int getValue(){
		return this.value;
	}

	/**
	 * Notice how the add() method returns a new ImmutableValue instance
	 * with the result of the add operation, rather than adding the value to itself. 
	 * 
	 */
	public A_immutObj add(int valueToAdd){
		return new A_immutObj(this.value + valueToAdd);
	}

}
