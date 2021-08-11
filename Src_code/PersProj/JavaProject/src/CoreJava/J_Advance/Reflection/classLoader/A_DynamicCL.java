package CoreJava.J_Advance.Reflection.classLoader;

/**
 * Loading a class dynamically is easy.
 * - Obtain a ClassLoader and 
 * - Call its loadClass() method.
 * @author sinhama
 *
 */

public class A_DynamicCL {
	public static void main(String[] args){

		ClassLoader classLoader = A_DynamicCL.class.getClassLoader();

		try {
			Class aClass = classLoader.loadClass("J_Advance.Reflection.classLoader.DemoClass");
			System.out.println("aClass.getName() = " + aClass.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}


