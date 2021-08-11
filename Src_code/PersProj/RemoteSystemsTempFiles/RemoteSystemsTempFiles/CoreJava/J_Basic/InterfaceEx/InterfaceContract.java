package CoreJava.J_Basic.InterfaceEx;

/**
 * 
 * All of the methods in an interface are abstract. 
 * 		compile time error otherwise.
 * An interface is not extended by a class; it is implemented by a class. 
 * 
 * An interface is implicitly abstract. 
 * 		You do not need to use the abstract keyword when declaring an interface (although it is acceptable).
 * Each method in an interface is also implicitly abstract. 
 * 		It's OK to explicitly declare a method in an interface as abstract, but typically the abstract keyword is left off.
 * Methods in an interface are implicitly public. It is common practice to use the public keyword when writing an interface, 
 * but if you do not explicitly declare a method in an interface as public, it will be public anyway.
 * Only public and abstract (both are optional) modifier can be used for interface methods. and return type.
 * 
 * An interface cannot contain instance fields.
 * 	The only fields that can appear in an interface must be declared both static and final.
 * 
 * when a class implements an interface, the class has two options:
 *  Implement all of the methods in the interface
 *  Be declared as abstract
 *  
 *  The implements keyword appears in the class declaration following the extends portion of the declaration. 
 *  The format for implements looks similar to: 
 *  			public class ClassName extends ParentClassName implements InterfaceName{}
 *  This is compilation error
 *  			public class ClassName implements InterfaceName extends ParentClassName{}
 *
 */

public interface InterfaceContract extends VarInterface{

}

abstract interface MethodInterface{
	public void method1();
	//public void method2(){}  //we can not put non-abstract method. compiler Error :
	abstract public void method3(); //abstract declaration is optional
	void method4(); //This method is by default public
	//protected void method5(); //we can not use protected.	compiler Error : Illegal modifier
	
}

interface VarInterface{
	static final int VAR1 = 10;
	int VAR2 = 20;
	
}

