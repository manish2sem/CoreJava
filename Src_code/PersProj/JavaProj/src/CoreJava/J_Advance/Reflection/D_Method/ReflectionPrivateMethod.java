package CoreJava.J_Advance.Reflection.D_Method;

/**
 * Accessing Private Methods : 
 * To access a private field you will need to call the 
 * 		Class.getDeclaredMethod(String name, Class[] parameterTypes) or 
 * 		Class.getDeclaredMethods() method. 
 * The methods Class.getMethod(String name, Class[] parameterTypes) and Class.getMethods() only return public methods, 
 * 		so they won't work.
 * 
 * getDeclaredMethod("privateString") only returns fields declared in that particular class, not methods declared in any super classes.
 * 
 * Very Imp : 
 * Method.setAcessible(true) : turn off the access checks for this particular Method instance, for reflection only.
 * 								Now you can access it even if it is private, protected or package CoreJava.scope, 
 * 								even if the caller is not part of those scopes. 
 * You still can't access the method using normal code. The compiler won't allow it.
 * 
 * java.lang.IllegalAccessException is thrown when private method is accessed without turning on Method.setAcessible on.
 * 
 */
public class ReflectionPrivateMethod {

}
