package CoreJava.J_Basic.staticEx.Z_StaticBlock;

/**
 * First all static blocks are positioned in the code and they are executed when the class is loaded into JVM. 
 * Since the static method staticMethod() is called inside third static block, its executed before calling the main method. 
 * But the staticMethod2() static method is executed after the class is instantiated because it is being called after the instantiation of the class.
 * 
 * Source - http://www.jusfortechies.com/java/core-java/static-blocks.php
 * @author sinhama
 * 
 * check this as well -> http://www.javatpoint.com/static-keyword-in-java
 * 
 * VVI Link ->
 * http://www.programcreek.com/2013/01/when-and-how-a-java-class-is-loaded-and-initialized/
 * 
 * 
 * 
 * Static blocks are also called Static initialization blocks . A static initialization block is a normal block of code enclosed in braces, { }, and preceded by the static keyword. 

static {
    // whatever code is needed for initialization goes here
}

A class can have any number of static initialization blocks, and they can appear anywhere in the class body. 
The runtime system guarantees that static initialization blocks are called in the order that they appear in the source code. 
And, this code will be executed when JVM loads the class. JVM combines all these blocks into one single static block and then executes.

If you have executable statements in the static block, JVM will automatically execute these statements when the class is loaded into JVM.
If you’re referring some static variables/methods from the static blocks, these statements will be executed after the class is loaded into JVM same as above
i.e., now the static variables/methods referred and the static block both will be executed.
 *
 */

public class A_ExecutionOreder {

	static {
		System.out.println("This is first static block");
	}

	public A_ExecutionOreder(){
		System.out.println("This is constructor");
	}

	public static String staticString = "Static Variable";

	static {
		System.out.println("This is second static block and "
				+ staticString);
	}

	public static void main(String[] args){
		A_ExecutionOreder statEx = new A_ExecutionOreder();
		A_ExecutionOreder.staticMethod2();
	}

	static {
		staticMethod();
		System.out.println("This is third static block");
	}

	public static void staticMethod() {
		System.out.println("This is static method");
	}

	public static void staticMethod2() {
		System.out.println("This is static method2");
	}

}

/**
 * advantages of static blocks-
If you’re loading drivers and other items into the namespace. For ex, Class class has a static block where it registers the natives.
If you need to do computation in order to initialize your static variables,you can declare a static block which gets executed exactly once,when the class is first loaded.
Security related issues or logging related tasks
 
limitations for static blocks 
There is a limitation of JVM that a static initializer block should not exceed 64K.
You cannot throw Checked Exceptions.
You cannot use this keyword since there is no instance.
You shouldn’t try to access super since there is no such a thing for static blocks.
You should not return anything from this block.
Static blocks make testing a nightmare.
*/
