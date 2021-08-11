package CoreJava.J_Advance.Reflection.A_classEx;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import CoreJava.J_Advance.Reflection.Z__DemoClass.aDemoClass;

/**
 * Modifier : 
 * The modifiers are packed into an int where each modifier is a flag bit that is either set or cleared. 
 * You can check the modifiers using these methods in the class java.lang.reflect.Modifier:
 * int modifiers = aClass.getModifiers();
 * 
 *	Superclass : Class superclass = aClass.getSuperclass();
 *		The superclass class object is a Class object like any other, so you can continue doing class reflection on that too.
 *
 * 
 * 	Interfaces : 
 * 		Class[] interfaces = aClass.getInterfaces()
 *
 *	Constructors : 
 *		Constructor[] constructors = aClass.getConstructors();
 *
 *	Methods :  
 *		Method[] method = aClass.getMethods();
 *
 *	Fields :  
 *		Field[] method = aClass.getFields();
 *
 *	Annotations :  
 *		Annotation[] annotations = aClass.getAnnotations();
 *
 *	To access any of above attributes you need to first get the access of object aClass as 
 *		Class aClass = aDemoClass.class;
 *
 *
 */

public class ClassAttributes {
	
	public static void main(String[] args) {
	    Class classObj = aDemoClass.class;
	    
	    int modifiers = classObj.getModifiers();
	    System.out.println("Modifier of aDemoClass : " +modifiers);
	    ClassAttributes classAttributes = new ClassAttributes();
	    classAttributes.checkforModifier(modifiers);   
	    
	    //  Superclass
		System.out.println("Super Class of aDemoClass : " +classObj.getSuperclass());	 
		
		
		// Interfaces
		Class[] interfaces = classObj.getInterfaces();		
		for (Class interfaceObj : interfaces) {
			System.out.println("Interface of aDemoClass : " +interfaceObj);
		}
		
		//Constructors
		Constructor[] constructors = classObj.getConstructors();
		for (Constructor constructorObj : constructors) {
			System.out.println("constructor of aDemoClass : " +constructorObj);
		}
		
		//Method
		 Method[] methods = classObj.getMethods();
		 for (Method methodObj : methods) {
				System.out.println("method of aDemoClass : " +methodObj);
		}
		
		//Fields
		 Field[] fields = classObj.getFields();
		 for (Field field : fields) {
				System.out.println("field of aDemoClass : " +field);
		}
		
		// Annotations
		Annotation[] annotations = classObj.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println("annotation of aDemoClass : " +annotation);
		}

	}
	
	
	void checkforModifier(int modifiers) {		
		    System.out.println("Is Abstract : " +Modifier.isAbstract(modifiers));		    
		    System.out.println("Is isFinal  : " +Modifier.isFinal(modifiers));
		    System.out.println("Is isInterface : " +Modifier.isInterface(modifiers));
		    System.out.println("Is isNative : " +Modifier.isNative(modifiers));
		    System.out.println("Is isPrivate : " +Modifier.isPrivate(modifiers));
		    System.out.println("Is isProtected : " +Modifier.isProtected(modifiers));
		    System.out.println("Is isPublic : " +Modifier.isPublic(modifiers));
		    System.out.println("Is isStatic : " +Modifier.isStatic(modifiers));
		    System.out.println("Is isStrict : " +Modifier.isStrict(modifiers));		    
		    System.out.println("Is isSynchronized : " +Modifier.isSynchronized(modifiers));
		    System.out.println("Is isTransient : " +Modifier.isTransient(modifiers));
		    System.out.println("Is isVolatile : " +Modifier.isVolatile(modifiers));		   
	}
}
