package DessignPattern.Other.Behavioral.Template.A_Core;

import DessignPattern.Other.Behavioral.Template.A_Core.AbsCls.CrossCompiler;
import DessignPattern.Other.Behavioral.Template.A_Core.ImplCls.AndroidCompiler;
import DessignPattern.Other.Behavioral.Template.A_Core.ImplCls.IPhoneCompiler;


/**
 * https://dzone.com/articles/design-patterns-template-method
 * GOF Definition:
 * Defines the skeleton of an algorithm in a method, deferring some steps to subclasses.
 *  Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithms structure.
 *  
 *  
 *  The AbstractClass contains the templateMethod(), which should be made final so that it cannot be overridden. This template method makes use of other operations available in order to run the algorithm, but is decoupled for the actual implementation of these methods. All operations used by this template method are made abstract, so their implementation is deferred to subclasses.
 *  The ConcreteClass implements all the operations required by the templateMethod that were defined as abstract in the parent class.
 *  
 *  
 *  Design Principle :  
 *  	Hollywood Principle- Don't call us, we'll call you.
 *
 */
public class Client {

	public static void main(String[] args) {
		CrossCompiler iphone = new IPhoneCompiler();
		iphone.crossCompile();
		CrossCompiler android = new AndroidCompiler();
		android.crossCompile();

	}

}

/**
 * When to use :
 * 	- When behaviour of an algorithm can vary, you let subclasses implement the behaviour through overriding
 * 	- You want to avoid code duplication, implementing variations of the algorithm in subclasses
 * 	- You want to control the point that subclassing is allowed.
 * JAVA API :
 *  - Arrays class uses it for sorting.
 *  - JFrame uses update() as a template method, subclasses of the JFrame use paint(Graphics g) as their hook method.
 */

