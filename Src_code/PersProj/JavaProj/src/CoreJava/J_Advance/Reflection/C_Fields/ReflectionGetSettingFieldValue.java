package CoreJava.J_Advance.Reflection.C_Fields;

import java.lang.reflect.Field;

import CoreJava.J_Advance.Reflection.Z__DemoClass.DemoClassforField;

/**
 * Getting and Setting Field Values: * 
 * 	Obtained a Field reference and you can get and set its values using the Field.get() and Field.set()methods.
 * 
 * Getting Field Values : 
 * 	- obtained a Field reference
 * 		Class  aClass = MyObject.class
 * 		Field field = aClass.getField("someField");
 * 
 * - getting its values
 * 		Object value = field.get(objectInstance);
 *
 *
 *	- Setting Field Values
 *		field.set(objetInstance, value);
 *
 * The objectInstance parameter passed to the get and set method should be an instance of the class that owns the field. 
 * If the field is a static (public static ...) pass null as parameter to the get and set methods, instead of the objectInstance.
 * 
 * 
 */

public class ReflectionGetSettingFieldValue {
	public static void main (String[] args) {
		Class classObj = DemoClassforField.class;
		DemoClassforField fieldObj = new DemoClassforField();
		
		try {
			Field field = classObj.getField("publicDemoField");
			System.out.println("Name of field is : " +field);
			try {
				Object value = field.get(fieldObj);
				System.out.println("Value of field is : " +value);
				
				field.set(fieldObj, 112);
				
				Object valueAfterModification = field.get(fieldObj);
				System.out.println("Value After modification is : " +valueAfterModification);
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
