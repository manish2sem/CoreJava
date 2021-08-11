package CoreJava.J_Essential.IO.srlzation.VersUID;

import java.io.Serializable;

/**
 * Changes to a class that can hurt deserialization:
 * - Deleting an instance variable
 * - changing the type of an instance variable.
 * - changing a non-transient instance variable to transient.
 * - changing a class from Serializable to non-Serializable.
 * - changing an instance variable to static
 * - Moving a class up or down the inheritence hierarchy.
 * 
 * If you are sure that after serializing this class, any of the above changes are going to happen
 * before deserializing the same class then declare serialVersionUID in the class. 
 * Deleting an instance variable - Make the class compilable by removing deleted instance every where.
 *
 */

class MyClass implements Serializable{
//class MyClass{
	
	//private static final long serialVersionUID = 1L;	
	private int i;
	double d;
	static String staticStr;
	String normString;

	
	public MyClass(int i, double d, String str, String norStr){
		this.i=i;
		this.d=d;
		this.staticStr=str;
		this.normString=norStr;
	}
	
	public String toString(){
		System.out.println();
		return ":" +i +":"+d+":"+staticStr +":"+normString;
		//return ":"+d+":"+staticStr +":"+normString;

	}
}

/**
 * Following changes does not required UID declaration.
 *  - Adding new instance variable.
 *  - Changing a transient instance variable to non-transient.
 *  In both the above cases default value of variable is assigned to the deserailized object.
 *  - Changing the access level.
 *  - Adding/Removing class to the inheritance tree.
 */

