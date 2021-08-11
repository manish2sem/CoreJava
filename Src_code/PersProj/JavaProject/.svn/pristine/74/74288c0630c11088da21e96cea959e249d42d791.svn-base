package CoreJava.J_Basic.acesspecifier.DifferentPackage;

import J_Basic.acesspecifier.accessSpecifierClass.ParentProtected;

/** Protected_Concept : For a subclass outside the package, the protected member can be accessed only through inheritance. *  
 *		- if the subclass-outside-the-package CoreJava.gets a reference to the superclass, the subclass cannot use the dot operator 
 *		  on the superclass reference to access the protected member. 
 *		- To a subclass-outside-the-package, a protected member might as well be default (or even private), 
 *		  when the subclass is using a reference to the superclass.
 */

public class ProtectedChild extends ParentProtected{

	public void testIt() {
		System.out.println("protectedVar is " + protectedVar ); // No problem; Child  inherits protectedVar
		protectedMethod();										// Even protected member is inherited.
	}

	public static void main(String args[] ){
		ParentProtected parent = new ParentProtected(); // Can we access protectedVar using the parent reference? NO
		//System.out.println("X in parent is " + parent.protectedMethod());
		//System.out.println("X in parent is " + parent.protectedVar);

		PublicClass publicClass = new PublicClass();
		publicClass.protectedMethod();

		ProtectedChild child = new ProtectedChild();
		System.out.println(" in childt is " + child.protectedVar);
		child.testIt();
		child.protectedMethod();

		InheritProtectedParent inheritProtectedParent =new InheritProtectedParent();
		inheritProtectedParent.protectedMethod();


	}
}

class InheritProtectedParent extends ParentProtected {

	protected void protectedMethod() {
		System.out.println("Inside inheritProtectedParent");
	}

	public void publicMethod() {
		System.out.println("Inside publicMethod");
	}
}
