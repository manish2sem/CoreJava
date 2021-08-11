package CoreJava.J_Advance.Reflection.C_Fields;

import java.lang.reflect.Field;

import CoreJava.J_Advance.Reflection.Z__DemoClass.DemoClassforField;


/**
 * Using Java Reflection you can inspect the fields (member variables) of classes and get / set them at runtime. 
 * This is done via the Java class java.lang.reflect.Field. 
 * 
 * Obtaining Field Objects : 
 * 	Field[] fields = aClass.getFields();
 * The Field[] array will have one Field instance for each public field declared in the class.
 * 
 * If you know the name of the field you want to access, you can access it like this:
 * 		Field field = aClass.getField("someField");
 * If no field exists with the given name as parameter, a NoSuchFieldException is thrown.
 * 
 * Once you have obtained a Field instance, you can get its field name and field type as 
 * 		String fieldName = field.getName();
 * 		Object fieldType = field.getType();
 * 
 * 


 *
 */

public class ReflectionField {
	
	public static void main (String args[]) {
		Class classObj = DemoClassforField.class;
		
		Field[] fields = classObj.getFields();
    	System.out.println("Fields for class " + classObj.getSimpleName()+ " are : " );

		for (Field field : fields) {
	    	System.out.println("Fields  are : " +field.getName());
	    	System.out.println("and types are : " +field.getType());
		
		}
		
    	System.out.println("Second way of obtaining Fields " );
    	
    	try {
			Field field = classObj.getField("publicDemoField");
	    	System.out.println(" Fields is : " +field);
	    	System.out.println(" Fields Name : " +field.getName());
	    	System.out.println(" Fields Type : " +field.getType());
	    	
	    	
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
