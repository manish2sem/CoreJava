package CoreJava.J_Advance.Reflection.Concept;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionAttack {
	public static void main( String [] args) throws
	NoSuchMethodException, InstantiationException, 
	IllegalAccessException, IllegalArgumentException, 
	InvocationTargetException{

		MySingletonClass obj1 = MySingletonClass.getInstance();
		MySingletonClass obj2 = MySingletonClass.getInstance();
		System.out.println("name : " +obj1.getName());
		System.out.println("name : " +obj2.getName());


		Class<MySingletonClass> clazz = MySingletonClass.class;
		Constructor<MySingletonClass> cons = clazz.getDeclaredConstructor();
		cons.setAccessible(true);
		MySingletonClass obj3 = cons.newInstance();

		MySingletonClass obj4 = MySingletonClass.getInstance();

		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		System.out.println(obj4);

		System.out.println(obj1==obj2);
		System.out.println(obj1==obj3);
		System.out.println(obj3 == obj4);
		System.out.println(obj4==obj1);

	}

}
