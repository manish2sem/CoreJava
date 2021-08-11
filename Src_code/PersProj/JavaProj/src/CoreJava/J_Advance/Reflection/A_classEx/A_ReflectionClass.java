package CoreJava.J_Advance.Reflection.A_classEx;
/**
Before you can do any inspection on a class you need to obtain its java.lang.Class object. 
All types in Java including the primitive types (int, long, float etc.)
 including arrays have an associated Class object. 

If you know the name of the class at compile time you can obtain a Class object like this:
	Class myObjectClass = MyObject.class

If you don't know the name at compile time, but have the class name as a string at runtime,
Use Class.forName to obtain the class object.
	Class class = Class.forName(className);
The Class.forName() method may throw a ClassNotFoundException if the class cannot be found on the classpath at runtime.

From a Class object you can obtain its name in two versions. 
	getName() - Gives the fully qualified class name 
	getSimpleName() - Only class name without the pacakge name 

*/


public class A_ReflectionClass {
	public static void main(String[] args) {
		DemoClass demoClass = new DemoClass();
		System.out.println("B4 class ");

	    Class myObjectClass = DemoClass.class;
		System.out.println("class name : "+myObjectClass.getSimpleName());
		System.out.println("Fully qualified class name : "+myObjectClass.getName());

	    
	    String fullyQualifiedClassName = "CoreJava.J_Advance.Reflection.A_classEx.DemoClass";
	    try {
			System.out.println("B4 fullyQualifiedClassName");
			Class classObj = Class.forName(fullyQualifiedClassName);
			System.out.println("class name : "+classObj.getSimpleName());
			System.out.println("Fully qualified class name : "+classObj.getName());

		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			e.printStackTrace();
		}

	}

}


class DemoClass {
    public String demoMethod(String demoParam) {
        System.out.println("Parameter passed: " + demoParam);
         
        return DemoClass.class.getName();
    }
}
