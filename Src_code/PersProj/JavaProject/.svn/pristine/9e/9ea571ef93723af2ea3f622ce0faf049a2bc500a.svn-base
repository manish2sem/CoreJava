package CoreJava.J_Essential.xceptionHandling.polymorphism;

import java.io.FileNotFoundException;

/**
 * When exception is thrown by parent class constructor then
 * child class must throw/handle the same exception.
 * This is same rule - 
 * 		A checked exception must be either handled or declared.
 * 		Declaring a method forces it to eventually be handled down the call-stack.
 * 
 * It is just like handling exception thrown by parent class method (super() in constructor)
 * 
 * This rule is for checked-exception only.
 * @author Samrat
 *
 */

public class D_ChildConstructor extends C_ParentConstructor{

	public D_ChildConstructor() throws FileNotFoundException {
		super();  //It is like parent class method is called.So you need to handle/declare all exception thrown by parent method  i.e. constructor. 
		// TODO Auto-generated constructor stub
	}

}
