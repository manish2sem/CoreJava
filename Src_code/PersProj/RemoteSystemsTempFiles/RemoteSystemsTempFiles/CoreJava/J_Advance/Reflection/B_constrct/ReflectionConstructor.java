package CoreJava.J_Advance.Reflection.B_constrct;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import CoreJava.J_Advance.Reflection.Z__DemoClass.DemoClassMultipleConst;

/**
 * Obtaining Constructor Objects : Two way, one is discussed here.
 * 		Constructor[] constructors = aClass.getConstructors();
 * The Constructor[] array will have one Constructor instance for each public constructor declared in the class.
 * 
 * Constructor Parameters : 
 * 		Class[] parameterTypes = constructor.getParameterTypes(); 
 *  For every Constructor instance you can get its parameter types.
 *
 */

public class ReflectionConstructor {
	
	public static void main(String[] args) {
	    Class classObj = DemoClassMultipleConst.class;
	    
	    Constructor[] constructors = classObj.getConstructors();
	  
	    //constructors will have all public constructor instance
	    for (Constructor constructor : constructors) {
	    	System.out.println();
	    	System.out.println("Public Constructors : " + constructor);
	    	Class[] parameterTypes = constructor.getParameterTypes();
	    	
	    	for (Class param : parameterTypes) {
		    	System.out.println("Parameters for " + constructor +" is : "+ param);
		    }
	    }	    
	   	    
	}

}
