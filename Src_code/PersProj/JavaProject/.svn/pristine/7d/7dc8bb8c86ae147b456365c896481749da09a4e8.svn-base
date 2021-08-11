package CoreJava.J_Advance.Reflection.C_Fields;

import java.lang.reflect.Field;

import CoreJava.J_Advance.Reflection.Z__DemoClass.DemoClassforField;

/**
 * Accessing Private Fields :
 * To access a private field you will need to call the 
 * 		Class.getDeclaredField(String name) or 
 * 		Class.getDeclaredFields() method. 
 * The methods Class.getField(String name) and Class.getFields() methods only return public fields, so they won't work.
 * 
 * getDeclaredField("privateString") only returns fields declared in that particular class, not fields declared in any super classes.
 * 
 * Very Imp : 
 * Field.setAcessible(true) : turn off the access checks for this particular Field instance, for reflection only.
 * 								Now you can access it even if it is private, protected or package CoreJava.scope, 
 * 								even if the caller is not part of those scopes. 
 * You still can't access the field using normal code. The compiler won't allow it.
 * 
 * java.lang.IllegalAccessException is thrown when private field is accessed without turning on Field.setAcessible on.
 * 
 */

public class RflectionPrivateField {
	public static void main (String args[])  {
		Class classObj = DemoClassforField.class;
		
		Field[] fields = classObj.getDeclaredFields();
		//Field[] fields = classObj.getFields();
    	System.out.println("Fields for class " + classObj.getSimpleName()+ " are : " );

		for (Field field : fields) {
	    	System.out.println("Field Name : " +field.getName());
	    	System.out.println("and type is : " +field.getType());
		
		}
		
    	System.out.println("***Second way of obtaining Fields*** " );
    	
    	Field privateField = null;
    	try {
    		privateField = classObj.getDeclaredField("privateField");
	    	System.out.println(" Fields is : " +privateField);
	    	System.out.println(" Fields Name : " +privateField.getName());
	    	System.out.println(" Fields Type : " +privateField.getType());

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("***Accessing value of private field*** " );
		DemoClassforField demoClassforField = new DemoClassforField();
		String fieldValue;
		privateField.setAccessible(true);
		try {
			fieldValue = (String) privateField.get(demoClassforField);
			System.out.println(" value of private field is : " +fieldValue);
			privateField.set(demoClassforField," Setting value of private field ");
			System.out.println(" value of private field is : " +(String) privateField.get(demoClassforField));

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
