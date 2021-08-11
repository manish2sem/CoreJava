package CoreJava.J_Importent.Immutable.ConstrctInitialization;


/**
 * 
 * Think about java.lang.Object. It doesn't have any mutable fields, but
 * it's clearly a bad idea to treat every Object reference as if it's a reference to an immutable type. 
 * Basically it depends on whether you think about immutability as a property of the type or of objects. 
 * A truly immutable type declares "any time you see a reference of this type, you can treat it as immutable" - 
 * whereas a type which allows arbitrary subclassing can't make that claim.
*/

public class ImmutableTes {

}

class ImuutClass {
	final public int x;
	final public int y;
	
	public ImuutClass(int x, int y) {
		this.x =x;
		this.y =y;
	}
	
	//public ImuutClass() {}
}

class ChildImuutClass extends ImuutClass {
	
	private String childInstanceVar;
	
	public String getChildInstanceVar() {
		return childInstanceVar;
	}

	public void setChildInstanceVar(String childInstanceVar) {
		this.childInstanceVar = childInstanceVar;
	}

	public ChildImuutClass(int x, int y, String str) {
		super(x, y);
		childInstanceVar = str;
	}
}