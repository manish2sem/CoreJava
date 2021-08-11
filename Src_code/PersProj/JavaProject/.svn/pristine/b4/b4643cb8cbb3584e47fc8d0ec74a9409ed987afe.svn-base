package CoreJava.J_Advance.Reflection.D_Method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import CoreJava.J_Advance.Reflection.Z__DemoClass.DemoClassforMethod;

/**
 * Invoking Methods using Method Object :
 * 		Object returnValue = method.invoke(null, "parameter-value1");
 * The null parameter is the object you want to invoke the method on. 
 * If the method is static you supply null instead of an object instance.
 *
 */

public class ReflectionMethodInvoke {
	
	public static void main (String args[])
	{
		Class classObj = DemoClassforMethod.class;
		
		Method method =null;
		
		try {
			method = classObj.getMethod("Method2", new Class[]{int.class});
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//Method1 is defined in DemoClassforMethod class. so its object is passed as an argument
			Object returnValue = method.invoke(new DemoClassforMethod(), 10);
			System.out.println("returnValue is " +returnValue);
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("***********Invoking Static Method ************");
		try {
			method = classObj.getMethod("staticMethod", new Class[]{int.class});
			Object returnValue1 = method.invoke(null, 10);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
