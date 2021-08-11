package CoreJava.J_Advance.Reflection.D_Method;

import java.lang.reflect.Method;

import CoreJava.J_Advance.Reflection.Z__DemoClass.DemoClassforMethod;

/**
 * Obtaining Method Objects : 
 * 	Method[] methods = aClass.getMethods();
 * The Method[] array will have one Method instance for each public method declared in the class.
 * 
 * If you know the precise parameter types of the method you want to access, you can do so rather than obtain the array all methods.
 * 		Method method =	aClass.getMethod("doSomething", new Class[]{String.class});
 * 	"doSomething" - First argument, name of the method. This is case sensitive.
 * 	new Class[]{String.class} - Second argument, parameters expected by method.
 * 								Pass null, if method doesnot take any parameter.  
 * If no method matches the given method name and arguments, a NoSuchMethodException is thrown.
 * 
 * You can read what parameters a given method takes like this:
 * 		Class[] parameterTypes = method.getParameterTypes();
 * 
 * You can access the return type of a method like this:
 * 		Class returnType = method.getReturnType();
 *
 */
public class A_ReflectionMethodBasisc {
	
	public static void main (String args[]) {
		Class classObj = DemoClassforMethod.class;
		
		Method[] methods = classObj.getMethods();
    	System.out.println("Methods for class " + classObj.getSimpleName()+ " are : " );

		for (Method method : methods) {
	    	System.out.println("Method  is : " +method.getName());
	    	System.out.println("and it's type is : " +method.getReturnType());
		
		}
		
    	System.out.println("Second way of obtaining Methods " );
    	
    	try {
    		Method method=null;
			try {
				method = classObj.getMethod("Method1", new Class[]{int.class});
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	System.out.println(" Fields is : " +method);
	    	System.out.println(" Fields Name : " +method.getName());
	    	System.out.println(" Fields Type : " +method.getReturnType());

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
