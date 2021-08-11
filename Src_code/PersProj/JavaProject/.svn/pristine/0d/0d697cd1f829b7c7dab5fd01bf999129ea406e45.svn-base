package CoreJava.J_Advance.Reflection.D_Method;

import java.lang.reflect.Method;

import CoreJava.J_Advance.Reflection.Z__DemoClass.DemoClassforGetSetterMethod;

/**
 * Using Java Reflection you can inspect the methods of classes and invoke them at runtime. 
 * This can be used to detect what getters and setters a given class has. 
 * You cannot ask for getters and setters explicitly, so 
 * you will have to scan through all the methods of a class and check if each method is a getter or setter.
 * 
 * Getter : A getter method have its name start with "get", take 0 parameters, and returns a value. 
 * Setter : A setter method have its name start with "set", and takes 1 parameter.
 * 		Setters may or may not return a value. 
 * 			Some setters return void, 
 * 			some the value set, 
 * 			others the object the setter were called on for use in method chaining.
 *  Therefore you should make no assumptions about the return type of a setter.
 *
 */

public class ReflectionGetSetterBasics {
	
	public static void main (String args[]) {
		Class classObj = DemoClassforGetSetterMethod.class;
		
		Method[] methods = classObj.getMethods();

		  for(Method method : methods)
		  {
		    if(isGetter(method)) 
		    {
		    	System.out.println("getter: " + method);
		    }
		    if(isSetter(method)) 
		    {
		    	System.out.println("setter: " + method);
		    }
		  }
		}

		public static boolean isGetter(Method method)
		{
		  if(!method.getName().startsWith("get"))    
		  {
			  return false;
		  }
		  if(method.getParameterTypes().length != 0)   
		  {
			  return false;  
		  }
		  if(void.class.equals(method.getReturnType()))
		  {
			  return false;
		  }
		  return true;
		}

		public static boolean isSetter(Method method)
		{
		  if(!method.getName().startsWith("set")) return false;
		  if(method.getParameterTypes().length != 1) return false;
		  return true;
		}
		
		

	}

