package CoreJava.J_Advance.Reflection.B_constrct;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import CoreJava.J_Advance.Reflection.Z__DemoClass.DemoClassMultipleConst;

/**
 * Obtaining Constructor Objects : Two way, second is discussed here.
 * 		Constructor constructor = aClass.getConstructor(new Class[]{String.class});
 * If you know the precise parameter types of the constructor(of course public) you want to access, 
 * 	you can do so rather than obtain the array all constructors.
 * If no constructor matches the given constructor arguments, a NoSuchMethodException is thrown.
 * 
 * Instantiating Constructor Object :
 * 		MyObject myObject = (MyObject) constructor.newInstance("constructor-arg1");
 *
 */
public class ConstructorInvoking {
	
	public static void main(String[] args) {
	    Class classObj = DemoClassMultipleConst.class;
	    
	    
	    try {
	    	
	    	System.out.println("btaining Constructor Object using parameters");
			Constructor constructor = classObj.getConstructor(new Class[]{int.class, int.class});
			System.out.println("Public Constructors : " + constructor);
			try {
				System.out.println("Invoking Constructors : " + constructor);
				DemoClassMultipleConst myObject = (DemoClassMultipleConst) constructor.newInstance(10,20);
				myObject.demoMethod();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}


}
