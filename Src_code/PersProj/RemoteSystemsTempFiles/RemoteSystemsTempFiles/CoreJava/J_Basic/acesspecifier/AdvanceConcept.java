package CoreJava.J_Basic.acesspecifier;

/**
 * Instance fields should never be public : 
 * 		If an instance field is nonfinal, or is a final reference to a mutable object, 
 * 		then by making the field public, you give up the ability to limit the values that can be stored in the field.
 * 
 * You can expose constants via public static final fields,  By convention
 * 		such fields have names consisting of capital letters, with words separated by underscores (Item 56).
 *  	It is critical that these fields contain either primitive values or references to immutable objects (Item 15).
 *  	
 *  A final field containing a reference to a mutable object has all the disadvantages of a non-final field. 
 *  While the reference cannot be modified, the referenced object can be modified—with disastrous results 
 																										- See the code.

	Source : Effective Java, Item-13.
 *
 */

public class AdvanceConcept {
	public static void main(String args[] ){
		
		MutableObj muteable = new MutableObj(500);
		AccessImmotableInstanceVar accessImmutableInstanceVar = new AccessImmotableInstanceVar(muteable);
		muteable.mutableVar=1000;
		System.out.println(accessImmutableInstanceVar.instanceVar.mutableVar);
		accessImmutableInstanceVar.instanceVar.mutableVar=2000;
		System.out.println(accessImmutableInstanceVar.instanceVar.mutableVar);
	}

}

class AccessImmotableInstanceVar {
	
	public final MutableObj instanceVar;
	
	AccessImmotableInstanceVar(MutableObj obj)
	{
		this.instanceVar = obj;
	}
	
	void methd1 () 
	{
		System.out.println(instanceVar);
	}
}

class MutableObj
{
	public int mutableVar =100;
	
	MutableObj(int i){
		this.mutableVar= i;
	}
	
	void setMutableVar(int i){
		this.mutableVar= i;
		
	}
	
	int getMutableVar(){
		return this.mutableVar;
		
	} 
}
