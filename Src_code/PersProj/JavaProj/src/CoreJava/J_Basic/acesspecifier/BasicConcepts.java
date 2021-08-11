package CoreJava.J_Basic.acesspecifier;

import J_Basic.acesspecifier.DifferentPackage.*;

/**
 * @author Manish
 * 
 * For top-level (non-nested) classes and interfaces, there are only two possible access levels: 
 * 		- package-private(Default) : Cannot be access beyond the package. 
 * 		- public : Need to import if package CoreJava.is different. 
 * 
 * For members there are four possible access levels, listed here in order of increasing accessibility: 
 * 		- private : The member is accessible only from the top-level class where it is declared. 
 * 		- package-private(Default) : The member is accessible from any class in the package CoreJava.where it is declared. 
 * 		- protected* : The member is accessible from subclasses of the class where it is declared and from any class in the package CoreJava.where it is declared.
 * 		- public : The member is accessible from anywhere.
 * 
 * Protected_Funda
 * The subclass can see the protected member only through inheritance.
 *		- if the subclass-outside-the-package CoreJava.gets a reference to the superclass, the subclass cannot use the dot operator 
 *		  on the superclass reference to access the protected member. 
 *		- To a subclass-outside-the-package, a protected member might as well be default (or even private), 
 *		  when the subclass is using a reference to the superclass.
 */

// private class BasicConcepts {  // Illegal
public class BasicConcepts {
	
	public static void main(String args[] ){
	
	 // Accessing from same package.
		PublicClass classSamepackage CoreJava.= new PublicClass();
		
		classSamePackage.publicMethod();
		classSamePackage.protectedMethod();
		classSamePackage.defaultMethod();
		
		// Only private is not accessed.
		
	 // Accessing from different package. only public is accessed.
		J_Basic.acesspecifier.DifferentPackage.PublicClass publicClassDifferentpackage CoreJava.= new J_Basic.acesspecifier.DifferentPackage.PublicClass();	
		
		System.out.println(publicClassDifferentPackage.publicInsVar);
	/**	Following can't be accessed. */
	/*
		System.out.println(publicClass.protectedInsVar);
		System.out.println(publicClass.defaultInsVar);
		System.out.println(publicClass.privateInsVar);
		
	*/
		
		//protected can be accessed using subclassing.	 See AccessProtected.java 
		
		AccessProtected accessProtected = new AccessProtected();
		accessProtected.publicMethod();
		
		/**  Interestingly protected method is not accessible here too using object of subclass.
		  *  It is only accesible at subclass only.
		  */
		//	accessProtected.protectedMethod();		
		
		publicClassDifferentPackage.publicMethod();
		
		/** DefaultAccessCls can not be accessed because it has default class level access specifier. */
		
		//DefaultClass defaultClass = new DefaultClass();  		
	
	}
	
}


class PublicClass {
	
	public String publicInsVar="public class diff package"; 	
	protected String protectedInsVar="Protected class diff package";
	String defaultInsVar="default class diff package";
	private String privateInsVar="Private class diff package";
	
	public void publicMethod () {
		
		System.out.println("Inside public Method diff package CoreJava.: " + publicInsVar);
		privateMethod();
	}

	protected void protectedMethod () {
	
		System.out.println("Inside protected Method same package CoreJava.: " +protectedInsVar);
	}

	void defaultMethod () {
	
		System.out.println("Inside default Method diff package CoreJava.: " + defaultInsVar);
	}

	private void privateMethod() {
	
		System.out.println("Inside private Method diff package CoreJava.: " +privateInsVar); //We can always access private member in same class.
	}	
}




