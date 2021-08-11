package CoreJava.J_Basic.staticEx.StaticImp;


/**
 * The only value import statements have is that they save typing and they can make your code easier to read.
 * Static imports[added in 1.5] can be used when you want to use a class's static members.
 * 
 * The syntax is - import static followed by the fully qualified name of the static member you want to import, or a wildcard
 * @author sinhama
 *
 */

import static java.lang.System.out; // Imports out, which is static member of System. 
import static java.lang.Integer.*; // Imports all static member of Integer.
import static java.lang.Long.*;

public class C_WithStaticImp {
	public static void main(String[] args) {
		out.println(MAX_VALUE); //Instead of System.out just out is used.
		out.println(toHexString(42));
	}
}

/**
 * Issue :
 * - Reduced readability.
 * - Watch out for ambiguously named static members. 
 * if you do a static import for both the Integer class and the Long class, referring to MAX_VALUE will
 * cause a compiler error because Java won't know which MAX_VALUE you're referring to.
 * 
 */
