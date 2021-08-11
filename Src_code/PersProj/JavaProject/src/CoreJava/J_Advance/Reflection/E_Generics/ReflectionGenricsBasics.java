package CoreJava.J_Advance.Reflection.E_Generics;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import CoreJava.J_Advance.Reflection.Z__DemoClass.DemoClassforGenerics;

/**
 * All Java Generics information is erased at compile time so that you cannot access any of that information at runtime. 
 * This is not entirely true though. It is possible to access generics information at runtime in a handful of cases.
 * These cases actually cover several of our needs for Java Generics information. 
 * 
 * Generic Method Return Types : 
 * 		getGenericReturnType :  Provide the return type of the method()
 * 			You can process further getGenericReturnType to get all the arguments of Generic type.
 * 
 * 
 * This cannot be any of the Method objects in the parameterized type, but in the class that uses the parameterized type. 
 */

public class ReflectionGenricsBasics {
	
	public static void main(String[] args) 
	{
		Class classObj = DemoClassforGenerics.class;
		ReflectionGenricsBasics ReflGenBasics = new ReflectionGenricsBasics();

		try {
			ReflGenBasics.genericMethodReturnTypes(classObj);
			
			System.out.println( );
			ReflGenBasics.genericMethodParameterTypes(classObj);
			
			System.out.println( );
			try {
				ReflGenBasics.genericFieldTypes(classObj);
			} catch (NoSuchFieldException e) {
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
	
	
	void genericMethodReturnTypes(Class classObj) throws SecurityException, NoSuchMethodException 
	{
		System.out.println("GENERIC RETURN TYPE EXPLAINED : " );
		
		
		Method method = classObj.getMethod("getMapList", null); //null is passed when method does not take any parameters.
		Type returnType = method.getGenericReturnType();
		
		System.out.println("returnType = " + returnType);
		
		processGenericType(returnType);		
	}
	
	void genericMethodParameterTypes(Class classObj) throws SecurityException, NoSuchMethodException 
	{
		System.out.println("GENERIC PARAMETER TYPE EXPLAINED: " );
		Method method = classObj.getMethod("getStringList", List.class, int.class); //parameter class is passed when method does take any parameters.
		Type[] genericParameterTypes = method.getGenericParameterTypes();
		
		System.out.println("Parameter Types = " + genericParameterTypes); 
		
		for(Type genericParameterType : genericParameterTypes){
			System.out.println("Parameter Type = " + genericParameterTypes); 
			processGenericType(genericParameterType);
		}

	}
	
	void genericFieldTypes(Class classObj) throws SecurityException, NoSuchFieldException 
	{
		System.out.println("GENERIC FIELD TYPE EXPLAINED :  " );
		
		Field field = classObj.getField("mapList");

		Type genericFieldType = field.getGenericType();
		System.out.println("Parameter Types = " + genericFieldType); 
		
		processGenericType(genericFieldType);
	}
	
	void processGenericType(Type genericType) {
		if(genericType instanceof ParameterizedType){
		    ParameterizedType type = (ParameterizedType) genericType;
		    Type[] typeArguments = type.getActualTypeArguments();
		    for(Type typeArgument : typeArguments){
		        Class typeArgClass = (Class) typeArgument;
		        System.out.println("typeArgClass = " + typeArgClass);
		    }
		}
		
	}

}
