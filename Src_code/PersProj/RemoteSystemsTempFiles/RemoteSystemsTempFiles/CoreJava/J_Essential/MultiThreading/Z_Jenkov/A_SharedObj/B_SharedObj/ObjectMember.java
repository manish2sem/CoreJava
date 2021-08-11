package CoreJava.J_Essential.MultiThreading.Z_Jenkov.A_SharedObj.B_SharedObj;

/**
 * Object members are stored on the heap along with the object.
 * Therefore, if two threads call a method on the same object instance and
 *  this method updates object members, the method is not thread safe.
 *
 */

public class ObjectMember {

	StringBuilder builder = new StringBuilder();

	public void add(String text){
		this.builder.append(text);
	}

	public StringBuilder getBuilder() {
		return builder;
	}
}
