package CoreJava.J_Advance.Reflection.Concept;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionAttack2 {

	public static void main( String [] args) throws
	NoSuchMethodException, InstantiationException, 
	IllegalAccessException, IllegalArgumentException, 
	InvocationTargetException{

		Class<MySingletonClass> clazz = MySingletonClass.class;
		Constructor<MySingletonClass> cons = clazz.getDeclaredConstructor();
		cons.setAccessible(true);
		MySingletonClass obj1 = cons.newInstance();
		obj1.setName("Manish");

		System.out.println(obj1.getName());	
		MySingletonClass obj2 = cons.newInstance();
		obj1.setName("Sanjeev");
		
		System.out.println(obj1.getClass() +" " + obj1.getName());	
		System.out.println(obj2.getClass() +" " +obj2.getName());

	}

}
