package CoreJava.J_Advance.Reflection.Concept;

import java.lang.reflect.Constructor;

public class LooksPerfect {

	public static void main(String[] args) {
	
		MySingletonClass obj1 = MySingletonClass.getInstance();
		obj1.setName("Manish");

		System.out.println(obj1.getName());	
		MySingletonClass obj2 = MySingletonClass.getInstance();
		obj1.setName("Sanjeev");
		
		System.out.println(obj1.getClass() +" " + obj1.getName());	
		System.out.println(obj2.getClass() +" " +obj2.getName());
	}

}
